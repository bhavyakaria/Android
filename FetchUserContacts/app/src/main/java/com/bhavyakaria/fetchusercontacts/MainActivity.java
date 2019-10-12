package com.bhavyakaria.fetchusercontacts;

import android.os.Bundle;
import android.util.Log;
import android.util.LongSparseArray;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bhavyakaria.fetchusercontacts.models.ContactModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView contact_list_view;
    LongSparseArray<ContactModel> listOfContacts = new LongSparseArray<ContactModel>();
    ArrayList<String> names = new ArrayList<>();

    ContactsManager contactsManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsManager = new ContactsManager(this);

        contact_list_view = findViewById(R.id.contact_list);

        listOfContacts = contactsManager.fetchContacts();

        //Log.d("Parzival", "Size: "+listOfContacts.size());
        for (int i=0; i < listOfContacts.size(); i++) {
            if (listOfContacts.get(i) != null) {
                names.add(listOfContacts.get(i).getDisplayName());
                Log.d("Parzival", "Data: "+listOfContacts.get(i).toString());
            }
        }

//        Log.d("Parzival", "Size: "+names.size());
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                R.layout.contacts_list_item,  names);
//
//        // Assign adapter to ListView
//        contact_list_view.setAdapter(adapter);


    }

}
