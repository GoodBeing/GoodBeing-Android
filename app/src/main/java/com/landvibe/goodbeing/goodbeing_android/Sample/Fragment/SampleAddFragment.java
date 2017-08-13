package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by KSM on 2017-08-06.
 */

public class SampleAddFragment extends android.support.v4.app.Fragment {
    private TextView survey_date;
    private TextView survey_score;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_add, container, false);

        survey_date = (TextView)view.findViewById(R.id.sample_add_survey_date);
        survey_score = (TextView)view.findViewById(R.id.sample_add_survey_score);

        ArrayList<String> sampleList = new ArrayList<>();
        sampleList.add("설문 결과 1");
        sampleList.add("설문 결과 2");

        Spinner spinner = (Spinner)view.findViewById(R.id.sample_add_survey_result);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                survey_date.setText("2017-01-0" + position);
                survey_score.setText(position + "점");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,sampleList);
        spinner.setAdapter(adapter);

        return view;
    }
}
