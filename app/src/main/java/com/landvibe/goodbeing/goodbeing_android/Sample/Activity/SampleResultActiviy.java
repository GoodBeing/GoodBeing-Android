package com.landvibe.goodbeing.goodbeing_android.Sample.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class SampleResultActiviy extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    private Intent intent;
    private TextView user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_result);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        intent = getIntent();

        user_name = (TextView) findViewById(R.id.sample_result_user_name);
        user_name.setText(intent.getStringExtra("name").toString());


        /* v3.0.2 */
        BarChart barChart = (BarChart)findViewById(R.id.sample_result_bar_chart);

        List<BarEntry> entriesGroup1 = new ArrayList<BarEntry>();

        entriesGroup1.add(new BarEntry(0, 12f));
        entriesGroup1.add(new BarEntry(1, 10f));
        entriesGroup1.add(new BarEntry(2, 8f));
        entriesGroup1.add(new BarEntry(3, 6f));

        BarDataSet set1 = new BarDataSet(entriesGroup1, "Group 1");
        set1.setColor(Color.RED);

        List<BarEntry> entriesGroup2 = new ArrayList<BarEntry>();

        entriesGroup2.add(new BarEntry(0, 6f));
        entriesGroup2.add(new BarEntry(1, 8f));
        entriesGroup2.add(new BarEntry(2, 10f));
        entriesGroup2.add(new BarEntry(3, 12f));

        BarDataSet set2 = new BarDataSet(entriesGroup2, "Group 2");
        set2.setColor(Color.BLUE);

        List<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
        dataSets.add(set1);
        dataSets.add(set2);

        BarData data = new BarData(dataSets);

        float groupSpace = 0.06f;
        float barSpace = 0.02f;
        float barWidth = 0.45f;

        final String[] quaters = new String[]{"Q1", "Q2", "Q3", "Q4"};

        IAxisValueFormatter formatter = new IndexAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quaters[((int) value)];
            }
        };

        XAxis xAxis = barChart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setValueFormatter(formatter);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        data.setBarWidth(barWidth);
        barChart.setData(data);
        barChart.setFitBars(true);
        barChart.groupBars(0, groupSpace, barSpace);
        barChart.invalidate();

        RadarChart radarChart = (RadarChart)findViewById(R.id.sample_result_radar_chart);

        /* RadarChart */
        List<RadarEntry> entries = new ArrayList<>();

        entries.add(new RadarEntry(18.5f, "Green"));
        entries.add(new RadarEntry(26.7f, "Yellow"));
        entries.add(new RadarEntry(24.0f, "Red"));
        entries.add(new RadarEntry(30.8f, "Blue"));

        RadarDataSet set = new RadarDataSet(entries, "Election Results");
        RadarData radarData = new RadarData(set);

        final String[] labels = new String[]{"GREEN", "YELLOW", "RED", "BLUE"};

        IAxisValueFormatter formatter1 = new IndexAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return labels[((int) value)];
            }
        };

        XAxis xAxis1 = radarChart.getXAxis();
        xAxis1.setGranularity(1f);
        xAxis1.setValueFormatter(formatter);
        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);

        radarChart.setData(radarData);
        radarChart.invalidate();
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
            ;
        } else if (id == R.id.nav_faq) {
            ;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        intent = new Intent();
    }
}
