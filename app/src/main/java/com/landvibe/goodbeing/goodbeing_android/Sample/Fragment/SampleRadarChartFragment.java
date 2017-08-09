package com.landvibe.goodbeing.goodbeing_android.Sample.Fragment;

import android.content.Context;
import android.net.Uri;
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

import static android.R.attr.y;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SampleRadarChartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SampleRadarChartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SampleRadarChartFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public SampleRadarChartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SampleRadarChartFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SampleRadarChartFragment newInstance(String param1, String param2) {
        SampleRadarChartFragment fragment = new SampleRadarChartFragment();
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

        View view = inflater.inflate(R.layout.fragment_sample_radar_chart, container, false);

        RadarChart radarChart = (RadarChart)view.findViewById(R.id.sample_result_radar_chart);
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

        Legend legend = radarChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        radarChart.getYAxis().setEnabled(false);
        radarChart.setDescription(null);
        radarChart.setData(radarData);
        radarChart.invalidate();

        return view;
    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
