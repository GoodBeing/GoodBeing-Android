package com.landvibe.goodbeing.goodbeing_android.Sample.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.landvibe.goodbeing.goodbeing_android.Sample.Fragment.SampleFragmentComplete;
import com.landvibe.goodbeing.goodbeing_android.Sample.Fragment.SampleFragmentProgress;
import com.landvibe.goodbeing.goodbeing_android.Sample.Fragment.SampleFragmentTotal;

/**
 * Created by 고승빈 on 2017-07-18.
 */
public class SampleViewPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public SampleViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new SampleFragmentTotal();
            case 1:
                return new SampleFragmentProgress();
            case 2:
                return new SampleFragmentComplete();
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
