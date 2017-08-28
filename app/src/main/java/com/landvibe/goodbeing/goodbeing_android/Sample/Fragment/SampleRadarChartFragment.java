package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.landvibe.goodbeing.goodbeing_android.R;

import java.util.ArrayList;
import java.util.List;

public class SampleRadarChartFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sample_radar_chart, container, false);

        RadarChart radarChart = (RadarChart)view.findViewById(R.id.sample_result_radar_chart);
        radarChart.setRotationEnabled(false);

        List<RadarEntry> entries = new ArrayList<>();

        entries.add(new RadarEntry(50));
        entries.add(new RadarEntry(60));
        entries.add(new RadarEntry(80));
        entries.add(new RadarEntry(20));
        entries.add(new RadarEntry(60));
        entries.add(new RadarEntry(70));
        entries.add(new RadarEntry(50));
        entries.add(new RadarEntry(80));

        ArrayList xVals = new ArrayList();

        xVals.add("신체건강");
        xVals.add("유해물 노출");
        xVals.add("해독활동");
        xVals.add("피부노출");
        xVals.add("수면");
        xVals.add("직업");
        xVals.add("주거환경");
        xVals.add("스트레스");

        RadarDataSet set = new RadarDataSet(entries, null);
        set.setColor(Color.BLUE);
        set.setDrawFilled(true);
        RadarData radarData = new RadarData(set);

        Legend legend = radarChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setAxisMinimum(0);
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        YAxis yAxis = radarChart.getYAxis();
        yAxis.setAxisMinimum(0);
        yAxis.setAxisMaximum(80);
        yAxis.setDrawLabels(false);

        radarChart.getLegend().setEnabled(false);
        radarChart.setDescription(null);
        radarChart.setData(radarData);
        radarChart.invalidate();

        return view;
    }
}
