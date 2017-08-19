package com.landvibe.goodbeing.goodbeing_android.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.landvibe.goodbeing.goodbeing_android.FAQ.FaqActivity;
import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

import java.util.List;

public class MainAfterLoginActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener
//,ViewFlipperAction.ViewFlipperCallback
{
    private ImageButton enter_intro_ibtn;
    private ImageButton enter_survey_ibtn;
    private ImageButton enter_sample_ibtn;
    private ImageButton enter_myinfo_ibtn;
    private ImageButton enter_history_ibtn;
    private ImageButton enter_faq_ibtn;

    private Intent intent;

    private ViewFlipper flipper;
    private List<ImageView> indexes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_after_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);




        enter_intro_ibtn = (ImageButton)findViewById(R.id.enter_intro_ibtn);
        enter_survey_ibtn = (ImageButton)findViewById(R.id.enter_survey_ibtn);
        enter_sample_ibtn = (ImageButton)findViewById(R.id.enter_sample_ibtn);
        enter_myinfo_ibtn = (ImageButton)findViewById(R.id.enter_myinfo_ibtn);
        enter_history_ibtn = (ImageButton)findViewById(R.id.enter_history_ibtn);
        enter_faq_ibtn = (ImageButton)findViewById(R.id.enter_faq_ibtn);

        enter_intro_ibtn.setOnClickListener(this);
        enter_survey_ibtn.setOnClickListener(this);
        enter_sample_ibtn.setOnClickListener(this);
        enter_myinfo_ibtn.setOnClickListener(this);
        enter_history_ibtn.setOnClickListener(this);
        enter_faq_ibtn.setOnClickListener(this);



        flipper = (ViewFlipper)findViewById(R.id.viewflipper);
//        ImageView index1 = (ImageView)findViewById(R.id.imgIndex1);
//        ImageView index2 = (ImageView)findViewById(R.id.imgIndex2);
//        ImageView index3 = (ImageView)findViewById(R.id.imgIndex3);
//        indexes = new ArrayList<>();
//        indexes.add(index1);
//        indexes.add(index2);
//        indexes.add(index3);


        LayoutInflater inflater = (LayoutInflater)getSystemService(LAYOUT_INFLATER_SERVICE);
        View view1 = inflater.inflate(R.layout.bannerview1, flipper, false);
        View view2 = inflater.inflate(R.layout.bannerview2, flipper, false);
        View view3 = inflater.inflate(R.layout.bannerview3, flipper, false);
        //inflate 한 view 추가
        flipper.addView(view1);
        flipper.addView(view2);
        flipper.addView(view3);

        flipper.setOnTouchListener(new ViewFlipperAction(this, flipper));
        flipper.setFlipInterval(3000);
        flipper.startFlipping();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

        switch(view.getId())
        {
            case R.id.enter_intro_ibtn:
                intent = new Intent(this , IntroActivity.class);
                startActivity(intent);
                break;
            case R.id.enter_survey_ibtn:
                intent = new Intent(this , SurveySearchActivity.class);
                startActivity(intent);
                break;
            case R.id.enter_sample_ibtn:
                intent = new Intent(this , SampleMainActivity.class);
                startActivity(intent);
                break;
            case R.id.enter_myinfo_ibtn:
                intent= new Intent(this , MainActivity.class);
                startActivity(intent);
                break;
            case R.id.enter_history_ibtn:
                intent= new Intent(this , HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.enter_faq_ibtn:
                intent = new Intent(this , FaqActivity.class);
                startActivity(intent);
                break;

        }
    }


//    @Override
//    public void onFlipperActionCallback(int position) {
//        for(int i=0; i<indexes.size(); i++){
//            ImageView index = indexes.get(i);
//            //현재화면의 인덱스 위치면 녹색
//            if(i == position){
//                index.setImageResource(R.drawable.check_circle);
//            }
//            //그외
//            else{
//                index.setImageResource(R.drawable.white_circle);
//            }
//        }
//    }
}
