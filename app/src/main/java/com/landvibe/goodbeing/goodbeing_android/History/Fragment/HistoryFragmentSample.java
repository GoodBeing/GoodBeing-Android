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

import com.landvibe.goodbeing.goodbeing_android.History.Adapter.HistoryListAdapter;
import com.landvibe.goodbeing.goodbeing_android.History.Data.SampleResultItem;
import com.landvibe.goodbeing.goodbeing_android.History.Listener.HistoryRecycleViewOnItemClickListener;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleResultActiviy;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryFragmentSample extends Fragment {

    /*
          RecycleView
       */
    private RecyclerView historyRecycleView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    /*
        DataSet for RecycleView
    */
    private ArrayList<SampleResultItem> sampleResultItemArrayList;

    /*
        Intent
    */
    private Intent intent;



    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate(R.layout.history_tab_fragment_sample,container,false);

        //RecycleView
        historyRecycleView = (RecyclerView) view.findViewById(R.id.history_sample_recycler_view);

        historyRecycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false);
        historyRecycleView.setLayoutManager(layoutManager);

        // DataSet
        sampleResultItemArrayList = new ArrayList<SampleResultItem>();
        sampleResultItemArrayList.add(new SampleResultItem("강승모" , true , 26 , 4));
        sampleResultItemArrayList.add(new SampleResultItem("이상직" , true , 26 , 3));
        sampleResultItemArrayList.add(new SampleResultItem("박재형" , true , 22 , 1));
        sampleResultItemArrayList.add(new SampleResultItem("김나라" , false , 26 , 4));
        sampleResultItemArrayList.add(new SampleResultItem("사진좀" , true , 29 , 2));
        sampleResultItemArrayList.add(new SampleResultItem("너이다" , false , 34 , 2));
        sampleResultItemArrayList.add(new SampleResultItem("코카콜라" , false , 21 , 1));
        sampleResultItemArrayList.add(new SampleResultItem("펩시" , false , 29 , 3));

        adapter = new HistoryListAdapter(sampleResultItemArrayList);
        historyRecycleView.setAdapter(adapter);

        historyRecycleView.addOnItemTouchListener(new HistoryRecycleViewOnItemClickListener(inflater.getContext().getApplicationContext(), historyRecycleView, new HistoryRecycleViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                intent = new Intent();
                intent.putExtra("index" , position);
                intent.setClassName(inflater.getContext().getApplicationContext() , SampleResultActiviy.class.getName());

                startActivity(intent);
            }
        }));



        return view;
    }
}
