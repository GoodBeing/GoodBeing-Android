package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
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
    private BackPressEditText surveywriteActivity_Fragment_One_N14_4_et;

    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;
    private int score = 0;
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
        surveywriteActivity_Fragment_One_N14_4_et = (BackPressEditText) rootView.findViewById(R.id.one_N14_4);
        surveywriteActivity_Fragment_One_N14_4_et.setOnFocusChangeListener(onBackPressListener);

        surveywriteActivity_Fragment_One_N12_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N12_1:
                        surveyitem1 = new SurveyItem(8, 1, "", 1);
                        arr.set(11,surveyitem1);
                        break;
                    case R.id.one_N12_2:
                        surveyitem1 = new SurveyItem(8, 2, "", 2);
                        arr.set(11,surveyitem1);
                        break;
                    case R.id.one_N12_3:
                        if(surveywriteActivity_Fragment_One_N12_et.getText().toString()==null) {
                               surveyitem1 = new SurveyItem(8, 3, "", 3);
                            arr.set(11, surveyitem1);
                        }
                        break;
                }
            }
        });

        surveywriteActivity_Fragment_One_N12_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(surveywriteActivity_Fragment_One_N12_et.getText().toString()!=null) {

                    if (b == false) {
                    int num = Integer.parseInt(surveywriteActivity_Fragment_One_N12_et.getText().toString());
                    if(num<10)
                        score = 1;
                    else if(num<=10&&num<20)
                        score = 2;
                    else
                        score = 3;
                    score = num*2;

                    score = score*3;
                    surveyitem1 = new SurveyItem(8, 3, surveywriteActivity_Fragment_One_N12_et.getText().toString(), score);
                    ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                    arr.set(11,surveyitem1);
                     }
                }
            }
        });


        surveywriteActivity_Fragment_One_N13_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                Log.d("VVVVV1",Integer.toString(arr.get(0).getCode())+"  "+ Integer.toString(arr.get(0).getAnswer())+"  "+arr.get(0).getS_answer()+"  "+Integer.toString(arr.get(0).getScore()));
                Log.d("VVVVV2",Integer.toString(arr.get(1).getCode())+"  "+ Integer.toString(arr.get(1).getAnswer())+"  "+arr.get(1).getS_answer()+"  "+Integer.toString(arr.get(1).getScore()));
                Log.d("VVVVV3",Integer.toString(arr.get(2).getCode())+"  "+ Integer.toString(arr.get(2).getAnswer())+"  "+arr.get(2).getS_answer()+"  "+Integer.toString(arr.get(2).getScore()));
                Log.d("VVVVV4",Integer.toString(arr.get(3).getCode())+"  "+ Integer.toString(arr.get(3).getAnswer())+"  "+arr.get(3).getS_answer()+"  "+Integer.toString(arr.get(3).getScore()));
                Log.d("VVVVV5",Integer.toString(arr.get(4).getCode())+"  "+ Integer.toString(arr.get(4).getAnswer())+"  "+arr.get(4).getS_answer()+"  "+Integer.toString(arr.get(4).getScore()));
                Log.d("VVVVV6",Integer.toString(arr.get(5).getCode())+"  "+ Integer.toString(arr.get(5).getAnswer())+"  "+arr.get(5).getS_answer()+"  "+Integer.toString(arr.get(5).getScore()));
                Log.d("VVVVV7",Integer.toString(arr.get(6).getCode())+"  "+ Integer.toString(arr.get(6).getAnswer())+"  "+arr.get(6).getS_answer()+"  "+Integer.toString(arr.get(6).getScore()));
                Log.d("VVVVV8",Integer.toString(arr.get(7).getCode())+"  "+ Integer.toString(arr.get(7).getAnswer())+"  "+arr.get(7).getS_answer()+"  "+Integer.toString(arr.get(7).getScore()));
                Log.d("VVVVV9",Integer.toString(arr.get(8).getCode())+"  "+ Integer.toString(arr.get(8).getAnswer())+"  "+arr.get(8).getS_answer()+"  "+Integer.toString(arr.get(8).getScore()));
                Log.d("VVVVV10",Integer.toString(arr.get(9).getCode())+"  "+ Integer.toString(arr.get(9).getAnswer())+"  "+arr.get(9).getS_answer()+"  "+Integer.toString(arr.get(9).getScore()));
                Log.d("VVVVV11",Integer.toString(arr.get(10).getCode())+"  "+ Integer.toString(arr.get(10).getAnswer())+"  "+arr.get(10).getS_answer()+"  "+Integer.toString(arr.get(10).getScore()));
                switch(i)
                {
                    case R.id.one_N13_1:
                        surveyitem2 = new SurveyItem(8, 1, "", 1);
                        arr.set(12,surveyitem2);
                        break;
                    case R.id.one_N13_2:
                        surveyitem2 = new SurveyItem(8, 2, "", 2);
                        arr.set(12,surveyitem2);
                        break;


                }
            }
        });



        return rootView;
    }
    private void didBackPressOnEditText()
    {
        if(surveywriteActivity_Fragment_One_N14_4_et.getText().toString()!=null) {
            String S_ans = "";
            S_ans = surveywriteActivity_Fragment_One_N14_1_et.getText().toString() + " "+
                    surveywriteActivity_Fragment_One_N14_2_et.getText().toString() + " "+
                    surveywriteActivity_Fragment_One_N14_3_et.getText().toString() + " "+
                    surveywriteActivity_Fragment_One_N14_4_et.getText().toString();
            int ans1 = Integer.parseInt(surveywriteActivity_Fragment_One_N14_1_et.getText().toString());
            int ans2 = Integer.parseInt(surveywriteActivity_Fragment_One_N14_2_et.getText().toString());
            int ans3 = Integer.parseInt(surveywriteActivity_Fragment_One_N14_3_et.getText().toString());
            int ans4 = Integer.parseInt(surveywriteActivity_Fragment_One_N14_4_et.getText().toString());
            double score1=0;

            score1 = (ans1 +ans2*2 + ans3*3 + ans4*4)*0.02;
            score = (int)score1;
            surveyitem3 = new SurveyItem(3, 0, S_ans, score);
            ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

            arr.set(13,surveyitem3);

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