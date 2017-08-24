package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyResultActiviy;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Activity.SurveyWriteActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item.SurveyItem;

import java.util.ArrayList;

/**
 * Created by jik on 2017-07-26.
 */



public  class SurveyWriteFragment_One_Last extends Fragment implements View.OnClickListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */

    private RadioGroup surveywriteActivity_Fragment_One_N45_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N46_rg;
    private Button surveywirteActivity_ok_btn;
    private Button surveywirteActivity_cancle_btn;
    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;

    private static final String ARG_SECTION_NUMBER = "section_number";
    public SurveyWriteFragment_One_Last() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_Last newInstance(int sectionNumber) {
        SurveyWriteFragment_One_Last fragment = new SurveyWriteFragment_One_Last();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.survey_fragment_one_question_last, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        surveywriteActivity_Fragment_One_N45_rg = (RadioGroup) rootView.findViewById(R.id.one_N45);
        surveywriteActivity_Fragment_One_N46_rg = (RadioGroup) rootView.findViewById(R.id.one_N46);

        surveywirteActivity_ok_btn = (Button) rootView.findViewById(R.id.ok_btn);
        surveywirteActivity_cancle_btn= (Button) rootView.findViewById(R.id.cancle_btn);
        surveywirteActivity_ok_btn.setOnClickListener(this);
        surveywirteActivity_cancle_btn.setOnClickListener(this);

        surveywriteActivity_Fragment_One_N45_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N45_1:
                        surveyitem1 = new SurveyItem(5, 1, "",1 );
                        arr.set(44,surveyitem1);
                        break;
                    case R.id.one_N45_2:
                        surveyitem1 = new SurveyItem(5, 2, "",2 );
                        arr.set(44,surveyitem1);
                        break;
                    case R.id.one_N45_3:
                        surveyitem1 = new SurveyItem(5, 3, "", 3);
                        arr.set(44,surveyitem1);
                        break;
                    case R.id.one_N45_4:
                        surveyitem1 = new SurveyItem(5, 4, "",4 );
                        arr.set(44,surveyitem1);
                        break;
                    case R.id.one_N45_5:
                        surveyitem1 = new SurveyItem(5, 5, "",5 );
                        arr.set(44,surveyitem1);
                        break;
                    case R.id.one_N45_6:
                        surveyitem1 = new SurveyItem(5, 6, "",6 );
                        arr.set(44,surveyitem1);
                        break;
                    case R.id.one_N45_7:
                        surveyitem1 = new SurveyItem(5, 7, "", 7);
                        arr.set(44,surveyitem1);
                        break;

                }
            }
        });

        surveywriteActivity_Fragment_One_N46_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N46_1:
                        surveyitem2 = new SurveyItem(7,1 , "",-1 );
                        arr.set(45,surveyitem2);
                        break;
                    case R.id.one_N46_2:
                        surveyitem2 = new SurveyItem(7,2 , "",-2 );
                        arr.set(45,surveyitem2);
                        break;
                    case R.id.one_N46_3:
                        surveyitem2 = new SurveyItem(7, 3, "",-3 );
                        arr.set(45,surveyitem2);
                        break;
                    case R.id.one_N46_4:
                        surveyitem2 = new SurveyItem(7,4 , "", -4);
                        arr.set(45,surveyitem2);
                        break;

                }
            }
        });


        return rootView;
    }





    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.ok_btn)
        {
            //유저 id ,설문 코드, 점수
            //SCS.sendSurvey();
            ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

            Intent intent = new Intent(getActivity() , SurveyResultActiviy.class);
            intent.putParcelableArrayListExtra("SURVEY_RESULT",arr);
            startActivity(intent);
        }
        else if(view.getId() == R.id.cancle_btn)
        {

            //유저 id ,설문 코드, 점수
            //SCS.sendSurvey();

            Intent intent = new Intent(getActivity() , SurveyResultActiviy.class);
            startActivity(intent);
        }
    }
}