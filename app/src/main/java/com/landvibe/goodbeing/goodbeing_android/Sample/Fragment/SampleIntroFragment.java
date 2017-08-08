package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by KSM on 2017-08-06.
 */

public class SampleIntroFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_intro, container, false);

        Button button = (Button)view.findViewById(R.id.sample_intro_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.sample_main_frame_layout, new SampleMainFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
