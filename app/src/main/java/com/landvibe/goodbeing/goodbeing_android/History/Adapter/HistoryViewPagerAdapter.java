package com.landvibe.goodbeing.goodbeing_android.History.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.landvibe.goodbeing.goodbeing_android.History.Fragment.HistoryFragmentComplete;
import com.landvibe.goodbeing.goodbeing_android.History.Fragment.HistoryFragmentConsulting;
import com.landvibe.goodbeing.goodbeing_android.History.Fragment.HistoryFragmentTotal;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class HistoryViewPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public HistoryViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new HistoryFragmentTotal();
            case 1:
                return new HistoryFragmentComplete();
            case 2:
                return new HistoryFragmentConsulting();
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
