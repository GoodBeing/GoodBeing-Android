package com.landvibe.goodbeing.goodbeing_android.History.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landvibe.goodbeing.goodbeing_android.History.Data.SampleResultItem;
import com.landvibe.goodbeing.goodbeing_android.History.Holder.HistoryViewHolder;
import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryListAdapter extends RecyclerView.Adapter<HistoryViewHolder>{

    private ArrayList<SampleResultItem> sampleResultItems;

    public HistoryListAdapter(ArrayList<SampleResultItem> sampleResultItems) {
        this.sampleResultItems = sampleResultItems;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item_view , parent , false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {


        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(sampleResultItems.get(position).getGender() ? "남" : "여")
                    .append(" / ")
                    .append(sampleResultItems.get(position).getAge())
                    .append(" / ");

        switch (sampleResultItems.get(position).getBloodType())
        {
            case 1 :
                stringBuffer.append("A");
                break;
            case 2 :
                stringBuffer.append("B");
                break;
            case 3 :
                stringBuffer.append("O");
                break;
            case 4 :
                stringBuffer.append("AB");
                break;
            default:
                break;
        }

        holder.getName().setText(sampleResultItems.get(position).getName());
        holder.getIntro().setText(stringBuffer.toString());
    }

    @Override
    public int getItemCount() {
        return sampleResultItems.size();
    }



}
