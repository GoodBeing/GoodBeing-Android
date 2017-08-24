package com.landvibe.goodbeing.goodbeing_android.FAQ;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by jik on 2017-07-31.
 */

public class FaqAdapter extends RecyclerView.Adapter<FaqViewHolder> {

    private ArrayList<FaqItem> faqitems;

    public FaqAdapter(ArrayList<FaqItem> faqitems) {
        this.faqitems = faqitems;
    }

    @Override
    public FaqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.faq_listitem,parent,false);

        return new FaqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FaqViewHolder holder, int position) {

        holder.getQuestion().setText(faqitems.get(position).getQuestion());
        holder.getAnswer().setText(faqitems.get(position).getAnswer());

    }

    @Override
    public int getItemCount() {
        return faqitems.size();
    }
}
