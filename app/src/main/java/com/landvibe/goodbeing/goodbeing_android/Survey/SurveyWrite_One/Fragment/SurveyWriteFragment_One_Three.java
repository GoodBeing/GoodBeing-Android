package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyConnectServer;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyResultActiviy;

/**
 * Created by jik on 2017-07-26.
 */



public  class SurveyWriteFragment_One_Three extends Fragment implements View.OnClickListener {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private Button RealsurveywirteActivity_thirdfrgment_ok_btn;
    private static final String ARG_SECTION_NUMBER = "section_number";
    public SurveyWriteFragment_One_Three() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_Three newInstance(int sectionNumber) {
        SurveyWriteFragment_One_Three fragment = new SurveyWriteFragment_One_Three();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.survey_fragment_one_question_one, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        RealsurveywirteActivity_thirdfrgment_ok_btn = (Button) rootView.findViewById(R.id.ok_btn);
        RealsurveywirteActivity_thirdfrgment_ok_btn.setOnClickListener(this);
        return rootView;
    }





    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.ok_btn)
        {
            SurveyConnectServer SCS = new SurveyConnectServer();
            //유저 id ,설문 코드, 점수
            //SCS.sendSurvey();

            Intent intent = new Intent(getActivity() , SurveyResultActiviy.class);
            startActivity(intent);
        }
    }
}