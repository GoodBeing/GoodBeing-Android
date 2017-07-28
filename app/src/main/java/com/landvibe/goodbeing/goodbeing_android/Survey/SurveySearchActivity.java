package com.landvibe.goodbeing.goodbeing_android.Survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One.Activity.SurveyWriteActivity;

/**
 * Created by 고승빈 on 2017-07-14.
 */
public class SurveySearchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener{

    private Intent intent;

    private ImageView pregnant;
    private ImageView publicPerson;
    private ImageView child;
    private ImageView oldMan;
    private ImageView disabled;
    private ImageView other;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveysearch);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Declare ImageView
        ImageView pregnant = (ImageView) findViewById(R.id.pregnant);
        ImageView publicPerson  = (ImageView) findViewById(R.id.publicPerson);
        ImageView child  = (ImageView) findViewById(R.id.child);
        ImageView oldMan  = (ImageView) findViewById(R.id.oldMan);
        ImageView disabled  = (ImageView) findViewById(R.id.disabled);
        ImageView other  = (ImageView) findViewById(R.id.other);

        pregnant.setOnClickListener(this);
        publicPerson.setOnClickListener(this);
        child.setOnClickListener(this);
        oldMan.setOnClickListener(this);
        disabled.setOnClickListener(this);
        other.setOnClickListener(this);

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
           onRestart();
        } else if (id == R.id.nav_sample) {
            intent.setClassName(this , SampleMainActivity.class.getName());
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
        intent.setClassName(this , SurveyWriteActivity.class.getName());
        startActivity(intent);
    }
}
