package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.landvibe.goodbeing.goodbeing_android.DB.DBAdapter;
import com.landvibe.goodbeing.goodbeing_android.DB.DBManager;
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
    private float section_depoison =0;
    private float section_bodyhealth =0;
    private float section_stress =0;
    private float section_house =0;
    private float section_job =0;
    private float section_sleep =0;
    private float section_skin =0;
    private float section_main =0;


    private RadioGroup surveywriteActivity_Fragment_One_N45_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N46_rg;
    private Button surveywirteActivity_ok_btn;
    private Button surveywirteActivity_cancle_btn;
    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;
    DBAdapter dbAdapter;
    DBManager db;
    Context myContext;

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

        dbAdapter = new DBAdapter(getActivity());
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
            ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();


            float resultscore = 0;

            for(int i = 0;i<arr.size();i++)
            {            Log.d("score is : ",i + "번 점수는 "+arr.get(i).getScore());

                resultscore += arr.get(i).getScore();
            }
            resultscore = (float) (resultscore*0.7);

            cal8section(arr);


            String total = String.valueOf(resultscore);
            String s1 = String.valueOf(section_depoison);
            String s2 = String.valueOf(section_bodyhealth);
            String s3 = String.valueOf(section_stress);
            String s4 = String.valueOf(section_house);
            String s5 = String.valueOf(section_job);
            String s6 = String.valueOf(section_sleep);
            String s7 = String.valueOf(section_skin);
            String s8 = String.valueOf(section_main);


            Log.d("asdfDB"," insert 전 ");

            dbAdapter.insert(total,s1,s2,s3,s4,s5,s6,s7,s8);
            Log.d("asdfDB"," insert gn ");


            ArrayList<String> score_arr = new ArrayList<>();

            score_arr.add(total);
            score_arr.add(s1);
            score_arr.add(s2);
            score_arr.add(s3);
            score_arr.add(s4);
            score_arr.add(s5);
            score_arr.add(s6);
            score_arr.add(s7);
            score_arr.add(s8);


            Intent intent = new Intent(getActivity() , SurveyResultActiviy.class);
            intent.putStringArrayListExtra("SURVEY_RESULT",score_arr);
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


    public void cal8section(ArrayList<SurveyItem> array)
    {
        for(int i = 0; i< array.size();i++) {
            if (array.get(i).getCode() == 1)
                section_bodyhealth += array.get(i).getScore();
            else if (array.get(i).getCode() == 2)
                section_stress += array.get(i).getScore();
            else if (array.get(i).getCode() == 3)
                section_house += array.get(i).getScore();
            else if (array.get(i).getCode() == 4)
                section_job += array.get(i).getScore();
            else if (array.get(i).getCode() == 5)
                section_sleep += array.get(i).getScore();
            else if (array.get(i).getCode() == 6)
                section_skin += array.get(i).getScore();
            else if (array.get(i).getCode() == 7)
                section_depoison += array.get(i).getScore();
            else
                section_main += array.get(i).getScore();
        }

        section_bodyhealth = 5-((section_bodyhealth*5)/16);
        if(section_bodyhealth<=0)
            section_bodyhealth = 0;

        section_stress = 5-((section_stress*5)/14);
        if(section_stress<=0)
            section_stress = 0;

        section_house = 5-((section_house*5)/11);
        if(section_house<=0)
            section_house = 0;

        section_job = 5-((section_job*5)/6);
        if(section_job<=0)
            section_job = 0;

        section_sleep = 5-((section_sleep*5)/10);
        if(section_sleep<=0)
            section_sleep = 0;

        section_skin = 5-((section_skin*5)/13);
        if(section_skin<=0)
            section_skin = 0;

        section_depoison = ((section_depoison*5)/27);
        if(section_depoison<=0)
            section_depoison = 0;
        section_main = ((section_main*5)/75);
        if(section_main<=0)
            section_main = 0;
    }

}