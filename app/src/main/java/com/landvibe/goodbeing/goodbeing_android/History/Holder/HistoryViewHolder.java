package com.landvibe.goodbeing.goodbeing_android.History.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryViewHolder extends RecyclerView.ViewHolder{
    private TextView name;
    private TextView intro;

    public HistoryViewHolder(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.history_name);
        intro = (TextView) itemView.findViewById(R.id.history_intro);
    }

    public TextView getName() {
        return name;
    }

    public void setName(TextView name) {
        this.name = name;
    }

    public TextView getIntro() {
        return intro;
    }

    public void setIntro(TextView intro) {
        this.intro = intro;
    }
}
