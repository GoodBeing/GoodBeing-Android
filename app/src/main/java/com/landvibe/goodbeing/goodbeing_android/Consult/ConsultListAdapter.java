package com.landvibe.goodbeing.goodbeing_android.Consult;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

/**
 * Created by KSM on 2017-07-18.
 */

public class ConsultListAdapter extends RecyclerView.Adapter<ConsultListAdapter.ViewHolder> {
    private ArrayList<ConsultData> mDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView user_img_imageview;
        public TextView user_name_textview;
        public TextView user_info_textview;
        public TextView consult_content_textview;

        public ViewHolder(View view){
            super(view);
            user_img_imageview = (ImageView)view.findViewById(R.id.consult_user_imgview);
            user_name_textview = (TextView)view.findViewById(R.id.consult_user_name_txtview);
            user_info_textview = (TextView)view.findViewById(R.id.consult_user_info_txtview);
            consult_content_textview = (TextView)view.findViewById(R.id.consult_content_txtview);
        }
    }

    public ConsultListAdapter(ArrayList<ConsultData> myDataset){
        mDataset = myDataset;
    }

    @Override
    public ConsultListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.consult_listitem, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ConsultListAdapter.ViewHolder holder, int position) {
        holder.user_img_imageview.setImageResource(mDataset.get(position).getUser_image());
        holder.user_name_textview.setText(mDataset.get(position).getUser_name());
        holder.user_info_textview.setText(mDataset.get(position).getUser_info());
        holder.consult_content_textview.setText(mDataset.get(position).getConsult_content());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

class ConsultData{
    private int User_image;
    private String User_name;
    private String User_info;
    private String Consult_content;

    public ConsultData(int user_image, String user_name, String user_info, String consult_content) {
        User_image = user_image;
        User_name = user_name;
        User_info = user_info;
        Consult_content = consult_content;
    }

    public int getUser_image() {
        return User_image;
    }

    public void setUser_image(int user_image) {
        User_image = user_image;
    }

    public String getUser_name() {
        return User_name;
    }

    public void setUser_name(String user_name) {
        User_name = user_name;
    }

    public String getUser_info() {
        return User_info;
    }

    public void setUser_info(String user_info) {
        User_info = user_info;
    }

    public String getConsult_content() {
        return Consult_content;
    }

    public void setConsult_content(String consult_content) {
        Consult_content = consult_content;
    }
}