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


public class SurveyWriteFragment_One_4 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N12_rg;
    private EditText surveywriteActivity_Fragment_One_N12_et;
    private RadioGroup surveywriteActivity_Fragment_One_N13_rg;

    private EditText surveywriteActivity_Fragment_One_N14_1_et;
    private EditText surveywriteActivity_Fragment_One_N14_2_et;
    private EditText surveywriteActivity_Fragment_One_N14_3_et;
    private EditText surveywriteActivity_Fragment_One_N14_4_et;


    public SurveyWriteFragment_One_4() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_4 newInstance(int sectionNumber) {
        SurveyWriteFragment_One_4 fragment = new SurveyWriteFragment_One_4();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_4, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        surveywriteActivity_Fragment_One_N12_rg = (RadioGroup) rootView.findViewById(R.id.one_N12);
        surveywriteActivity_Fragment_One_N12_et = (EditText) rootView.findViewById(R.id.one_N12_q);

        surveywriteActivity_Fragment_One_N13_rg = (RadioGroup) rootView.findViewById(R.id.one_N13);

        surveywriteActivity_Fragment_One_N14_1_et = (EditText) rootView.findViewById(R.id.one_N14_1);
        surveywriteActivity_Fragment_One_N14_2_et = (EditText) rootView.findViewById(R.id.one_N14_2);
        surveywriteActivity_Fragment_One_N14_3_et = (EditText) rootView.findViewById(R.id.one_N14_3);
        surveywriteActivity_Fragment_One_N14_4_et = (EditText) rootView.findViewById(R.id.one_N14_4);

        surveywriteActivity_Fragment_One_N12_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i)
                {
                    case R.id.one_N12_1:
                        break;
                    case R.id.one_N12_2:
                        break;
                    case R.id.one_N12_3:
                        break;
                }
            }
        });

        surveywriteActivity_Fragment_One_N13_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch(i)
                {
                    case R.id.one_N13_1:
                        break;
                    case R.id.one_N13_2:
                        break;


                }
            }
        });




        return rootView;
    }


}