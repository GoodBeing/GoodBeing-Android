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


public class SurveyWriteFragment_One_10 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N29_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N30_rg;

    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;



    public SurveyWriteFragment_One_10() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_10 newInstance(int sectionNumber) {
        SurveyWriteFragment_One_10 fragment = new SurveyWriteFragment_One_10();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_10, container, false);

        surveywriteActivity_Fragment_One_N29_rg = (RadioGroup) rootView.findViewById(R.id.one_N29);
        surveywriteActivity_Fragment_One_N30_rg = (RadioGroup) rootView.findViewById(R.id.one_N30);


        surveywriteActivity_Fragment_One_N29_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N29_1:
                        surveyitem1 = new SurveyItem(8,1 , "",1 );
                        arr.set(28,surveyitem1);
                        break;
                    case R.id.one_N29_2:
                        surveyitem1 = new SurveyItem(8, 2, "",2 );
                        arr.set(28,surveyitem1);
                        break;
                    case R.id.one_N29_3:
                        surveyitem1 = new SurveyItem(8, 3, "",3 );
                        arr.set(28,surveyitem1);
                        break;
                    case R.id.one_N29_4:
                        surveyitem1 = new SurveyItem(8,4 , "",4 );
                        arr.set(28,surveyitem1);
                        break;
                    case R.id.one_N29_5:
                        surveyitem1 = new SurveyItem(8,5 , "", 5);
                        arr.set(28,surveyitem1);
                        break;
                    case R.id.one_N29_6:
                        surveyitem1 = new SurveyItem(8, 6, "", 6);
                        arr.set(28,surveyitem1);
                        break;

                }
            }
        });

        surveywriteActivity_Fragment_One_N30_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N30_1:
                        surveyitem2 = new SurveyItem(8,1 , "",1 );
                        arr.set(29,surveyitem2);
                        break;
                    case R.id.one_N30_2:
                        surveyitem2 = new SurveyItem(8, 2, "",2 );
                        arr.set(29,surveyitem2);
                        break;
                    case R.id.one_N30_3:
                        surveyitem2 = new SurveyItem(8,3 , "",3 );
                        arr.set(29,surveyitem2);
                        break;
                    case R.id.one_N30_4:
                        surveyitem2 = new SurveyItem(8, 4, "",4 );
                        arr.set(29,surveyitem2);
                        break;
                    case R.id.one_N30_5:
                        surveyitem2 = new SurveyItem(8,5 , "",5 );
                        arr.set(29,surveyitem2);
                        break;
                }
            }
        });




        return rootView;
    }


}