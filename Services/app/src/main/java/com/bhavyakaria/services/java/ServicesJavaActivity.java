package com.bhavyakaria.services.java;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bhavyakaria.services.R;

public class ServicesJavaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_java);

        final Button startService = findViewById(R.id.btn_start_service);
        final Button stopService = findViewById(R.id.btn_stop_service);

        startService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // start the service from SampleService class
                startService(new Intent(getBaseContext(), SampleService.class));
            }
        });

        stopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // stop the service from SampleService class
                stopService(new Intent(getBaseContext(), SampleService.class));
            }
        });

    }
}
