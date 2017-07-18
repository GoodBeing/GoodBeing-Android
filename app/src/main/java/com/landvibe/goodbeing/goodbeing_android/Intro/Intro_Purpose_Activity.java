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

public class Intro_Purpose_Activity extends IntroActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    private String story;
    private String link;

    private TextView intro_text_1;
    private TextView intro_text_link;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intropurpose);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        story = "저출산 시대에 태어나는 귀한 \n" +
                "새 생명, \n" +
                "이들의 건강에 우리의 미래가 달려있읍니다.\n" +
                "건강한 임신\n" +
                "건강한 유아\n" +
                "건강한 청소년\n" +
                "을 위하여 굳빙센터가 있읍니다.\n" +
                "\n" +
                "굳빙센터는 \n" +
                "1. 일반인이 쉽게 자신의 유해물질노출정도를 파악할 수 있게 합니다.\n" +
                "2. 유해물질의 노출을 생활속에서 줄이고 해독하도록 돕습니다.\n" +
                "3. 식이 등 생활습관 등을 분석하여 맞춤형 예방을 가능하게 합니다.\n" +
                "4. 개인, 가족, 직장, 지역, 공동체의 굳빙을 자문하여 드립니다. \n";

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

        } else if (id == R.id.nav_measure) {

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
