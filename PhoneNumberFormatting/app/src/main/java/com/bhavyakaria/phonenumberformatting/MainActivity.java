package com.bhavyakaria.phonenumberformatting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

public class MainActivity extends AppCompatActivity {

    String phoneNumber = "9768736312334";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();

        Phonenumber.PhoneNumber indianPhoneNumber = null;

        try {
            indianPhoneNumber = phoneNumberUtil.parse(phoneNumber, "IN");
            boolean val = phoneNumberUtil.isValidNumber(indianPhoneNumber);
            Log.d("Parzival", "Data: "+indianPhoneNumber.getCountryCode()+" >> "+indianPhoneNumber.getNationalNumber());
            Log.d("Parzival", "Val: "+val);
        } catch (NumberParseException e) {
            e.printStackTrace();
        }

    }
}
