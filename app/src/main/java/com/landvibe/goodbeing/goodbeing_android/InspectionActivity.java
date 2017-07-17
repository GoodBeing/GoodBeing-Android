package com.landvibe.goodbeing.goodbeing_android;

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
import android.widget.Button;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class InspectionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    private Button inspectionMeasureViewBtn;
    private Button inspectionResultViewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspect);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        inspectionMeasureViewBtn = (Button) findViewById(R.id.inspectionMeasureBtn);
        inspectionResultViewBtn = (Button) findViewById(R.id.inspectionResultViewBtn);
        inspectionMeasureViewBtn.setOnClickListener(this);
        inspectionResultViewBtn.setOnClickListener(this);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_intro) {

        } else if (id == R.id.nav_history) {

        } else if (id == R.id.nav_surveyWrite) {
            Intent intent = new Intent(InspectionActivity.this , SurveyWriteActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_measure) {

        } else if (id == R.id.nav_consulting) {

        } else if (id == R.id.nav_faq) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.inspectionMeasureBtn :
                ;
            case R.id.inspectionResultViewBtn :

                Intent intent = new Intent(InspectionActivity.this , InspectionResultActivity.class);
                startActivity(intent);

            default:
                ;
        }

    }
}
