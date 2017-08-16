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

import com.landvibe.goodbeing.goodbeing_android.History.Adapter.HistorySurveyListAdapter;
import com.landvibe.goodbeing.goodbeing_android.History.Data.SurveyResultItem;
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

        // DataSet
        surveyResultItems = new ArrayList<SurveyResultItem>();
        surveyResultItems.add(new SurveyResultItem("강승모","2017-09-09","89점"));
        surveyResultItems.add(new SurveyResultItem("이상직","2017-04-02","99점"));
        surveyResultItems.add(new SurveyResultItem("박재형","2015-01-01","91점"));
        surveyResultItems.add(new SurveyResultItem("고승빈","2015-01-01","11점"));

        recyclerView.addOnItemTouchListener(new HistoryRecycleViewOnItemClickListener(inflater.getContext().getApplicationContext(), recyclerView, new HistoryRecycleViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                intent = new Intent();
                intent.putExtra("index" , position);
                intent.setClassName(inflater.getContext().getApplicationContext() , SurveyResultActiviy.class.getName());

                startActivity(intent);
            }
        }));

        adapter = new HistorySurveyListAdapter(surveyResultItems);
        recyclerView.setAdapter(adapter);

        return view;
    }

}