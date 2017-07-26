package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Item.SampleItem;
import com.landvibe.goodbeing.goodbeing_android.Sample.Adapter.SampleListAdapter;
import com.landvibe.goodbeing.goodbeing_android.Sample.Listener.SampleRecycleViewOnItemClickListener;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleResultActiviy;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class SampleFragmentProgress extends Fragment {

    /*
          RecycleView
       */
    private RecyclerView sampleTotalRecycleView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    /*
        DataSet for RecycleView
    */
    private ArrayList<SampleItem> sampleItemArrayList;

    /*
        Intent
    */
    private Intent intent;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState ) {

        View view = inflater.inflate(R.layout.sample_tab_fragment_total,container,false);

        //RecycleView
        sampleTotalRecycleView = (RecyclerView) view.findViewById(R.id.sample_total_recycler_view);
        sampleTotalRecycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false);
        sampleTotalRecycleView.setLayoutManager(layoutManager);

        // DataSet
        sampleItemArrayList = new ArrayList<SampleItem>();
        sampleItemArrayList.add(new SampleItem(R.drawable.historyimg, "강승모-진행","2017-01-01","배송중"));
        sampleItemArrayList.add(new SampleItem(R.drawable.historyimg, "고승빈-진행","2017-02-01","배송중"));
        sampleItemArrayList.add(new SampleItem(R.drawable.historyimg, "이상직-진행","2017-03-01","배송중"));

        adapter = new SampleListAdapter(sampleItemArrayList);
        sampleTotalRecycleView.setAdapter(adapter);

        sampleTotalRecycleView.addOnItemTouchListener(new SampleRecycleViewOnItemClickListener(inflater.getContext().getApplicationContext(), sampleTotalRecycleView, new SampleRecycleViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                intent = new Intent();
                intent.putExtra("index", position);
                intent.putExtra("name", sampleItemArrayList.get(position).getUser_name());
                intent.setClassName(inflater.getContext().getApplicationContext() , SampleResultActiviy.class.getName());

                startActivity(intent);

            }
        }));

        return view;
    }
}
