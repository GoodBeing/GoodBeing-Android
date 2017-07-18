package com.landvibe.goodbeing.goodbeing_android.History.Listener;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryRecycleViewOnItemClickListener extends RecyclerView.SimpleOnItemTouchListener{

    private OnItemClickListener onItemClickListener;
    private GestureDetector gestureDetector;

    public HistoryRecycleViewOnItemClickListener(Context context ,RecyclerView recyclerView , OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;

        gestureDetector = new GestureDetector(context , new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View child = rv.findChildViewUnder(e.getX() , e.getY());

        if (child != null && onItemClickListener != null && gestureDetector.onTouchEvent(e))
        {
            onItemClickListener.onItemClick(child , rv.getChildAdapterPosition(child));
            return true;
        }

        return false;
    }

    @Override public void onTouchEvent(RecyclerView view, MotionEvent motionEvent) { }

    @Override public void onRequestDisallowInterceptTouchEvent (boolean disallowIntercept){}

    public interface OnItemClickListener { void onItemClick(View v, int position); }

}
