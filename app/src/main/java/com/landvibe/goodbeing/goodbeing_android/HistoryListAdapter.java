package com.landvibe.goodbeing.goodbeing_android;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryListAdapter extends RecyclerView.Adapter<HistoryViewHolder>{

    private ArrayList<HistoryItem> historyItems;

    public HistoryListAdapter(ArrayList<HistoryItem> historyItems) {
        this.historyItems = historyItems;
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item_view , parent , false);

        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {


        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(historyItems.get(position).getGender() ? "남" : "여")
                    .append(" / ")
                    .append(historyItems.get(position).getAge())
                    .append(" / ");

        switch (historyItems.get(position).getBloodType())
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

        holder.getName().setText(historyItems.get(position).getName());
        holder.getIntro().setText(stringBuffer.toString());
    }

    @Override
    public int getItemCount() {
        return historyItems.size();
    }



}
