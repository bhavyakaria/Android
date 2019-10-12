package com.bhavyakaria.fetchusercontacts;

import android.database.Cursor;
import android.net.Uri;

import com.bhavyakaria.fetchusercontacts.models.ContactModel;

public class ColumnMapper {

    //utility class no instance allowed
    private ColumnMapper () { }

    static void mapDisplayName(Cursor cursor, ContactModel contactModel, int columnIndex) {
        String displayname = cursor.getString(columnIndex);
        if (displayname != null && !displayname.isEmpty()) {
            contactModel.setDisplayName(displayname);
        }
    }

    static void mapEmail (Cursor cursor, ContactModel contactModel, int columnIndex) {
        String email = cursor.getString(columnIndex);
        if (email != null && !email.isEmpty()) {
            contactModel.setEmail(email);
        }
    }

    static void mapStarred (Cursor cursor, ContactModel contactModel, int columnIndex) {
        contactModel.setStarred(cursor.getInt(columnIndex) != 0);
    }

    static void mapPhoneNumbers(Cursor cursor, ContactModel contactModel, int columnIndex) {
        String phoneNumber = cursor.getString(columnIndex);
        if (phoneNumber != null && !phoneNumber.isEmpty()) {
            phoneNumber = phoneNumber.replaceAll("\\s+", "");
            contactModel.setPhoneNumber(phoneNumber);
        }
    }

    static void mapPhoto(Cursor cursor, ContactModel contactModel, int columnIndex) {
        String photoUri = cursor.getString(columnIndex);
        if (photoUri != null && !photoUri.isEmpty()) {
            contactModel.setPhoto(Uri.parse(photoUri));
        }
    }
}
