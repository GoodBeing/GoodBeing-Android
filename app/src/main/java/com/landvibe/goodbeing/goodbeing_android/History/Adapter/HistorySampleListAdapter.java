package com.landvibe.goodbeing.goodbeing_android.History.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.History.Data.SampleResultItem;
import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistorySampleListAdapter extends RecyclerView.Adapter<HistorySampleListAdapter.ViewHolder>{

    private ArrayList<SampleResultItem> sampleResultItems;


    public HistorySampleListAdapter(ArrayList<SampleResultItem> sampleResultItems) {
        this.sampleResultItems = sampleResultItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView sample_item_name;
        public TextView sample_item_date;
        public TextView sample_item_status;
        public TextView sample_item_result;

        public ViewHolder(View itemView) {
            super(itemView);
            sample_item_name = (TextView)itemView.findViewById(R.id.sample_item_name);
            sample_item_date = (TextView)itemView.findViewById(R.id.sample_item_date);
            sample_item_status = (TextView)itemView.findViewById(R.id.sample_item_status);
            sample_item_result = (TextView)itemView.findViewById(R.id.sample_item_result);
        }
    }

    @Override
    public HistorySampleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_sample_item_view , parent , false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(final HistorySampleListAdapter.ViewHolder holder, int position) {
        SampleResultItem item = sampleResultItems.get(position);

        holder.sample_item_name.setText(item.getUser_name());
        holder.sample_item_date.setText(item.getSample_date());
        holder.sample_item_status.setText(item.getSample_status());
        holder.sample_item_result.setText(item.getSample_result());
    }

    @Override
    public int getItemCount() {
        return sampleResultItems.size();
    }
}