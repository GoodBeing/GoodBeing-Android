package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_One;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_Three;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_Two;

/**
 * Created by jik on 2017-07-26.
 */

public class SurveyWriteAdapter_One {

    public static class SectionsPagerAdapter extends FragmentPagerAdapter {


    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        if(position == 0)
            return new SurveyWriteFragment_One_One();
        else if(position == 1)
            return new SurveyWriteFragment_One_Two();
        else
            return new SurveyWriteFragment_One_Three();
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }
}
}


