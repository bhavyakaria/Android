package sampleapplication.parzival.com.sampleapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Parzival on 10-03-2018.
 */

public class FragmentOne extends Fragment {

    private Button btn1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Just  like setContentView in Activity
        View view  = inflater.inflate(R.layout.fragment_one_layout, container, false);

        //findViewById needs to add view
        btn1 = view.findViewById(R.id.btn_one);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).setViewPager(1);
            }
        });


        return view;
    }
}
