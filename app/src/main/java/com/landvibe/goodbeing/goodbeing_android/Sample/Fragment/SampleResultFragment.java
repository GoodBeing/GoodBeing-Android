package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Adapter.SampleAnalysisListAdapter;
import com.landvibe.goodbeing.goodbeing_android.Sample.Item.SampleAnalysisItem;

import java.util.ArrayList;

public class SampleResultFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private TextView sample_result_name;
    private TextView sample_result_reg_num;
    private TextView sample_result_date_1;
    private TextView sample_result_date_2;

    public SampleResultFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_result, container, false);

        sample_result_name = (TextView)view.findViewById(R.id.sample_result_name);
        sample_result_reg_num = (TextView)view.findViewById(R.id.sample_result_reg_num);
        sample_result_date_1 = (TextView)view.findViewById(R.id.sample_result_date_1);
        sample_result_date_2 = (TextView)view.findViewById(R.id.sample_result_date_2);

        sample_result_name.setText("홍길동");
        sample_result_reg_num.setText("#15434956");
        sample_result_date_1.setText("2017-01-01");
        sample_result_date_2.setText("2017-05-01");

        recyclerView = (RecyclerView)view.findViewById(R.id.sample_analysis_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity() , LinearLayoutManager.VERTICAL , false);
        recyclerView.setLayoutManager(layoutManager);

        // DataSet
        ArrayList<SampleAnalysisItem> list = new ArrayList<>();
        list.add(new SampleAnalysisItem("비스페놀 A","24ug/L","고노출"));
        list.add(new SampleAnalysisItem("노화","24ug/L","고노출"));
        list.add(new SampleAnalysisItem("수면","24ug/L","고노출"));
        list.add(new SampleAnalysisItem("유해식품","24ug/L","고노출"));

        adapter = new SampleAnalysisListAdapter(list);
        recyclerView.setAdapter(adapter);


        return view;
    }
}
