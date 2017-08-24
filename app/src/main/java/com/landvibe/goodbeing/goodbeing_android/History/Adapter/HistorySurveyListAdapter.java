package com.landvibe.goodbeing.goodbeing_android.History.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.History.Data.SurveyResultItem;
import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistorySurveyListAdapter extends RecyclerView.Adapter<HistorySurveyListAdapter.ViewHolder>{

    private ArrayList<SurveyResultItem> surveyResultItems;


    public HistorySurveyListAdapter(ArrayList<SurveyResultItem> surveyResultItems) {
        this.surveyResultItems = surveyResultItems;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView survey_item_name;
        public TextView survey_item_score;
        public TextView survey_item_date;
        public TextView survey_item_result;

        public ViewHolder(View itemView) {
            super(itemView);
            survey_item_name = (TextView)itemView.findViewById(R.id.survey_item_name);
            survey_item_score = (TextView)itemView.findViewById(R.id.survey_item_score);
            survey_item_date = (TextView)itemView.findViewById(R.id.survey_item_date);
            survey_item_result = (TextView)itemView.findViewById(R.id.survey_item_result);
        }
    }

    @Override
    public HistorySurveyListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_survey_item_view , parent , false);
        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(final HistorySurveyListAdapter.ViewHolder holder, int position) {
        SurveyResultItem item = surveyResultItems.get(position);

        holder.survey_item_name.setText(item.getUser_name());
        holder.survey_item_score.setText(item.getSurvey_score() + "점");
        holder.survey_item_date.setText(item.getSurvey_date());

        int score = Integer.parseInt(item.getSurvey_score());
        String result = new String();

        if(score > 70)
            result = "굳빙이 매우 위협받음 (유해물질 고노출)";
        else if (score >25)
            result = "굳빙 위기(유해물질 중간 노출)";
        else
            result = "굳빙 (유해물질 저노출)";

        holder.survey_item_result.setText(result);
    }

    @Override
    public int getItemCount() {
        return surveyResultItems.size();
    }
}