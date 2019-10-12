package com.bhavyakaria.fetchusercontacts;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.util.Log;
import android.util.LongSparseArray;

import androidx.annotation.NonNull;

import com.bhavyakaria.fetchusercontacts.models.ContactModel;

import static com.bhavyakaria.fetchusercontacts.ColumnMapper.mapDisplayName;
import static com.bhavyakaria.fetchusercontacts.ColumnMapper.mapEmail;
import static com.bhavyakaria.fetchusercontacts.ColumnMapper.mapPhoneNumbers;
import static com.bhavyakaria.fetchusercontacts.ColumnMapper.mapPhoto;
import static com.bhavyakaria.fetchusercontacts.ColumnMapper.mapStarred;

public class ContactsManager {

    private static final String[] PROJECTION = {
            ContactsContract.Data._ID,
            ContactsContract.Data.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.Data.STARRED,
            ContactsContract.Data.PHOTO_URI,
            ContactsContract.Data.PHOTO_THUMBNAIL_URI,
            ContactsContract.Data.DATA1,
            ContactsContract.Data.MIMETYPE,
            ContactsContract.Data.IN_VISIBLE_GROUP
    };

    private ContentResolver resolver;

    public ContactsManager(@NonNull Context context) {
        this.resolver = context.getContentResolver();
    }

    public LongSparseArray<ContactModel> fetchContacts() {

        LongSparseArray<ContactModel> contacts = new LongSparseArray<>();
        Cursor cursor = createCursor();

        cursor.moveToFirst();

        // get column indexes
        int idxId = cursor.getColumnIndex(ContactsContract.Data.CONTACT_ID);
        int idxPrimaryName = cursor.getColumnIndex(ContactsContract.Data.DISPLAY_NAME);
        int idxStarred = cursor.getColumnIndex(ContactsContract.Data.STARRED);
        int idxphoto = cursor.getColumnIndex(ContactsContract.Data.PHOTO_URI);
        int idxMimetype = cursor.getColumnIndex(ContactsContract.Data.MIMETYPE);
        int idxData1 = cursor.getColumnIndex(ContactsContract.Data.DATA1);

        while (!cursor.isAfterLast()) {

            // get the id and the contact for this id. The contact may be null
            long id = cursor.getLong(idxId);

            ContactModel contact = contacts.get(id, null);
            if (contact == null) {
                // create a new contact
                contact = new ContactModel(id);
                mapDisplayName(cursor, contact, idxPrimaryName);
                mapPhoto(cursor, contact, idxphoto);
                mapStarred(cursor, contact, idxStarred);
                contacts.put(id, contact);
            }

            int idxPhoneNumber = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
//            Log.d("Parzival", "Data: "+cursor.getString(idxPhoneNumber));
            // map email or phone numbers
            String mimeType = cursor.getString(idxMimetype);
            switch (mimeType) {
                case ContactsContract.CommonDataKinds.Email.CONTENT_ITEM_TYPE: {
                    mapEmail(cursor, contact, idxData1);
                    break;
                }

                case ContactsContract.CommonDataKinds.Phone.CONTENT_ITEM_TYPE: {
                    mapPhoneNumbers(cursor, contact, idxData1);
                    break;
                }
            }
            cursor.moveToNext();
        }
        cursor.close();

        return contacts;
    }

    private Cursor createCursor() {
        return resolver.query(
                ContactsContract.Data.CONTENT_URI,
                PROJECTION,
                null,
                null,
                ContactsContract.Data.CONTACT_ID
        );
    }
}
