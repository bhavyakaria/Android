package com.bhavyakaria.compoundviews;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
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
            button_one.showProgressBar();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // Do something after 5s = 5000ms
                    button_one.hideProgressBar();
                    button_one.showStatusText("Your pan card has been uploaded");
                }
            }, 5000);

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
