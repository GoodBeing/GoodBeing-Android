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


public class SurveyWriteFragment_One_15 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N42_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N43_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N44_rg;

    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;



    public SurveyWriteFragment_One_15() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_15 newInstance(int sectionNumber) {
        SurveyWriteFragment_One_15 fragment = new SurveyWriteFragment_One_15();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_15, container, false);

        surveywriteActivity_Fragment_One_N42_rg = (RadioGroup) rootView.findViewById(R.id.one_N42);
        surveywriteActivity_Fragment_One_N43_rg = (RadioGroup) rootView.findViewById(R.id.one_N43);
        surveywriteActivity_Fragment_One_N44_rg = (RadioGroup) rootView.findViewById(R.id.one_N44);


        surveywriteActivity_Fragment_One_N42_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N42_1:
                        surveyitem1 = new SurveyItem(2, 1, "",1 );
                        arr.set(41,surveyitem1);
                        break;
                    case R.id.one_N42_2:
                        surveyitem1 = new SurveyItem(2,2 , "",2 );
                        arr.set(41,surveyitem1);
                        break;
                    case R.id.one_N42_3:
                        surveyitem1 = new SurveyItem(2,3 , "", 3);
                        arr.set(41,surveyitem1);
                        break;
                    case R.id.one_N42_4:
                        surveyitem1 = new SurveyItem(2, 4, "",4 );
                        arr.set(41,surveyitem1);
                        break;

                }
            }
        });

        surveywriteActivity_Fragment_One_N43_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N43_1:
                        surveyitem2 = new SurveyItem(2, 1, "",1 );
                        arr.set(42,surveyitem2);
                        break;
                    case R.id.one_N43_2:
                        surveyitem2 = new SurveyItem(2,2 , "",2 );
                        arr.set(42,surveyitem2);
                        break;
                    case R.id.one_N43_3:
                        surveyitem2 = new SurveyItem(2,3 , "",3 );
                        arr.set(42,surveyitem2);
                        break;
                    case R.id.one_N43_4:
                        surveyitem2 = new SurveyItem(2,4 , "",5 );
                        arr.set(42,surveyitem2);
                        break;

                }
            }
        });

        surveywriteActivity_Fragment_One_N44_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N44_1:
                        surveyitem3 = new SurveyItem(5, 1, "",1 );
                        arr.set(43,surveyitem3);
                        break;
                    case R.id.one_N44_2:
                        surveyitem3 = new SurveyItem(5,2 , "",2 );
                        arr.set(43,surveyitem3);
                        break;
                    case R.id.one_N44_3:
                        surveyitem3 = new SurveyItem(5,3 , "", 3);
                        arr.set(43,surveyitem3);
                        break;

                }
            }
        });




        return rootView;
    }


}