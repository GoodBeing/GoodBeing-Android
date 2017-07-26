package com.landvibe.goodbeing.goodbeing_android.Consult;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by KSM on 2017-07-18.
 */

public class ConsultActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ConsultData> myDataset;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consult);

        mRecyclerView = (RecyclerView)findViewById(R.id.consult_recycler_view);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        myDataset = new ArrayList<>();
        mAdapter = new ConsultListAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        myDataset.add(new ConsultData(R.drawable.boy_1, "강승모", "92년생", "건강합니다."));
        myDataset.add(new ConsultData(R.drawable.boy_1, "고승빈", "92년생", "담배 좀 그만피세요"));
        myDataset.add(new ConsultData(R.drawable.boy_1, "이상직", "92년생", "담배 좀 그만피세요"));
    }
}
