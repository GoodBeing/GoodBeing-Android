package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by jik on 2017-07-26.
 */

public class SurveyWriteFragment_One_1 extends Fragment implements View.OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private EditText surveywriteActivity_Fragment_One_age_et;
    private RadioGroup surveywriteActivity_Fragment_One_N2_rg;


    private EditText surveywriteActivity_Fragment_One_height_et;
    private EditText surveywriteActivity_Fragment_One_weight_et;
    private Button surveywriteActivity_Fragment_One_calBMI_button;
    private TextView surveywriteActivity_Fragment_One_BMIresult_tv;

    private EditText surveywriteActivity_Fragment_One_N5_et;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_1, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));


        surveywriteActivity_Fragment_One_age_et = (EditText) rootView.findViewById(R.id.age);

        surveywriteActivity_Fragment_One_N2_rg = (RadioGroup) rootView.findViewById(R.id.one_N2);
        surveywriteActivity_Fragment_One_N2_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                     switch(i)
                     {
                         case R.id.one_N2_1:
                             break;
                         case R.id.one_N2_2:
                             break;
                     }
            }
        });


        surveywriteActivity_Fragment_One_height_et = (EditText) rootView.findViewById(R.id.height);
        surveywriteActivity_Fragment_One_weight_et = (EditText) rootView.findViewById(R.id.weight);
        surveywriteActivity_Fragment_One_BMIresult_tv = (TextView) rootView.findViewById(R.id.BMI_result);

        surveywriteActivity_Fragment_One_calBMI_button = (Button) rootView.findViewById(R.id.cal_btn);
        surveywriteActivity_Fragment_One_calBMI_button.setOnClickListener(this);

        surveywriteActivity_Fragment_One_N5_et = (EditText) rootView.findViewById(R.id.one_N5);




        return rootView;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.cal_btn) {
            String heightString = surveywriteActivity_Fragment_One_height_et.getText().toString();
            double height = 0;
            height = Integer.parseInt(heightString);

            String weightString = surveywriteActivity_Fragment_One_weight_et.getText().toString();
            double weight = 0;
            weight = Integer.parseInt(weightString);

            double result = weight / ((height / 100) * (height / 100));

            String re = "";
            if (result >= 30)
                re = "비만";
            else if (result >= 25 && result < 30)
                re = "과체중";
            else if (result >= 18.5 && result < 25)
                re = "정상";
            else
                re = "저체중";

           surveywriteActivity_Fragment_One_BMIresult_tv.setText("당신은 " + re + "입니다.");
        }
    }
}