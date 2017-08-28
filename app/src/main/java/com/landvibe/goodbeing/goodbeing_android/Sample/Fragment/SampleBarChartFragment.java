package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.formatter.LargeValueFormatter;
import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;

public class SampleBarChartFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sample_bar_chart, container, false);

        int count = 8;

        float barWidth = 0.25f;
        float barSpace = 0f;
        float groupSpace = 0.5f;

        HorizontalBarChart chart = (HorizontalBarChart)view.findViewById(R.id.sample_result_bar_chart_horizontal);
        chart.setDescription(null);
        chart.setPinchZoom(false);
        chart.setScaleEnabled(false);
        chart.setDrawBarShadow(false);
        chart.setDrawGridBackground(false);

        ArrayList xVals = new ArrayList();

        xVals.add("신체건강");
        xVals.add("유해물 노출");
        xVals.add("해독활동");
        xVals.add("피부노출");
        xVals.add("수면");
        xVals.add("직업");
        xVals.add("주거환경");
        xVals.add("스트레스");

        ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();

        /* 이번달 자료 */
        yVals1.add(new BarEntry(1, (float) 40));
        yVals1.add(new BarEntry(2, (float) 50));
        yVals1.add(new BarEntry(3, (float) 70));
        yVals1.add(new BarEntry(4, (float) 90));
        yVals1.add(new BarEntry(5, (float) 80));
        yVals1.add(new BarEntry(6, (float) 40));
        yVals1.add(new BarEntry(7, (float) 70));
        yVals1.add(new BarEntry(8, (float) 30));

        /* 저번달 자료 */
        yVals2.add(new BarEntry(1, (float) 30));
        yVals2.add(new BarEntry(2, (float) 50));
        yVals2.add(new BarEntry(3, (float) 80));
        yVals2.add(new BarEntry(4, (float) 70));
        yVals2.add(new BarEntry(5, (float) 30));
        yVals2.add(new BarEntry(6, (float) 40));
        yVals2.add(new BarEntry(7, (float) 60));
        yVals2.add(new BarEntry(8, (float) 30));

        BarDataSet set1, set2;
        set1 = new BarDataSet(yVals1, "2017.03");
        set1.setColor(Color.RED);
        set2 = new BarDataSet(yVals2, "2017.02");
        set2.setColor(Color.BLUE);

        BarData data = new BarData(set1, set2);
        data.setValueFormatter(new LargeValueFormatter());
        chart.setData(data);
        chart.getBarData().setBarWidth(barWidth);
        chart.getXAxis().setAxisMinimum(0);
        chart.groupBars(0, groupSpace, barSpace);
        chart.getData().setHighlightEnabled(false);
        chart.invalidate();

        Legend l = chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(true);
        l.setYEntrySpace(0f);
        l.setTextSize(8f);

        //X-axis
        XAxis xAxis = chart.getXAxis();
        xAxis.setGranularity(1f);
        xAxis.setGranularityEnabled(true);
        xAxis.setCenterAxisLabels(true);
        xAxis.setDrawGridLines(false);
        xAxis.setAxisMaximum(count);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));
        //Y-axis
        chart.getAxisLeft().setEnabled(false);
        YAxis rightAxis = chart.getAxisRight();
        rightAxis.setValueFormatter(new LargeValueFormatter());
        rightAxis.setDrawGridLines(true);
        rightAxis.setSpaceTop(35f);
        rightAxis.setAxisMinimum(0f);

        return view;
    }
}
