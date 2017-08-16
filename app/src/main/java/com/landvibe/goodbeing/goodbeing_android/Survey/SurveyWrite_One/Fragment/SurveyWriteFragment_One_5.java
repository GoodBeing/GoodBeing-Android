package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.util.Log;
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


public class SurveyWriteFragment_One_5 extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private RadioGroup surveywriteActivity_Fragment_One_N15_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N16_rg;
    private RadioGroup surveywriteActivity_Fragment_One_N17_rg;

    private SurveyItem surveyitem1;
    private SurveyItem surveyitem2;
    private SurveyItem surveyitem3;



    public SurveyWriteFragment_One_5() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static SurveyWriteFragment_One_5 newInstance(int sectionNumber) {
        SurveyWriteFragment_One_5 fragment = new SurveyWriteFragment_One_5();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.survey_fragment_one_5, container, false);

        surveywriteActivity_Fragment_One_N15_rg = (RadioGroup) rootView.findViewById(R.id.one_N15);
        surveywriteActivity_Fragment_One_N16_rg = (RadioGroup) rootView.findViewById(R.id.one_N16);
        surveywriteActivity_Fragment_One_N17_rg = (RadioGroup) rootView.findViewById(R.id.one_N17);


        surveywriteActivity_Fragment_One_N15_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
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
                Log.d("VVVVV12",Integer.toString(arr.get(11).getCode())+"  "+ Integer.toString(arr.get(11).getAnswer())+"  "+arr.get(11).getS_answer()+"  "+Integer.toString(arr.get(11).getScore()));
                Log.d("VVVVV13",Integer.toString(arr.get(12).getCode())+"  "+ Integer.toString(arr.get(12).getAnswer())+"  "+arr.get(12).getS_answer()+"  "+Integer.toString(arr.get(12).getScore()));
                Log.d("VVVVV14",Integer.toString(arr.get(13).getCode())+"  "+ Integer.toString(arr.get(13).getAnswer())+"  "+arr.get(13).getS_answer()+"  "+Integer.toString(arr.get(13).getScore()));

                switch(i)
                {
                    case R.id.one_N15_1:
                        surveyitem1 = new SurveyItem(3, 1, "", -1);
                        arr.set(14,surveyitem1);
                        break;
                    case R.id.one_N15_2:
                        surveyitem1 = new SurveyItem(3, 2, "", -2);
                        arr.set(14,surveyitem1);
                        break;
                    case R.id.one_N15_3:
                        surveyitem1 = new SurveyItem(3, 3, "", -3);
                        arr.set(14,surveyitem1);
                        break;
                    case R.id.one_N15_4:
                        surveyitem1 = new SurveyItem(3, 4, "", -4);
                        arr.set(14,surveyitem1);
                        break;
                }
            }
        });

        surveywriteActivity_Fragment_One_N16_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N16_1:
                        surveyitem2 = new SurveyItem(7, 1, "", -1);
                        arr.set(15,surveyitem2);
                        break;
                    case R.id.one_N16_2:
                        surveyitem2 = new SurveyItem(7, 2, "", -2);
                        arr.set(15,surveyitem2);
                        break;
                    case R.id.one_N16_3:
                        surveyitem2 = new SurveyItem(7, 3, "", -3);
                        arr.set(15,surveyitem2);
                        break;
                    case R.id.one_N16_4:
                        surveyitem2 = new SurveyItem(7, 4, "", -4);
                        arr.set(15,surveyitem2);
                        break;
                }
            }
        });

        surveywriteActivity_Fragment_One_N17_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                ArrayList<SurveyItem> arr = ((SurveyWriteActivity) getActivity()).getarray();
                switch(i)
                {
                    case R.id.one_N16_1:
                        surveyitem3 = new SurveyItem(8, 1, "", 1);
                        arr.set(16,surveyitem3);
                        break;
                    case R.id.one_N16_2:
                        surveyitem3 = new SurveyItem(8, 2, "", 2);
                        arr.set(16,surveyitem3);
                        break;
                    case R.id.one_N16_3:
                        surveyitem3 = new SurveyItem(8, 3, "", 3);
                        arr.set(16,surveyitem3);
                        break;
                    case R.id.one_N16_4:
                        surveyitem3 = new SurveyItem(8, 4, "", 4);
                        arr.set(16,surveyitem3);
                        break;

                }
            }
        });


        return rootView;
    }


}