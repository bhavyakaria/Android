package com.bhavyakaria.notifications.java;

import android.app.Notification;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.bhavyakaria.notifications.App;
import com.bhavyakaria.notifications.R;

public class NotificationJavaActivity extends AppCompatActivity {

    Button btnSimpleNotification, btnPushNotification;
    private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_java);

        btnSimpleNotification = findViewById(R.id.btn_simple_notification);
        btnPushNotification = findViewById(R.id.btn_push_notification);

        notificationManagerCompat = NotificationManagerCompat.from(this);

        btnSimpleNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification notification = new NotificationCompat.Builder(getApplicationContext(), App.CHANNEL_1_ID)
                        .setSmallIcon(R.drawable.ic_launcher_background)
                        .setContentTitle("A sample Notification")
                        .setContentText("Wassup bro")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_EVENT)
                        .build();
                notificationManagerCompat.notify(1, notification);
            }
        });



    }
}
