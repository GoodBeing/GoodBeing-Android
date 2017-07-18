package com.landvibe.goodbeing.goodbeing_android;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jik on 2017-07-17.
 */

public class RealsurveywriteActivity extends AppCompatActivity {
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private Button RealsurveywirteActivity_ok_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_realsurveywrite);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class firstfragment extends Fragment implements View.OnClickListener {

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";
        private EditText RealsurveywirteActivity_firstfrgment_height_et;
        private EditText RealsurveywirteActivity_firstfrgment_weight_et;
        private Button RealsurveywirteActivity_firstfrgment_calBMI_button;
        private TextView RealsurveywirteActivity_firstfrgment_BMIresult_tv;
        public firstfragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static firstfragment newInstance(int sectionNumber) {
            firstfragment fragment = new firstfragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.survey_fragment, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            RealsurveywirteActivity_firstfrgment_height_et = (EditText) rootView.findViewById(R.id.height);
            RealsurveywirteActivity_firstfrgment_weight_et = (EditText) rootView.findViewById(R.id.weight);
            RealsurveywirteActivity_firstfrgment_BMIresult_tv = (TextView) rootView.findViewById(R.id.BMI_result) ;

            RealsurveywirteActivity_firstfrgment_calBMI_button = (Button) rootView.findViewById(R.id.cal_btn);
            RealsurveywirteActivity_firstfrgment_calBMI_button.setOnClickListener(this);
            return rootView;
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.cal_btn)
            {
                String heightString = RealsurveywirteActivity_firstfrgment_height_et.getText().toString();
               double height = 0;
                height = Integer.parseInt(heightString) ;

                String weightString = RealsurveywirteActivity_firstfrgment_weight_et.getText().toString();
                double weight = 0;
                weight = Integer.parseInt(weightString) ;

                double result = weight/((height/100)*(height/100));

                String re="";
                if(result >=30)
                    re ="비만";
                else if(result >=25 && result <30)
                    re ="과체중";
                else if(result >=18.5 && result <25)
                    re ="정상";
                else
                    re ="저체중";

                RealsurveywirteActivity_firstfrgment_BMIresult_tv.setText("당신은 "+re+"입니다.");
            }
        }
    }
    public static class secondfragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public secondfragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static secondfragment newInstance(int sectionNumber) {
            secondfragment fragment = new secondfragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.survey_fragment_1_1, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }


    }

    public static class thirdfragment extends Fragment implements View.OnClickListener {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private Button RealsurveywirteActivity_thirdfrgment_ok_btn;
        private static final String ARG_SECTION_NUMBER = "section_number";
        public thirdfragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static thirdfragment newInstance(int sectionNumber) {
            thirdfragment fragment = new thirdfragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.survey_fragment_1_2, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            RealsurveywirteActivity_thirdfrgment_ok_btn = (Button) rootView.findViewById(R.id.ok_btn);
            RealsurveywirteActivity_thirdfrgment_ok_btn.setOnClickListener(this);
            return rootView;
        }

        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.ok_btn)
            {
                Intent intent = new Intent(getActivity() , MainActivity.class);
                startActivity(intent);
            }
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if(position == 0)
                return new firstfragment();
            else if(position == 1)
                return new secondfragment();
            else
                return new thirdfragment();
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
