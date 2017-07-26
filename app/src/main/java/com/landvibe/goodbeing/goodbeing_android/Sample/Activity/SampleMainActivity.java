package com.landvibe.goodbeing.goodbeing_android.Sample.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ProgressBar;

import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Adapter.SampleViewPagerAdapter;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class SampleMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private Intent intent;

    /*
        ProgressBar
    */
    private ProgressBar progressBar;

    /*
       ViewPager
    */
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    synchronized
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Initializing the TabLayout
        tabLayout = (TabLayout) findViewById(R.id.sample_main_tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("전체"));
        tabLayout.addTab(tabLayout.newTab().setText("진행"));
        tabLayout.addTab(tabLayout.newTab().setText("완료"));

        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager)findViewById(R.id.sample_main_viewpager);

        SampleViewPagerAdapter sampleViewPagerAdapter = new SampleViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(sampleViewPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });

    }

    @Override
    protected void onStart() {
        super.onStart();

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
            onRestart();
        } else if (id == R.id.nav_surveyWrite) {
            intent.setClassName(this, SurveySearchActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_sample) {
            intent.setClassName(this, SampleMainActivity.class.getName());
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

}
