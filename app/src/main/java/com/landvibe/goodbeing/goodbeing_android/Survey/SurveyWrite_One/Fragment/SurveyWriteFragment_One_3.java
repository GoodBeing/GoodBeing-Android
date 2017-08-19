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


public class SurveyWriteFragment_One_3 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N9_rg;
    private EditText surveywriteActivity_Fragment_One_N9_et;
    private RadioGroup surveywriteActivity_Fragment_One_N10_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N11_rg;
    private BackPressEditText surveywriteActivity_Fragment_One_N11_et;

    private ArrayList<SurveyItem> m_surveyitemArrayList;
    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;
    private SurveyItem surveyitem4;
    private SurveyItem surveyitem5;

    public SurveyWriteFragment_One_3() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_3 newInstance(int sectionNumber) {
        Log.d("aaaaaaaaa fragment3 : "," constructor");

        SurveyWriteFragment_One_3 fragment = new SurveyWriteFragment_One_3();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("aaaaaaaaa fragment3 : "," oncreatee");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_3, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
        Log.d("aaaaaaaaa fragment3 : "," oncreateview");

        surveywriteActivity_Fragment_One_N9_rg = (RadioGroup) rootView.findViewById(R.id.one_N9);
        surveywriteActivity_Fragment_One_N9_et = (EditText) rootView.findViewById(R.id.one_N9_q);

        surveywriteActivity_Fragment_One_N10_rg = (RadioGroup) rootView.findViewById(R.id.one_N10);

        surveywriteActivity_Fragment_One_N11_rg = (RadioGroup) rootView.findViewById(R.id.one_N11);
        surveywriteActivity_Fragment_One_N11_et = (BackPressEditText) rootView.findViewById(R.id.one_N11_q);
        surveywriteActivity_Fragment_One_N11_et.setOnFocusChangeListener(onBackPressListener);


        surveywriteActivity_Fragment_One_N9_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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


                switch(i)
                {
                    case R.id.one_N9_1:
                        surveyitem1 = new SurveyItem(1, 1, "", 1);
                        arr.set(8,surveyitem1);
                        break;

                    case R.id.one_N9_2:
                        surveyitem1 = new SurveyItem(1, 2, "", 2);
                        arr.set(8,surveyitem1);
                        break;

                    case R.id.one_N9_3:
                        if(surveywriteActivity_Fragment_One_N9_et.getText().toString()==null) {
                            surveyitem1 = new SurveyItem(1, 3, "", 3);
                            arr.set(8,surveyitem1);
                        }
                        break;
                }
            }
        });


        surveywriteActivity_Fragment_One_N9_et.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(surveywriteActivity_Fragment_One_N9_et.getText().toString()!=null){
                    if (b == false) {
                        surveyitem1 = new SurveyItem(1, 3, surveywriteActivity_Fragment_One_N9_et.getText().toString(), 3);
                        ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();

                        arr.set(8,surveyitem1);
                    }
                }
                Log.d("aaaaaaaaa1", "" + 4);
            }
        });


        surveywriteActivity_Fragment_One_N10_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N10_1:
                        surveyitem2 = new SurveyItem(7, 1, "", -1);
                        arr.set(9,surveyitem2);
                        break;

                    case R.id.one_N10_2:
                        surveyitem2 = new SurveyItem(7, 2, "", -2);
                        arr.set(9,surveyitem2);
                        break;

                    case R.id.one_N10_3:
                        surveyitem2 = new SurveyItem(7, 2, "", -3);
                        arr.set(9,surveyitem2);
                        break;


                }
            }
        });
        surveywriteActivity_Fragment_One_N11_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N11_1:
                        surveyitem3 = new SurveyItem(7, 1, "", -1);
                        arr.set(10,surveyitem3);
                        break;

                    case R.id.one_N11_2:
                        if(surveywriteActivity_Fragment_One_N11_et.getText().toString()==null) {
                            surveyitem3 = new SurveyItem(7, 2, "", -2);
                            arr.set(10, surveyitem3);
                        }
                        break;
                }
            }
        });




        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();


    }



    private void didBackPressOnEditText()
    {
        if(surveywriteActivity_Fragment_One_N11_et.getText().toString()!=null) {
            surveyitem3 = new SurveyItem(7, 2, surveywriteActivity_Fragment_One_N11_et.getText().toString(), -2);
            ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
            arr.set(10,surveyitem3);

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