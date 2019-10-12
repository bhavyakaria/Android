package com.bhavyakaria.compoundviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ClickListener{

    CustomButton button_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_one = findViewById(R.id.button_one);
        button_one.setListener(this);
    }

    @Override
    public void onUploadButtonClicked(View v, int id) {
        if (id == button_one.getId()) {

        }
        Toast.makeText(getApplicationContext(), "Button Clicked "+id+" -- "+button_one.getId(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
