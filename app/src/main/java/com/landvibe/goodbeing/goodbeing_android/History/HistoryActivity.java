package com.landvibe.goodbeing.goodbeing_android.History;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.landvibe.goodbeing.goodbeing_android.FAQ.FaqActivity;
import com.landvibe.goodbeing.goodbeing_android.History.Adapter.HistoryViewPagerAdapter;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.Login.LoginActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class HistoryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*
      WebView
   */
    private WebView webView;

    private Intent intent;

    /*
        ProgressBar
    */
    private ProgressBar progressBar;

    /*
       ViewPager
    */
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    synchronized
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // chart webview
        LineChart lineChart = (LineChart)findViewById(R.id.history_linechart);
        lineChart.setDescription(null);
        lineChart.setPinchZoom(false);
        lineChart.setScaleEnabled(false);
        lineChart.setDrawGridBackground(false);

        ArrayList xVals = new ArrayList();
        xVals.add("2017.03");
        xVals.add("2017.04");
        xVals.add("2017.05");
        xVals.add("2017.06");

        ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();
        ArrayList yVals3 = new ArrayList();
        ArrayList yVals4 = new ArrayList();

        yVals1.add(new BarEntry(0, (float) 1));
        yVals2.add(new BarEntry(0, (float) 2));
        yVals3.add(new BarEntry(0, (float) 3));
        yVals4.add(new BarEntry(0, (float) 8));
        yVals1.add(new BarEntry(1, (float) 5));
        yVals2.add(new BarEntry(1, (float) 6));
        yVals3.add(new BarEntry(1, (float) 7));
        yVals4.add(new BarEntry(1, (float) 6));
        yVals1.add(new BarEntry(2, (float) 3));
        yVals2.add(new BarEntry(2, (float) 4));
        yVals3.add(new BarEntry(2, (float) 11));
        yVals4.add(new BarEntry(2, (float) 2));
        yVals1.add(new BarEntry(3, (float) 15));
        yVals2.add(new BarEntry(3, (float) 14));
        yVals3.add(new BarEntry(3, (float) 15));
        yVals4.add(new BarEntry(3, (float) 10));

        LineDataSet set1, set2, set3, set4;
        set1 = new LineDataSet(yVals1, "비스페놀A");
        set1.setColor(Color.RED);
        set2 = new LineDataSet(yVals2, "노화");
        set2.setColor(Color.BLUE);
        set3 = new LineDataSet(yVals3, "수면");
        set3.setColor(Color.GREEN);
        set4 = new LineDataSet(yVals4, "유해식품");
        set4.setColor(Color.YELLOW);

        LineData data = new LineData(set1, set2, set3, set4);
        data.setValueFormatter(new LargeValueFormatter());
        lineChart.setData(data);
        lineChart.invalidate();

        XAxis xAxis = lineChart.getXAxis();
        xAxis.setGranularity(1f);
//        xAxis.setGranularityEnabled(true);
//        xAxis.setCenterAxisLabels(true);
//        xAxis.setDrawGridLines(false);
//        xAxis.setAxisMinimum(0);
//        xAxis.setAxisMaximum(3);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.history_tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("전체"));
        tabLayout.addTab(tabLayout.newTab().setText("진행"));
        tabLayout.addTab(tabLayout.newTab().setText("완료"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.history_viewpager);

        HistoryViewPagerAdapter historyViewPagerAdapter = new HistoryViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(historyViewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        intent = new Intent();

        if (id == R.id.nav_intro) {
            intent.setClassName(this , IntroActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_history) {
            intent.setClassName(this , HistoryActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_surveyWrite) {
            intent.setClassName(this , SurveySearchActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_sample) {
            intent.setClassName(this , SampleMainActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_consulting) {
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_faq) {
            intent.setClassName(this , FaqActivity.class.getName());
            startActivity(intent);
        }
        else if(id == R.id.nav_login)
        {
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
