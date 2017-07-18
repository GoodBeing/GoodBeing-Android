package com.landvibe.goodbeing.goodbeing_android.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Inspection.InspectionMeasureActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener{


    private Button mainSurveyBtn;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // 설문 조사 버튼 선언
        mainSurveyBtn = (Button) findViewById(R.id.mainSurveyBtn);
        mainSurveyBtn.setOnClickListener(this);
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
            ;
        } else if (id == R.id.nav_history) {
            intent.setClassName(this , HistoryActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_surveyWrite) {
            intent.setClassName(this , SurveySearchActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_measure) {
            intent.setClassName(this , InspectionMeasureActivity.class.getName());
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

        if(view.getId() == R.id.mainSurveyBtn)
        {
            intent.setClassName(this , SurveySearchActivity.class.getName());
            startActivity(intent);
        }
    }
}