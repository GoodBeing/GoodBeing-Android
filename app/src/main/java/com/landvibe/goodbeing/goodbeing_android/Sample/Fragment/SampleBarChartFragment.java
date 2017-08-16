package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
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

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SampleBarChartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SampleBarChartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SampleBarChartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public SampleBarChartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SampleBarChartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SampleBarChartFragment newInstance(String param1, String param2) {
        SampleBarChartFragment fragment = new SampleBarChartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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

        xVals.add("비스페놀A");
        xVals.add("노화");
        xVals.add("수면");
        xVals.add("유해식품");
        xVals.add("비스페놀A");
        xVals.add("노화");
        xVals.add("수면");
        xVals.add("유해식품");

        ArrayList yVals1 = new ArrayList();
        ArrayList yVals2 = new ArrayList();

        /* 저번달 자료 */
        yVals1.add(new BarEntry(1, (float) 1));
        yVals1.add(new BarEntry(2, (float) 4));
        yVals1.add(new BarEntry(3, (float) 7));
        yVals1.add(new BarEntry(4, (float) 10));
        yVals1.add(new BarEntry(5, (float) 1));
        yVals1.add(new BarEntry(6, (float) 4));
        yVals1.add(new BarEntry(7, (float) 7));
        yVals1.add(new BarEntry(8, (float) 10));

        /* 이번달 자료 */
        yVals2.add(new BarEntry(1, (float) 5));
        yVals2.add(new BarEntry(2, (float) 2));
        yVals2.add(new BarEntry(3, (float) 8));
        yVals2.add(new BarEntry(4, (float) 11));
        yVals2.add(new BarEntry(5, (float) 3));
        yVals2.add(new BarEntry(6, (float) 6));
        yVals2.add(new BarEntry(7, (float) 9));
        yVals2.add(new BarEntry(8, (float) 12));

        BarDataSet set1, set2;
        set1 = new BarDataSet(yVals1, "2017.02");
        set1.setColor(Color.RED);
        set2 = new BarDataSet(yVals2, "2017.03");
        set2.setColor(Color.BLUE);

        BarData data = new BarData(set1, set2);
        data.setValueFormatter(new LargeValueFormatter());
        chart.setData(data);
        chart.getBarData().setBarWidth(barWidth);
        chart.getXAxis().setAxisMinimum(0);
        //chart.getXAxis().setAxisMaximum(0 + chart.getBarData().getGroupWidth(groupSpace, barSpace) * groupCount);
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
