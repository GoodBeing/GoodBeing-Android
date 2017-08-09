package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_1;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_2;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_3;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_4;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_Last;

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
            return new SurveyWriteFragment_One_1();
        else if(position == 1)
            return new SurveyWriteFragment_One_2();
        else if(position == 2)
            return new SurveyWriteFragment_One_3();
        else if(position == 3)
            return new SurveyWriteFragment_One_4();
        else
            return new SurveyWriteFragment_One_Last();
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 5;
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
            case 3:
                return "SECTION 4";
            case 4:
                return "SECTION 5";
        }
        return null;
    }
}
}


