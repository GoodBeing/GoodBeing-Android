package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_1;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_10;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_11;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_12;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_13;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_14;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_15;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_2;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_3;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_4;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_5;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_6;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_7;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_8;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_9;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Fragment.SurveyWriteFragment_One_Last;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item.SurveyItem;

import java.util.ArrayList;

/**
 * Created by jik on 2017-07-26.
 */

public class SurveyWriteAdapter_One {

    public static class SectionsPagerAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {

        Bundle bundle = new Bundle();
        ArrayList<SurveyItem> surveyitem = new ArrayList<>();
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if (position == 0) {
                return new SurveyWriteFragment_One_1();
            } else if (position == 1) {
                return new SurveyWriteFragment_One_2();
            } else if (position == 2) {
                return new SurveyWriteFragment_One_3();
            } else if (position == 3) {
                return new SurveyWriteFragment_One_4();
            } else if (position == 4)
                return new SurveyWriteFragment_One_5();
            else if (position == 5)
                return new SurveyWriteFragment_One_6();
            else if (position == 6)
                return new SurveyWriteFragment_One_7();
            else if (position == 7)
                return new SurveyWriteFragment_One_8();
            else if (position == 8)
                return new SurveyWriteFragment_One_9();
            else if (position == 9)
                return new SurveyWriteFragment_One_10();
            else if (position == 10)
                return new SurveyWriteFragment_One_11();
            else if (position == 11)
                return new SurveyWriteFragment_One_12();
            else if (position == 12)
                return new SurveyWriteFragment_One_13();
            else if (position == 13)
                return new SurveyWriteFragment_One_14();
            else if (position == 14)
                return new SurveyWriteFragment_One_15();
            else
                return new SurveyWriteFragment_One_Last();
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 16;
        }
        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
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

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}


