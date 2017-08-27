package com.landvibe.goodbeing.goodbeing_android.Intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.landvibe.goodbeing.goodbeing_android.FAQ.FaqActivity;
import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

/**
 * Created by user on 2017-07-17.
 */

public class IntroActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    static final String[] LIST_MENU = {"굳빙서비스란","굳빙서비스의 목적","핵심 기술","굳빙서비스의 종류","도움주신 분"};
    //private ListView list_name;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,LIST_MENU);

        ListView listView =(ListView) findViewById(R.id.intro_listview);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);
                if(position == 0)
                {
                    Intent intent0 = new Intent(IntroActivity.this,Intro_GB_Activity.class);
                    startActivity(intent0);
                }
                if(position == 1)
                {
                    Intent intent1 = new Intent(IntroActivity.this,Intro_Purpose_Activity.class);
                    startActivity(intent1);
                }
                if(position == 2)
                {
                    Intent intent2 = new Intent(IntroActivity.this,Intro_Skill_Activity.class);
                    startActivity(intent2);
                }
                if(position == 3)
                {
                    Intent intent3 = new Intent(IntroActivity.this,Intro_Service_Activity.class);
                    startActivity(intent3);
                }
                if(position == 4)
                {
                    Intent intent4 = new Intent(IntroActivity.this,Intro_Professor_Activity.class);
                    startActivity(intent4);
                }
            }
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

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
    public void onClick(View v) {

    }
}
