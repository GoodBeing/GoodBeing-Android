package com.landvibe.goodbeing.goodbeing_android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by 고승빈 on 2017-07-17.
 */
public class HistoryActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private WebView webView;

    private RecyclerView historyRecycleView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<HistoryItem> historyItemArrayList;

    private Intent intent;

    private ProgressBar progressBar;

    @Override
    synchronized
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // chart webview
        webView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBuiltInZoomControls(true);

        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.setWebViewClient(new WebViewClient() {

            // ProgressBar 적용
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            public void onPageStarted(WebView view, String url,
                                      android.graphics.Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar = (ProgressBar) findViewById(R.id.progress);
                progressBar.bringToFront();
                progressBar.getIndeterminateDrawable().setColorFilter(0xFF98ff98, android.graphics.PorterDuff.Mode.SRC_ATOP);
                progressBar.setVisibility(View.VISIBLE);
            }

            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.INVISIBLE);
            }


            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                Toast.makeText(HistoryActivity.this, "Error : " + description,
                        Toast.LENGTH_SHORT).show();
            }

        });

        webView.loadUrl("file:///android_asset/GraphChart.html");

        //RecycleView
        historyRecycleView = (RecyclerView) findViewById(R.id.history_recycler_view);

        historyRecycleView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        historyRecycleView.setLayoutManager(layoutManager);

        // DataSet
        historyItemArrayList = new ArrayList<HistoryItem>();
        historyItemArrayList.add(new HistoryItem("강승모" , true , 26 , 4));
        historyItemArrayList.add(new HistoryItem("이상직" , true , 26 , 3));
        historyItemArrayList.add(new HistoryItem("박재형" , true , 22 , 1));
        historyItemArrayList.add(new HistoryItem("김나라" , false , 26 , 4));
        historyItemArrayList.add(new HistoryItem("사진좀" , true , 29 , 2));
        historyItemArrayList.add(new HistoryItem("너이다" , false , 34 , 2));
        historyItemArrayList.add(new HistoryItem("코카콜라" , false , 21 , 1));
        historyItemArrayList.add(new HistoryItem("펩시" , false , 29 , 3));

        adapter = new HistoryListAdapter(historyItemArrayList);
        historyRecycleView.setAdapter(adapter);

        historyRecycleView.addOnItemTouchListener(new HistoryRecycleViewOnItemClickListener(this.getApplicationContext(), historyRecycleView, new HistoryRecycleViewOnItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {

                intent = new Intent();
                intent.putExtra("index" , position);
                intent.setClassName(getApplicationContext() , SurveyResultActiviy.class.getName());

                startActivity(intent);
            }
        }));



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
            ;
        } else if (id == R.id.nav_history) {
            onRestart();
        } else if (id == R.id.nav_surveyWrite) {
            intent.setClassName(this, SurveySearchActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_measure) {
            intent.setClassName(this, InspectionMeasureActivity.class.getName());
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
