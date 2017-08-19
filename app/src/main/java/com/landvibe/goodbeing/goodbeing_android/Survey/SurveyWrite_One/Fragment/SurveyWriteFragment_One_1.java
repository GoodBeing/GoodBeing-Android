package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Activity.SurveyWriteActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.BackPressEditText;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item.SurveyItem;

import java.util.ArrayList;

/**
 * Created by jik on 2017-07-26.
 */

public class SurveyWriteFragment_One_1 extends Fragment implements View.OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private ArrayList<SurveyItem> m_surveyitemArrayList;
    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;
    private SurveyItem surveyitem4;
    private SurveyItem surveyitem5;

    private EditText surveywriteActivity_Fragment_One_age_et;
    private RadioGroup surveywriteActivity_Fragment_One_N2_rg;
    private EditText surveywriteActivity_Fragment_One_height_et;
    private EditText surveywriteActivity_Fragment_One_weight_et;
    private BackPressEditText surveywriteActivity_Fragment_One_N5_et;
    View rootView;
    private int score=0;


    public SurveyWriteFragment_One_1() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_1 newInstance(int sectionNumber) {
        SurveyWriteFragment_One_1 fragment = new SurveyWriteFragment_One_1();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("aaaaaaaaa fragment1 : "," oncreateview");

         rootView = inflater.inflate(R.layout.survey_fragment_one_1, container, false);
        surveywriteActivity_Fragment_One_N2_rg = (RadioGroup) rootView.findViewById(R.id.one_N2);

        surveywriteActivity_Fragment_One_age_et = (EditText) rootView.findViewById(R.id.age);
        surveywriteActivity_Fragment_One_height_et = (EditText) rootView.findViewById(R.id.height);
        surveywriteActivity_Fragment_One_weight_et = (EditText) rootView.findViewById(R.id.weight);
        surveywriteActivity_Fragment_One_N5_et = (BackPressEditText) rootView.findViewById(R.id.one_N5);
        surveywriteActivity_Fragment_One_N5_et.setOnFocusChangeListener(onBackPressListener);


        surveywriteActivity_Fragment_One_age_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(surveywriteActivity_Fragment_One_age_et.getText().toString()!=null)
                {
                    if (b == false) {

                        int age = Integer.parseInt(surveywriteActivity_Fragment_One_age_et.getText().toString());
                        if (age < 50)
                            score = 1;
                        else if (age >= 50)
                            score = 2;


                        surveyitem1 = new SurveyItem(1, 0, surveywriteActivity_Fragment_One_age_et.getText().toString(), score);
                        ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                      arr.set(0,surveyitem1);
                    }
                    Log.d("aaaaaaaaa1", "" + 4);
                }
            }
        });

        surveywriteActivity_Fragment_One_weight_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                if(surveywriteActivity_Fragment_One_height_et.getText().toString()!=null&&surveywriteActivity_Fragment_One_weight_et.getText().toString()!=null)
                {
                    if (b == false) {


                        int height = Integer.parseInt(surveywriteActivity_Fragment_One_height_et.getText().toString());
                        int weight = Integer.parseInt(surveywriteActivity_Fragment_One_weight_et.getText().toString());
                        int bmi = weight / (height * height);
                        if (bmi < 25)
                            score = 1;
                        else if (bmi >= 50 && bmi <= 30)
                            score = 2;
                        else if (bmi > 30)
                            score = 3;

                        surveyitem3 = new SurveyItem(0, 0, surveywriteActivity_Fragment_One_height_et.getText().toString(), 0);
                        surveyitem4 = new SurveyItem(1, 0, surveywriteActivity_Fragment_One_weight_et.getText().toString(), score);
                        Log.d("aaaaaaaaa1", "" + 6);
                        ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                        arr.set(2,surveyitem3);
                        arr.set(3,surveyitem4);
                    }
                    Log.d("aaaaaaaaa1", "" + 4);
                }
            }
        });

        surveywriteActivity_Fragment_One_N2_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                switch (i) {

                    case R.id.one_N2_1:
                        surveyitem2 = new SurveyItem(1, 1, "", 1);
                        arr.set(1,surveyitem2);
                        break;
                    case R.id.one_N2_2:
                        surveyitem2 = new SurveyItem(1, 2, "", 2);
                        arr.set(1,surveyitem2);
                        break;
                }
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d("aaaaaaaaa fragment1 : "," onresume");


    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("aaaaaaaaa fragment1 : "," onpause");


    }

    @Override
    public void onClick(View view) {
    }


    private void didBackPressOnEditText()
    {   Log.d("vvvvvv","  didback");
        if(surveywriteActivity_Fragment_One_N5_et.getText().toString()!=null) {

            int N5 = Integer.parseInt(surveywriteActivity_Fragment_One_N5_et.getText().toString());
            if (N5 <= 8)
                score = 1;
            else if (N5 > 8)
                score = 2;

            surveyitem5 = new SurveyItem(4, 0, surveywriteActivity_Fragment_One_N5_et.getText().toString(), score);
            ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

            arr.set(4,surveyitem5);

        }
    }

    private BackPressEditText.OnBackPressListener onBackPressListener = new BackPressEditText.OnBackPressListener()
    {
        @Override
        public void onBackPress()
        {
            didBackPressOnEditText();
        }
    };
}
