package com.bhavyakaria.fetchusercontacts;

import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ListView contact_list_view;
    Map<String, String> namePhoneMap = new HashMap<String, String>();
    String[] names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_list_view = findViewById(R.id.contact_list);

        namePhoneMap = getPhoneNumbers();

        names = new String[namePhoneMap.size()];

        int i=0;
        for (Map.Entry<String, String> entry : namePhoneMap.entrySet()) {
            names[i] = entry.getValue()+" -> "+entry.getKey();
            i++;
        }


        Log.d("Parzival", "Size: "+namePhoneMap.size());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.contacts_list_item,  names);

        // Assign adapter to ListView
        contact_list_view.setAdapter(adapter);


    }

    private Map<String, String> getPhoneNumbers() {

        Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME+" ASC");

        // Loop Through All The Numbers
        while (phones != null && phones.moveToNext()) {

            String name = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

            // Cleanup the phone number
            phoneNumber = phoneNumber.replaceAll("[()\\s-]+", "");

            // Enter Into Hash Map
            namePhoneMap.put(phoneNumber, name);

        }
        phones.close();

        return namePhoneMap;

    }

}
