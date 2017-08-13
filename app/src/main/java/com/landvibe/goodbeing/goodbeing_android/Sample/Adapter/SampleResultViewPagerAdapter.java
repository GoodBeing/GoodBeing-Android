package com.landvibe.goodbeing.goodbeing_android.Sample.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.landvibe.goodbeing.goodbeing_android.Sample.Fragment.SampleBarChartFragment;
import com.landvibe.goodbeing.goodbeing_android.Sample.Fragment.SampleRadarChartFragment;
import com.landvibe.goodbeing.goodbeing_android.Sample.Fragment.SampleResultFragment;

/**
 * Created by KSM on 2017-08-08.
 */

public class SampleResultViewPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    public SampleResultViewPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new SampleResultFragment();
            case 1:
                return new SampleRadarChartFragment();
            case 2:
                return new SampleBarChartFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
