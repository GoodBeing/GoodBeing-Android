package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Activity.SurveyWriteActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item.SurveyItem;

import java.util.ArrayList;

/**
 * Created by jik on 2017-07-26.
 */


public class SurveyWriteFragment_One_6 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N18_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N19_rg;

    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;



    public SurveyWriteFragment_One_6() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_6 newInstance(int sectionNumber) {
        SurveyWriteFragment_One_6 fragment = new SurveyWriteFragment_One_6();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_6, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        surveywriteActivity_Fragment_One_N18_rg = (RadioGroup) rootView.findViewById(R.id.one_N18);
        surveywriteActivity_Fragment_One_N19_rg = (RadioGroup) rootView.findViewById(R.id.one_N19);


        surveywriteActivity_Fragment_One_N18_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                switch(i)
                {
                    case R.id.one_N18_1:
                        surveyitem1 = new SurveyItem(8, 1, "", 1);
                        arr.set(17,surveyitem1);
                        break;
                    case R.id.one_N18_2:
                        surveyitem1 = new SurveyItem(8, 2, "", 2);
                        arr.set(17,surveyitem1);
                        break;
                    case R.id.one_N18_3:
                        surveyitem1 = new SurveyItem(8, 3, "", 3);
                        arr.set(17,surveyitem1);
                        break;
                    case R.id.one_N18_4:
                        surveyitem1 = new SurveyItem(8, 4, "", 4);
                        arr.set(17,surveyitem1);
                        break;
                }
            }
        });

        surveywriteActivity_Fragment_One_N19_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N19_1:
                        surveyitem2 = new SurveyItem(8, 1, "", 1);
                        arr.set(18,surveyitem2);
                        break;
                    case R.id.one_N19_2:
                        surveyitem2 = new SurveyItem(8, 2, "", 2);
                        arr.set(18,surveyitem2);
                        break;
                    case R.id.one_N19_3:
                        surveyitem2 = new SurveyItem(8, 3, "", 3);
                        arr.set(18,surveyitem2);
                        break;
                    case R.id.one_N19_4:
                        surveyitem2 = new SurveyItem(8, 4, "", 4);
                        arr.set(18,surveyitem2);
                        break;
                }
            }
        });




        return rootView;
    }


}