package com.landvibe.goodbeing.goodbeing_android.Sample.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Item.SampleItem;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class SampleListAdapter extends RecyclerView.Adapter<SampleListAdapter.ViewHolder>{

    private ArrayList<SampleItem> sampleItemArrayList;

    public SampleListAdapter(ArrayList<SampleItem> sampleItemArrayList) {
        this.sampleItemArrayList = sampleItemArrayList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView user_image;
        public TextView user_name;
        public TextView sample_etcinfo;

        public ViewHolder(View itemView) {
            super(itemView);
            user_image = (ImageView)itemView.findViewById(R.id.sample_item_user_image);
            user_name = (TextView)itemView.findViewById(R.id.sample_item_user_name);
            sample_etcinfo = (TextView)itemView.findViewById(R.id.sample_item_etc_info);
        }
    }

    @Override
    public SampleListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_item_view , parent , false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(SampleListAdapter.ViewHolder holder, int position) {

        holder.user_image.setImageResource(sampleItemArrayList.get(position).getUser_image());
        holder.user_name.setText(sampleItemArrayList.get(position).getUser_name());
        holder.sample_etcinfo.setText(sampleItemArrayList.get(position).getSample_date());

    }

    @Override
    public int getItemCount() {
        return sampleItemArrayList.size();
    }

}
