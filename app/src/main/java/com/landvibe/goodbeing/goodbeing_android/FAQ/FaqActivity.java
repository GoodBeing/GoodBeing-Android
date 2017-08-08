package com.landvibe.goodbeing.goodbeing_android.FAQ;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.Login.LoginActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class FaqActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener , View.OnClickListener {

    Context mContext;

    private Intent intent;
    private RecyclerView faqRecycleView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<FaqItem> faqItemArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        intent = getIntent();


        mContext = getApplicationContext();

        faqRecycleView = (RecyclerView)findViewById(R.id.faq_recyclerview);

        faqRecycleView.setHasFixedSize(true);





        faqItemArrayList = new ArrayList<FaqItem>();
        faqItemArrayList.add(new FaqItem("첫번째 질문","첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf첫번째 답변fasfsdfsdfasdfdsafasdfasdfsadfdasfsdf",R.drawable.ic_menu_send));
        faqItemArrayList.add(new FaqItem("두번째 질문","두번째 답변",R.drawable.ic_menu_camera));
        faqItemArrayList.add(new FaqItem("세번째 질문","세번째 답변",R.drawable.ic_menu_slideshow));


        layoutManager = new LinearLayoutManager(this);
        faqRecycleView.setLayoutManager(layoutManager);

        adapter = new FaqAdapter(faqItemArrayList);
        faqRecycleView.addOnItemTouchListener(new FaqRecyclerViewOnItemClickListener(this,faqRecycleView, new FaqRecyclerViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                if(view.findViewById(R.id.faq_answer_tv).getVisibility()==view.findViewById(R.id.faq_answer_tv).GONE)
                    view.findViewById(R.id.faq_answer_tv).setVisibility(View.VISIBLE);
                else
                    view.findViewById(R.id.faq_answer_tv).setVisibility(View.GONE);

            }
            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));


        faqRecycleView.setAdapter(adapter);
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
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_faq) {
            intent.setClassName(this , FaqActivity.class.getName());
            startActivity(intent);
        }
        else if(id == R.id.nav_login)
        {
            intent.setClassName(this , LoginActivity.class.getName());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View view) {

        intent = new Intent();
    }
}
