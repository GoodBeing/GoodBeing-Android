package com.landvibe.goodbeing.goodbeing_android.Survey;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.landvibe.goodbeing.goodbeing_android.FAQ.FaqActivity;
import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.Main.MainActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item.SurveyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class SurveyResultActiviy extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {


    private Intent intent;
    private Button gomain;
    private Button gocategory;
    private Button gosample;

    private TextView result_score;
    private TextView result_opinion;
    private float section_depoison =0;
    private float section_bodyhealth =0;
    private float section_stress =0;
    private float section_house =0;
    private float section_job =0;
    private float section_sleep =0;
    private float section_skin =0;
    private float section_main =0;
    private ArrayList<SurveyItem> arraysurvey;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveyresult);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        arraysurvey = new ArrayList<SurveyItem>();
        gomain = (Button)findViewById(R.id.survey_result_gomain_btn);
        gocategory = (Button)findViewById(R.id.survey_result_gocategory_btn);
        gosample = (Button)findViewById(R.id.survey_result_gosample_btn);
        result_score =(TextView)findViewById(R.id.survey_result_score);
        result_opinion = (TextView)findViewById(R.id.survey_result_opinion);

        Intent intt = getIntent();
        arraysurvey = intt.getParcelableArrayListExtra("SURVEY_RESULT");
        int resultscore = 0;
        for(int i = 0;i<arraysurvey.size();i++)
        {
            Log.d("score is : ",i + "번 점수는 "+arraysurvey.get(i).getScore());
            resultscore += arraysurvey.get(i).getScore();
        }
        resultscore = (int)(resultscore*0.7);

        result_score.setText("" + resultscore);

        if(resultscore>=70)
            result_opinion.setText("당신의 굳빙 상태는 매우 위협받고 있습니다! \n 유해물질에 고노출 되고 있으니 해독이 꼭필요합니다!");
        else if(resultscore <70 && 25<resultscore)
            result_opinion.setText("당신의 굳빙 상태는 평범합니다! \n 하지만 어느정도 유해물질에 노출되고 있으니 해독을 권장합니다!");
        else
            result_opinion.setText("당신의 굳빙 상태는 매우 좋습니다! \n 현재 상태를 잘 유지하여 굳빙을 이어가세요!");

        cal8section(arraysurvey);
        RadarChart radarChart = (RadarChart)findViewById(R.id.survey_result_radar_chart);
        radarChart.setRotationEnabled(false);

        /* 그래프 데이터 입력 */
        List<RadarEntry> entries = new ArrayList<>();

        entries.add(new RadarEntry(section_stress));
        entries.add(new RadarEntry(section_house));
        entries.add(new RadarEntry(section_job));
        entries.add(new RadarEntry(section_sleep));
        entries.add(new RadarEntry(section_skin));
        entries.add(new RadarEntry(section_depoison));
        entries.add(new RadarEntry(section_main));
        entries.add(new RadarEntry(section_bodyhealth));

        /* 그래프 라벨 입력 */
        ArrayList xVals = new ArrayList();

        xVals.add("스트레스");
        xVals.add("주거환경");
        xVals.add("직업");
        xVals.add("수면");
        xVals.add("피부노출");
        xVals.add("해독활동");
        xVals.add("유해물 노출");
        xVals.add("신체건강");

        /* 데이터 세부 설정 */
        RadarDataSet set = new RadarDataSet(entries, null);
        set.setColor(Color.BLUE);
        set.setDrawFilled(true);
        RadarData radarData = new RadarData(set);

        /* 목차 설정 */
        Legend legend = radarChart.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);

        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(xVals));

        /* 그래프 설정 */
        radarChart.getYAxis().setEnabled(false);
        radarChart.getLegend().setEnabled(false);
        radarChart.setDescription(null);
        radarChart.setData(radarData);
        radarChart.invalidate();

        gomain.setOnClickListener(this);
        gocategory.setOnClickListener(this);
        gosample.setOnClickListener(this);
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
            intent.setClassName(this , SampleMainActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_faq) {
            intent.setClassName(this , FaqActivity.class.getName());
            startActivity(intent);
        }
        else if(id == R.id.nav_login)
        {
            intent.setClassName(this , SampleMainActivity.class.getName());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        intent = new Intent();
        if(view.getId() == R.id.survey_result_gomain_btn)
        {
            Intent intent = new Intent(this , MainActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.survey_result_gocategory_btn)
        {
            Intent intent = new Intent(this , SurveySearchActivity.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.survey_result_gosample_btn)
        {
            Intent intent = new Intent(this , SampleMainActivity.class);
            startActivity(intent);
        }
    }

    public void cal8section(ArrayList<SurveyItem> array)
    {
        for(int i = 0; i< array.size();i++) {
            if (array.get(i).getCode() == 1)
                section_bodyhealth += array.get(i).getScore();
            else if (array.get(i).getCode() == 2)
                section_stress += array.get(i).getScore();
            else if (array.get(i).getCode() == 3)
                section_house += array.get(i).getScore();
            else if (array.get(i).getCode() == 4)
                section_job += array.get(i).getScore();
            else if (array.get(i).getCode() == 5)
                section_sleep += array.get(i).getScore();
            else if (array.get(i).getCode() == 6)
                section_skin += array.get(i).getScore();
            else if (array.get(i).getCode() == 7)
                section_depoison += array.get(i).getScore();
            else
                section_main += array.get(i).getScore();
        }

        section_bodyhealth = 5-((section_bodyhealth*5)/16);
        if(section_bodyhealth<=0)
            section_bodyhealth = 0;

        section_stress = 5-((section_stress*5)/14);
        if(section_stress<=0)
            section_stress = 0;

        section_house = 5-((section_house*5)/11);
        if(section_house<=0)
            section_house = 0;

        section_job = 5-((section_job*5)/6);
        if(section_job<=0)
            section_job = 0;

        section_sleep = 5-((section_sleep*5)/10);
        if(section_sleep<=0)
            section_sleep = 0;

        section_skin = 5-((section_skin*5)/13);
        if(section_skin<=0)
            section_skin = 0;

        section_depoison = ((section_depoison*5)/27);
        if(section_depoison<=0)
            section_depoison = 0;
        section_main = ((section_main*5)/75);
        if(section_main<=0)
            section_main = 0;
    }
}
