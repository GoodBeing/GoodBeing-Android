package com.landvibe.goodbeing.goodbeing_android.History.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landvibe.goodbeing.goodbeing_android.DB.DBAdapter;
import com.landvibe.goodbeing.goodbeing_android.History.Adapter.HistorySurveyListAdapter;
import com.landvibe.goodbeing.goodbeing_android.History.Data.SurveyResultItem;
import com.landvibe.goodbeing.goodbeing_android.History.Data.SurveyTotalItem;
import com.landvibe.goodbeing.goodbeing_android.History.Listener.HistoryRecycleViewOnItemClickListener;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyResultActiviy;

import java.util.ArrayList;



/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryFragmentSurvey extends Fragment {

    /*
       RecycleView
    */
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<SurveyTotalItem> totalarraylist;

    DBAdapter dbAdapter;
    /*
        DataSet for RecycleView
    */
    private ArrayList<SurveyResultItem> surveyResultItems;

    /*
        Intent
    */
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate(R.layout.history_tab_fragment_survey,container,false);

        //RecycleView
        recyclerView = (RecyclerView) view.findViewById(R.id.history_survey_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false);
        recyclerView.setLayoutManager(layoutManager);

        totalarraylist = new ArrayList<SurveyTotalItem>();

        dbAdapter = new DBAdapter(getActivity());
        totalarraylist = dbAdapter.selectAll();


        // DataSet
        surveyResultItems = new ArrayList<SurveyResultItem>();

        for(int i = 0; i<totalarraylist.size();i++)
            surveyResultItems.add(new SurveyResultItem("사용자","2017-08-25",totalarraylist.get(i).getTotal_score()));


        recyclerView.addOnItemTouchListener(new HistoryRecycleViewOnItemClickListener(inflater.getContext().getApplicationContext(), recyclerView, new HistoryRecycleViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                ArrayList<String> intentdata = new ArrayList<String>();
                intentdata.add(totalarraylist.get(position).getTotal_score());
                intentdata.add(totalarraylist.get(position).getS1_score());
                intentdata.add(totalarraylist.get(position).getS2_score());
                intentdata.add(totalarraylist.get(position).getS3_score());
                intentdata.add(totalarraylist.get(position).getS4_score());
                intentdata.add(totalarraylist.get(position).getS5_score());
                intentdata.add(totalarraylist.get(position).getS6_score());
                intentdata.add(totalarraylist.get(position).getS7_score());
                intentdata.add(totalarraylist.get(position).getS8_score());

                intent = new Intent();
                intent.putExtra("SURVEY_RESULT" , intentdata);
                intent.setClassName(inflater.getContext().getApplicationContext() , SurveyResultActiviy.class.getName());

                startActivity(intent);
            }
        }));

        adapter = new HistorySurveyListAdapter(surveyResultItems);
        recyclerView.setAdapter(adapter);

        return view;
    }

}