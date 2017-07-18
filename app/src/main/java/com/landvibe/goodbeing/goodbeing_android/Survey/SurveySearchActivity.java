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

import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Inspection.InspectionMeasureActivity;
import com.landvibe.goodbeing.goodbeing_android.R;

/**
 * Created by 고승빈 on 2017-07-14.
 */
public class SurveySearchActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Intent intent;

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
           onRestart();
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

}
