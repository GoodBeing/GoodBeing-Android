package com.landvibe.goodbeing.goodbeing_android.Intro;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by user on 2017-07-17.
 */

public class Intro_GB_Activity extends IntroActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

     private String story;
     private String link;

     private TextView intro_text_1;
     private TextView intro_text_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introgb);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

         story = "굳빙서비스란\n" +
         "피할 수 없는 유해물질의 노출로부터 개인과 공통체의 질병을 예방하여 좋은 삶(굳빙)을 제공하는 토탈 해독 서비스입니다.\n" +
         "굳빙서비스센터는 세계탑수준의  환경호르몬(내분비장애물질) 등 인체 유해물질 노출분석과" +
         "신토불이 해독기술을  보유하여" +
         "다양한 서비스(제품)를 통해" +
         "건강한 개인과 가족, 사회를 약속합니다.";

         link = "web : www.naver.com \nemail : ajtnlaka456@naver.com\n" +
         "phone : 010-8873-9215 \nmap : 서울특별시 송파구 법원로11길 7 문정현대지식산업센터 C동 1107호";

         intro_text_1 = (TextView) findViewById(R.id.intro_text_1);
         intro_text_link = (TextView) findViewById(R.id.intro_text_link);

         intro_text_1.setText(story);
         intro_text_link.setText(link);

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_intro) {

        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_surveyWrite) {

        } else if (id == R.id.nav_sample) {

        } else if (id == R.id.nav_consulting) {

        } else if (id == R.id.nav_faq) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

    }
}
