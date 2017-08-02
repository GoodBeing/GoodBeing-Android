package com.landvibe.goodbeing.goodbeing_android.History;

import android.content.Intent;
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
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.landvibe.goodbeing.goodbeing_android.History.Adapter.HistoryViewPagerAdapter;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

import java.util.ArrayList;
import java.util.List;

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

        LineChart lineChart = (LineChart) findViewById(R.id.history_linechart);

        List<Entry> valsComp1 = new ArrayList<Entry>();

        valsComp1.add(new Entry(0, 10f));
        valsComp1.add(new Entry(1, 12f));
        valsComp1.add(new Entry(2, 14f));
        valsComp1.add(new Entry(3, 16f));

        LineDataSet setComp1 = new LineDataSet(valsComp1, "Company 1");

        List<Entry> valsComp2 = new ArrayList<Entry>();

        valsComp2.add(new Entry(0, 14f));
        valsComp2.add(new Entry(1, 12f));
        valsComp2.add(new Entry(2, 10f));
        valsComp2.add(new Entry(3, 8f));

        LineDataSet setComp2 = new LineDataSet(valsComp2, "Company 2");

        List<ILineDataSet> datasets = new ArrayList<ILineDataSet>();
        datasets.add(setComp1);
        datasets.add(setComp2);

        LineData data = new LineData(datasets);

        final String[] quaters = new String[]{"Q1", "Q2", "Q3", "Q4"};

        IAxisValueFormatter formatter = new IndexAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quaters[((int) value)];
            }
        };
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        lineChart.setData(data);
        lineChart.invalidate();

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
            onRestart();
        } else if (id == R.id.nav_surveyWrite) {
            intent.setClassName(this, SurveySearchActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_sample) {
            intent.setClassName(this, SampleMainActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_consulting) {
            ;
        } else if (id == R.id.nav_faq) {
            ;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
