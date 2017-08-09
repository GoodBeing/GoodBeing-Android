package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by jik on 2017-07-26.
 */


public class SurveyWriteFragment_One_2 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N6_rg;
    private EditText surveywriteActivity_Fragment_One_N6_et;
    private RadioGroup surveywriteActivity_Fragment_One_N7_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N8_rg;



    public SurveyWriteFragment_One_2() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_2 newInstance(int sectionNumber) {
        SurveyWriteFragment_One_2 fragment = new SurveyWriteFragment_One_2();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_2, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        surveywriteActivity_Fragment_One_N6_rg = (RadioGroup) rootView.findViewById(R.id.one_N6);
        surveywriteActivity_Fragment_One_N6_et = (EditText) rootView.findViewById(R.id.one_N6_familynumber);

        surveywriteActivity_Fragment_One_N7_rg = (RadioGroup) rootView.findViewById(R.id.one_N7);
        surveywriteActivity_Fragment_One_N8_rg = (RadioGroup) rootView.findViewById(R.id.one_N8);

        surveywriteActivity_Fragment_One_N6_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i)
                {
                    case R.id.one_N6_1:
                        break;
                    case R.id.one_N6_2:
                        break;
                }
            }
        });

        surveywriteActivity_Fragment_One_N7_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i)
                {
                    case R.id.one_N7_1:
                        break;
                    case R.id.one_N7_2:
                        break;
                    case R.id.one_N7_3:
                        break;
                    case R.id.one_N7_4:
                        break;

                }
            }
        });
        surveywriteActivity_Fragment_One_N8_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i)
                {
                    case R.id.one_N8_1:
                        break;
                    case R.id.one_N8_2:
                        break;
                }
            }
        });




        return rootView;
    }


}