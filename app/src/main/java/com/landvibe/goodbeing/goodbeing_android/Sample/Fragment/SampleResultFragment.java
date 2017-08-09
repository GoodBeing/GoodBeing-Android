package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.landvibe.goodbeing.goodbeing_android.R;

public class SampleResultFragment extends Fragment {

    public SampleResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sample_result, container, false);

        Button retryButton = (Button)view.findViewById(R.id.sample_result_retry_button);

        Button backButton = (Button)view.findViewById(R.id.sample_result_back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });

        return view;
    }
}
