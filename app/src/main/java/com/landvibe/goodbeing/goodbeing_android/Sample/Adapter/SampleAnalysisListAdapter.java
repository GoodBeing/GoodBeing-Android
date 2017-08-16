package com.landvibe.goodbeing.goodbeing_android.Sample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Item.SampleAnalysisItem;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class SampleAnalysisListAdapter extends RecyclerView.Adapter<SampleAnalysisListAdapter.ViewHolder>{

    private ArrayList<SampleAnalysisItem> sampleAnalysisItemArrayList;

    public SampleAnalysisListAdapter(ArrayList<SampleAnalysisItem> sampleAnalysisItemArrayList) {
        this.sampleAnalysisItemArrayList = sampleAnalysisItemArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView analysis_item;
        public TextView analysis_exposure;
        public TextView analysis_result;

        public ViewHolder(View itemView) {
            super(itemView);
            analysis_item = (TextView)itemView.findViewById(R.id.analysis_item);
            analysis_exposure = (TextView)itemView.findViewById(R.id.analysis_exposure);
            analysis_result = (TextView)itemView.findViewById(R.id.analysis_result);
        }
    }

    @Override
    public SampleAnalysisListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_analysis_listitem , parent , false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(SampleAnalysisListAdapter.ViewHolder holder, int position) {
        holder.analysis_item.setText(sampleAnalysisItemArrayList.get(position).getAnalysis_item());
        holder.analysis_exposure.setText(sampleAnalysisItemArrayList.get(position).getAnalysis_exposure());
        holder.analysis_result.setText(sampleAnalysisItemArrayList.get(position).getAnalysis_result());
    }

    @Override
    public int getItemCount() {
        return sampleAnalysisItemArrayList.size();
    }
}
