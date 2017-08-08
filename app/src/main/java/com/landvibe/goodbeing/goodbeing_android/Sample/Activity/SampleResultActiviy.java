package com.landvibe.goodbeing.goodbeing_android.Sample.Activity;

import android.content.Intent;
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

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
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

        //        barWidth = 0.25f;
//        barSpace = 0f;
//        groupSpace = 0.25f;
//
//        BarChart chart = (BarChart)findViewById(R.id.sample_result_bar_chart);
//        chart.setDescription(null);
//        chart.setPinchZoom(false);
//        chart.setScaleEnabled(false);
//        chart.setDrawBarShadow(false);
//        chart.setDrawGridBackground(false);
//
//        ArrayList xVals = new ArrayList();
//
//        xVals.add("비스페놀A");
//        xVals.add("노화");
//        xVals.add("수면");
//        xVals.add("유해식품");
//
//        ArrayList yVals1 = new ArrayList();
//        ArrayList yVals2 = new ArrayList();
//        ArrayList yVals3 = new ArrayList();
//
//        yVals1.add(new BarEntry(1, (float) 1));
//        yVals2.add(new BarEntry(1, (float) 2));
//        yVals3.add(new BarEntry(1, (float) 3));
//        yVals1.add(new BarEntry(2, (float) 4));
//        yVals2.add(new BarEntry(2, (float) 5));
//        yVals3.add(new BarEntry(2, (float) 6));
//        yVals1.add(new BarEntry(3, (float) 7));
//        yVals2.add(new BarEntry(3, (float) 8));
//        yVals3.add(new BarEntry(3, (float) 9));
//        yVals1.add(new BarEntry(4, (float) 10));
//        yVals2.add(new BarEntry(4, (float) 11));
//        yVals3.add(new BarEntry(4, (float) 12));
//
//        BarDataSet set1, set2, set3;
//        set1 = new BarDataSet(yVals1, "2017.02");
//        set1.setColor(Color.RED);
//        set2 = new BarDataSet(yVals2, "2017.03");
//        set2.setColor(Color.BLUE);
//        set3 = new BarDataSet(yVals3, "2017.04");
//        set2.setColor(Color.GREEN);
//        BarData data = new BarData(set1, set2, set3);
//        data.setValueFormatter(new LargeValueFormatter());
//        chart.setData(data);
//        chart.getBarData().setBarWidth(barWidth);
//        chart.getXAxis().setAxisMinimum(0);
//        //chart.getXAxis().setAxisMaximum(0 + chart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
//        chart.groupBars(0, groupSpace, barSpace);
//        chart.getData().setHighlightEnabled(false);
//        chart.invalidate();
//
//        Legend l = chart.getLegend();
//        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
//        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
//        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        l.setDrawInside(true);
//        l.setYOffset(20f);
//        l.setXOffset(0f);
//        l.setYEntrySpace(0f);
//        l.setTextSize(8f);
//
//        //X-axis
//        XAxis xAxis = chart.getXAxis();
//        xAxis.setGranularity(1f);
//        xAxis.setGranularityEnabled(true);
//        xAxis.setCenterAxisLabels(true);
//        xAxis.setDrawGridLines(false);
//        xAxis.setAxisMaximum(4);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
//        //Y-axis
//        chart.getAxisRight().setEnabled(false);
//        YAxis leftAxis = chart.getAxisLeft();
//        leftAxis.setValueFormatter(new LargeValueFormatter());
//        leftAxis.setDrawGridLines(true);
//        leftAxis.setSpaceTop(35f);
//        leftAxis.setAxisMinimum(0f);

        /* RadarChart */
        RadarChart radarChart = (RadarChart)findViewById(R.id.sample_result_radar_chart);
        radarChart.setRotationEnabled(false);

        List<RadarEntry> entries = new ArrayList<>();

        entries.add(new RadarEntry(10f));
        entries.add(new RadarEntry(20f));
        entries.add(new RadarEntry(30f));
        entries.add(new RadarEntry(40f));
        entries.add(new RadarEntry(10f));
        entries.add(new RadarEntry(20f));
        entries.add(new RadarEntry(30f));
        entries.add(new RadarEntry(40f));

        ArrayList xVals = new ArrayList();

        xVals.add("주거");
        xVals.add("노화");
        xVals.add("직업");
        xVals.add("수면");
        xVals.add("화장품");
        xVals.add("해독식품");
        xVals.add("유해식품");
        xVals.add("신진대사");

        RadarDataSet set = new RadarDataSet(entries, "Election Results");
        RadarData radarData = new RadarData(set);

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        YAxis yAxis = radarChart.getYAxis();
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(50);

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
