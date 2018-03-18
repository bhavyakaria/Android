package sampleapplication.parzival.com.sampleapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {

    TextView visibletxt, colortxt, sizetxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visibletxt = findViewById(R.id.visible_text);
        colortxt = findViewById(R.id.color_text);
        sizetxt = findViewById(R.id.size_text);

        setupSharedPreferences();
    }

    private void setupSharedPreferences() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    // Method to set Visibility of Text.
    private void setTextVisible(boolean display_text) {
        if (display_text == true) {
            visibletxt.setVisibility(View.VISIBLE);
        } else {
            visibletxt.setVisibility(View.INVISIBLE);
        }
    }

    // Method to set Color of Text.
    private void changeTextColor(String pref_color_value) {
        Log.d("Parzival", pref_color_value);
        if (pref_color_value.equals("red")) {
            colortxt.setTextColor(Color.RED);
        } else if(pref_color_value.equals("green")) {
            colortxt.setTextColor(Color.GREEN);
        } else {
            colortxt.setTextColor(Color.BLUE);
        }
    }

    // Method to set Size of Text.
    private void changeTextSize(Float i) {
        sizetxt.setTextSize(i);
    }

    // Method to pass value from SharedPreferences
    private void loadColorFromPreference(SharedPreferences sharedPreferences) {
        Log.d("Parzival",sharedPreferences.getString(getString(R.string.pref_color_key),getString(R.string.pref_color_red_value)));
        changeTextColor(sharedPreferences.getString(getString(R.string.pref_color_key),getString(R.string.pref_color_red_value)));
    }

    private void loadSizeFromPreference(SharedPreferences sharedPreferences) {
        float minSize = Float.parseFloat(sharedPreferences.getString(getString(R.string.pref_size_key), "16.0"));
        changeTextSize(minSize);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {

        if (key.equals("display_text")) {
            setTextVisible(sharedPreferences.getBoolean("display_text",true));
        } else if (key.equals("color")) {
            loadColorFromPreference(sharedPreferences);
        } else if (key.equals("size"))  {
            loadSizeFromPreference(sharedPreferences);
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.support.v7.preference.PreferenceManager.getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

}
