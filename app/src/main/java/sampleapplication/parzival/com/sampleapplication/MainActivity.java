package sampleapplication.parzival.com.sampleapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAlertDialog = findViewById(R.id.btn_alert);
        Button btnMaterialAlertDialog = findViewById(R.id.btn_material_alert_dialog);

        Button btnSimpleDialog = findViewById(R.id.btn_simple_dialog);
        Button btnMaterialSimpleDialog = findViewById(R.id.btn_material_simple_dialog);

        // simple alert dialog
        btnAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireMissileDialogFragment dialogFragment = new FireMissileDialogFragment();
                dialogFragment.show(getSupportFragmentManager(), "missiles");
            }
        });

        // material alert dialog
        btnMaterialAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FireMissileMaterialDialogFragment dialogFragment = new FireMissileMaterialDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"missiles");
            }
        });

        // simple select dialog
        btnSimpleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectColorDialogFragment dialogFragment = new SelectColorDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"colors");
            }
        });

        // material select dialog
        btnMaterialSimpleDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SelectColorMaterialDialogFragment dialogFragment = new SelectColorMaterialDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"colors");
            }
        });




    }


}
