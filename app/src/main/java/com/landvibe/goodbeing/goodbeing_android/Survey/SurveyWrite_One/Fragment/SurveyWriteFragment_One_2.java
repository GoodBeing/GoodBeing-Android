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
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item.SurveyItem;

import java.util.ArrayList;

/**
 * Created by jik on 2017-07-26.
 */


public class SurveyWriteFragment_One_2 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N6_rg;
    private EditText surveywriteActivity_Fragment_One_N6_et;
    private RadioGroup surveywriteActivity_Fragment_One_N7_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N8_rg;
    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;
    private int score = 0;
    Bundle args;
    ArrayList<SurveyItem> surveyitemArrayList;
    private ArrayList<SurveyItem> m_surveyitemArrayList;

    public SurveyWriteFragment_One_2() {

    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_2 newInstance(int sectionNumber) {
        Log.d("aaaaaaaaa fragment2 : "," constructor");

        SurveyWriteFragment_One_2 fragment = new SurveyWriteFragment_One_2();
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
        Log.d("aaaaaaaaa fragment2 : "," oncreateview");

        View rootView = inflater.inflate(R.layout.survey_fragment_one_2, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        surveywriteActivity_Fragment_One_N6_rg = (RadioGroup) rootView.findViewById(R.id.one_N6);
        surveywriteActivity_Fragment_One_N6_et = (EditText) rootView.findViewById(R.id.one_N6_familynumber);

        surveywriteActivity_Fragment_One_N7_rg = (RadioGroup) rootView.findViewById(R.id.one_N7);
        surveywriteActivity_Fragment_One_N8_rg = (RadioGroup) rootView.findViewById(R.id.one_N8);



//        if(surveywriteActivity_Fragment_One_N6_et.getText().toString()!="") {
//            int n6 = Integer.parseInt(surveywriteActivity_Fragment_One_N6_et.getText().toString());
//            score = n6 * 2;
//        }
        surveywriteActivity_Fragment_One_N6_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                Log.d("VVVVV1",Integer.toString(arr.get(0).getCode())+"  "+ Integer.toString(arr.get(0).getAnswer())+"  "+arr.get(0).getS_answer()+"  "+Integer.toString(arr.get(0).getScore()));
                Log.d("VVVVV2",Integer.toString(arr.get(1).getCode())+"  "+ Integer.toString(arr.get(1).getAnswer())+"  "+arr.get(1).getS_answer()+"  "+Integer.toString(arr.get(1).getScore()));
                Log.d("VVVVV3",Integer.toString(arr.get(2).getCode())+"  "+ Integer.toString(arr.get(2).getAnswer())+"  "+arr.get(2).getS_answer()+"  "+Integer.toString(arr.get(2).getScore()));
                Log.d("VVVVV4",Integer.toString(arr.get(3).getCode())+"  "+ Integer.toString(arr.get(3).getAnswer())+"  "+arr.get(3).getS_answer()+"  "+Integer.toString(arr.get(3).getScore()));
                Log.d("VVVVV5",Integer.toString(arr.get(4).getCode())+"  "+ Integer.toString(arr.get(4).getAnswer())+"  "+arr.get(4).getS_answer()+"  "+Integer.toString(arr.get(4).getScore()));

                switch(i)
                {
                    case R.id.one_N6_1:
                        surveyitem1 = new SurveyItem(2, 1, "", 1);
                        break;

                    case R.id.one_N6_2:
                        if(surveywriteActivity_Fragment_One_N6_et.getText().toString()==null)
                                surveyitem1 = new SurveyItem(2, 2, "", 0);
                        break;
                }
            }
        });

        surveywriteActivity_Fragment_One_N6_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {

                    if (b == false) {
                        int num = 0;
                        num = Integer.parseInt(surveywriteActivity_Fragment_One_N6_et.getText().toString());
                        score = num*2;

                        surveyitem1 = new SurveyItem(2, 2, surveywriteActivity_Fragment_One_N6_et.getText().toString(), score);
                        ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                        arr.set(5,surveyitem1);
                    }
                    Log.d("aaaaaaaaa1", "" + 4);

            }
        });



        surveywriteActivity_Fragment_One_N7_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                switch(i)
                {
                    case R.id.one_N7_1:
                        surveyitem2 = new SurveyItem(4, 1, "", 1);
                        arr.set(6,surveyitem2);
                        break;

                    case R.id.one_N7_2:
                        surveyitem2 = new SurveyItem(4,2, "", 2);
                        arr.set(6,surveyitem2);
                        break;

                    case R.id.one_N7_3:
                        surveyitem2 = new SurveyItem(4, 3, "", 3);
                        arr.set(6,surveyitem2);
                        break;
                    case R.id.one_N7_4:

                        surveyitem2 = new SurveyItem(4, 4, "", 4);
                        arr.set(6,surveyitem2);
                        break;

                }
            }
        });
        surveywriteActivity_Fragment_One_N8_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                switch(i)
                {
                    case R.id.one_N8_1:
                        surveyitem3 = new SurveyItem(1, 1, "", 1);
                        arr.set(7,surveyitem3);
                        break;
                    case R.id.one_N8_2:
                        arr.set(7,surveyitem3);
                        surveyitem3 = new SurveyItem(1, 2, "", 2);
                        break;
                }
            }
        });


        args = new Bundle();

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.d("aaaaaaaaa fragment2 : "," onresume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("aaaaaaaaa fragment2 : "," onpause");


    }
}