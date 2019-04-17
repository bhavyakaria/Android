package sampleapplication.parzival.com.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PopInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_in);
        overridePendingTransition(R.anim.animate_card_enter, R.anim.animate_card_exit);
    }
}
