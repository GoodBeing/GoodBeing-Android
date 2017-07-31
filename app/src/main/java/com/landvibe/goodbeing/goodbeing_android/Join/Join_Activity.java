package com.landvibe.goodbeing.goodbeing_android.Join;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.landvibe.goodbeing.goodbeing_android.History.HistoryActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.IntroActivity;
import com.landvibe.goodbeing.goodbeing_android.Intro.Intro_GB_Activity;
import com.landvibe.goodbeing.goodbeing_android.Login.Login_Activity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Sample.Activity.SampleMainActivity;
import com.landvibe.goodbeing.goodbeing_android.Survey.SurveySearchActivity;

/**
 * Created by user on 2017-07-31.
 */

public class Join_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    private EditText et_id,et_pw,et_pw_confirm,et_name;
    private EditText et_birth_year,et_birth_month,et_birth_day,et_height,et_weight;
    private EditText et_place,et_firstphone,et_secondphone,et_thirdphone,et_email,et_parent_id;
    private String sId,sPw,sPw_confirm,sName,sBirth,sHeight,sWeight,sPlace,sPhone,sEmail,sParent_id;
    private Intent intent;

    private Button join_but,id_but,phone_but,email_but,parent_id_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        et_id=(EditText)findViewById(R.id.et_id);
        et_pw=(EditText)findViewById(R.id.et_pw);
        et_pw_confirm=(EditText)findViewById(R.id.et_pw_confirm);
        et_name=(EditText)findViewById(R.id.et_name);
        et_birth_year=(EditText)findViewById(R.id.et_birth_year);
        et_birth_month=(EditText)findViewById(R.id.et_birth_month);
        et_birth_day=(EditText)findViewById(R.id.et_birth_day);
        et_height=(EditText)findViewById(R.id.et_height);
        et_weight=(EditText)findViewById(R.id.et_weight);
        et_place=(EditText)findViewById(R.id.et_place);
        et_firstphone=(EditText)findViewById(R.id.et_firstphone);
        et_secondphone=(EditText)findViewById(R.id.et_secondphone);
        et_thirdphone=(EditText)findViewById(R.id.et_thirdphone);
        et_email=(EditText)findViewById(R.id.et_email);
        et_parent_id=(EditText)findViewById(R.id.et_parent_id);


        sId=et_id.getText().toString();
        sPw=et_pw.getText().toString();
        sPw_confirm=et_pw_confirm.getText().toString();
        sName=et_name.getText().toString();
        sBirth=et_birth_year.getText().toString()+et_birth_month.getText().toString()+et_birth_day.getText().toString();
        sHeight=et_height.getText().toString();
        sWeight=et_weight.getText().toString();
        sPlace=et_place.getText().toString();
        sPhone=et_firstphone.getText().toString()+et_secondphone.getText().toString()+et_thirdphone.getText().toString();
        sEmail=et_email.getText().toString();
        sParent_id=et_parent_id.getText().toString();

        join_but=(Button)findViewById(R.id.join_but);
        join_but.setOnClickListener(this);

        id_but=(Button)findViewById(R.id.id_but);
        id_but.setOnClickListener(this);

        phone_but=(Button)findViewById(R.id.phone_but);
        phone_but.setOnClickListener(this);

        email_but=(Button)findViewById(R.id.email_but);
        email_but.setOnClickListener(this);

        parent_id_but=(Button)findViewById(R.id.parent_id_but);
        parent_id_but.setOnClickListener(this);

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
            ;
        } else if (id == R.id.nav_faq) {
            ;
        }else if (id ==R.id.nav_log) {
            intent.setClassName(this ,Login_Activity.class.getName());
            startActivity(intent);
        }else if (id==R.id.nav_join){
            intent.setClassName(this ,Join_Activity.class.getName());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        if(v==join_but){
            new AlertDialog.Builder(this)
                    .setTitle("회원가입 완료!")
                    .setMessage("회원가입이 완료되었습니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something){
                        }
                    })
                    .show();
        }else if(v==id_but){
            new AlertDialog.Builder(this)
                    .setTitle("사용가능!")
                    .setMessage("사용가능한 아이디 입니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something){
                        }
                    })
                    .show();
        }else if(v==phone_but){
            new AlertDialog.Builder(this)
                    .setTitle("인증완료!")
                    .setMessage("핸드폰 인증이 완료되었습니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something){
                        }
                    })
                    .show();
        }else if(v==email_but){
            new AlertDialog.Builder(this)
                    .setTitle("인증완료!")
                    .setMessage("이메일 인증이 완료되었습니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something){
                        }
                    })
                    .show();
        }else if(v==parent_id_but){
            new AlertDialog.Builder(this)
                    .setTitle("인증완료!")
                    .setMessage("부모 인증이 완료되었습니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something){
                        }
                    })
                    .show();
        }
    }
}

