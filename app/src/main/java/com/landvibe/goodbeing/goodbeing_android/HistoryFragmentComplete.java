package com.landvibe.goodbeing.goodbeing_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;



/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryFragmentComplete extends Fragment {

    /*
       RecycleView
    */
    private RecyclerView historyRecycleView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    /*
        DataSet for RecycleView
    */
    private ArrayList<HistoryItem> historyItemArrayList;

    /*
        Intent
    */
    private Intent intent;



    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate(R.layout.history_tab_fragment_complete,container,false);

        //RecycleView
        historyRecycleView = (RecyclerView) view.findViewById(R.id.history_recycler_view);

        historyRecycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false);
        historyRecycleView.setLayoutManager(layoutManager);

        // DataSet
        historyItemArrayList = new ArrayList<HistoryItem>();
        historyItemArrayList.add(new HistoryItem("강승모" , true , 26 , 4));
        historyItemArrayList.add(new HistoryItem("이상직" , true , 26 , 3));
        historyItemArrayList.add(new HistoryItem("박재형" , true , 22 , 1));
        historyItemArrayList.add(new HistoryItem("김나라" , false , 26 , 4));
        historyItemArrayList.add(new HistoryItem("사진좀" , true , 29 , 2));
        historyItemArrayList.add(new HistoryItem("너이다" , false , 34 , 2));
        historyItemArrayList.add(new HistoryItem("코카콜라" , false , 21 , 1));
        historyItemArrayList.add(new HistoryItem("펩시" , false , 29 , 3));

        adapter = new HistoryListAdapter(historyItemArrayList);
        historyRecycleView.setAdapter(adapter);

        historyRecycleView.addOnItemTouchListener(new HistoryRecycleViewOnItemClickListener(inflater.getContext().getApplicationContext(), historyRecycleView, new HistoryRecycleViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                intent = new Intent();
                intent.putExtra("index" , position);
                intent.setClassName(inflater.getContext().getApplicationContext() , SurveyResultActiviy.class.getName());

                startActivity(intent);
            }
        }));



        return view;
    }
}