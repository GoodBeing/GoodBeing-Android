package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import com.landvibe.goodbeing.goodbeing_android.Main.ViewFlipperAction;
import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by KSM on 2017-08-06.
 */

public class SampleIntroFragment extends android.support.v4.app.Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_intro, container, false);

        ViewFlipper viewFlipper = (ViewFlipper)view.findViewById(R.id.sample_intro_view_flipper);

        View intro1 = inflater.inflate(R.layout.sample_intro1, viewFlipper, false);
        View intro2 = inflater.inflate(R.layout.sample_intro2, viewFlipper, false);
        View intro3 = inflater.inflate(R.layout.sample_intro3, viewFlipper, false);
        View intro4 = inflater.inflate(R.layout.sample_intro4, viewFlipper, false);

        viewFlipper.addView(intro1);
        viewFlipper.addView(intro2);
        viewFlipper.addView(intro3);
        viewFlipper.addView(intro4);

        viewFlipper.setOnTouchListener(new ViewFlipperAction(getActivity(), viewFlipper));

        Button button = (Button)view.findViewById(R.id.sample_intro_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.sample_main_frame_layout, new SampleAddFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
