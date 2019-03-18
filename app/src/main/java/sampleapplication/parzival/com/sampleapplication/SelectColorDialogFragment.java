package sampleapplication.parzival.com.sampleapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SelectColorDialogFragment extends DialogFragment {

    //private String[] colors = getContext().getResources().getStringArray(R.array.colors);

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Select a color")
                .setItems(R.array.colors, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(),"Selected "+which,Toast.LENGTH_SHORT).show();
                    }
                });
        return builder.create();
    }
}
