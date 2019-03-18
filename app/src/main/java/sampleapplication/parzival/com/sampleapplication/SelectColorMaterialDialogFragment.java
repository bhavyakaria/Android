package sampleapplication.parzival.com.sampleapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SelectColorMaterialDialogFragment extends DialogFragment {

    //private String[] colors = getActivity().getResources().getStringArray(R.array.colors);
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(getActivity());
        builder.setTitle("Select Color")
                .setItems(R.array.colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Selected "+which,Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
