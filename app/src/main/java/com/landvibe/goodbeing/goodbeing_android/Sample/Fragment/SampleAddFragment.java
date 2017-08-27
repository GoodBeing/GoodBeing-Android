package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.DB.DBAdapter;
import com.landvibe.goodbeing.goodbeing_android.History.Data.SurveyResultItem;
import com.landvibe.goodbeing.goodbeing_android.History.Data.SurveyTotalItem;
import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by KSM on 2017-08-06.
 */

public class SampleAddFragment extends android.support.v4.app.Fragment {
    private TextView survey_result;
    private TextView survey_score;
    private DBAdapter dbAdapter;
    private ArrayList<SurveyTotalItem> totalarraylist;
    private ArrayList<SurveyResultItem> surveyResultItems;
    private LinearLayout infolinear;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_add, container, false);
        totalarraylist = new ArrayList<SurveyTotalItem>();
        dbAdapter = new DBAdapter(getActivity());
        totalarraylist = dbAdapter.selectAll();

        infolinear = (LinearLayout)view.findViewById(R.id.info_linearlayout);
        survey_result = (TextView)view.findViewById(R.id.survey_item_result);
        survey_score = (TextView)view.findViewById(R.id.survey_item_score);
        surveyResultItems = new ArrayList<SurveyResultItem>();

        ArrayList<String> sampleList = new ArrayList<>();


        for(int i = totalarraylist.size(); i>0; i--) {
            surveyResultItems.add(new SurveyResultItem("사용자", "2017-08-29", totalarraylist.get(i - 1).getTotal_score()));
            sampleList.add("설문 결과"+i);
        }
        Spinner spinner = (Spinner)view.findViewById(R.id.sample_add_survey_result);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                int a = (totalarraylist.size())-1;
                String score = totalarraylist.get(a-position).getTotal_score();
                survey_score.setText(score+"점");
                float f_score = Float.parseFloat(score);

                if(f_score>=70)
                    survey_result.setText("굳빙 위기\n(유해물질 고노출)");
                else if(f_score <70 && 25<f_score)
                    survey_result.setText("굳빙 평범\n(유해물질 중간 노출)");
                else
                    survey_result.setText("굳빙 좋음\n(유해물질 저노출)");


                infolinear.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


            }
        });

        ArrayAdapter adapter = new ArrayAdapter(getContext(), R.layout.support_simple_spinner_dropdown_item,sampleList);
        spinner.setAdapter(adapter);

        return view;
    }
}
