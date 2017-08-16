package com.landvibe.goodbeing.goodbeing_android.Survey;

import android.content.Intent;
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

import com.landvibe.goodbeing.goodbeing_android.FAQ.FaqActivity;
import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.Main.MainActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Item.SurveyItem;

import java.util.ArrayList;

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
        result_score.setText("당신의 굳빙 지수는 " + resultscore + " 입니다.");



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
}
