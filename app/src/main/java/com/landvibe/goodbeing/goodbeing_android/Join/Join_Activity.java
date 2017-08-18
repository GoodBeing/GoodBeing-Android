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
    private EditText et_id, et_pw, et_pw_confirm, et_name;
    private EditText et_birthday, et_height, et_weight;
    private EditText et_place, et_phone, et_email;
    private String sId, sPw, sPw_confirm, sName, sBirth, sHeight, sWeight, sPlace, sPhone, sEmail;
    private Intent intent;

    private Button join_but, id_but, phone_but, email_but;

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

        et_id = (EditText) findViewById(R.id.et_id);
        et_pw = (EditText) findViewById(R.id.et_pw);
        et_pw_confirm = (EditText) findViewById(R.id.et_pw_confirm);
        et_name = (EditText) findViewById(R.id.et_name);
        et_birthday = (EditText) findViewById(R.id.et_birthday);
        et_height = (EditText) findViewById(R.id.et_height);
        et_weight = (EditText) findViewById(R.id.et_weight);
        et_place = (EditText) findViewById(R.id.et_place);
        et_phone = (EditText) findViewById(R.id.et_phone);
        et_email = (EditText) findViewById(R.id.et_email);


        join_but = (Button) findViewById(R.id.join_but);
        join_but.setOnClickListener(this);

        id_but = (Button) findViewById(R.id.id_but);
        id_but.setOnClickListener(this);

        phone_but = (Button) findViewById(R.id.phone_but);
        phone_but.setOnClickListener(this);

        email_but = (Button) findViewById(R.id.email_but);
        email_but.setOnClickListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        intent = new Intent();

        if (id == R.id.nav_intro) {
            intent.setClassName(this, IntroActivity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_history) {
            intent.setClassName(this, HistoryActivity.class.getName());
            startActivity(intent);
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
        } else if (id == R.id.nav_log) {
            intent.setClassName(this, Login_Activity.class.getName());
            startActivity(intent);
        } else if (id == R.id.nav_join) {
            intent.setClassName(this, Join_Activity.class.getName());
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {

        boolean joinCheck = false;
        boolean passwordCheck = false;
        int pwCnt = 0;
        sId = et_id.getText().toString();
        sPw = et_pw.getText().toString();
        sPw_confirm = et_pw_confirm.getText().toString();
        sName = et_name.getText().toString();
        sBirth = et_birthday.getText().toString();
        sHeight = et_height.getText().toString();
        sWeight = et_weight.getText().toString();
        sPlace = et_place.getText().toString();
        sPhone = et_phone.getText().toString();
        sEmail = et_email.getText().toString();
        if (v == join_but) {
            if (sId.length() < 3 ||sId.length()>15) {
                et_id.setError("적어도 3자리 이상의 아이디를 적어주세요");
                joinCheck = false;
            } else {
                et_id.setError(null);
                joinCheck = true;
            }
            if (sPw.length() < 4 || sPw.length() > 15) {
                et_pw.setError("비밀번호는 4~15자리 영문,숫자를 사용하세요");
                joinCheck = false;
            } else {
                et_pw.setError(null);
                joinCheck = true;
            }if (sPw.length() != sPw_confirm.length()) {
                et_pw_confirm.setError("같은 비밀번호를 입력하세요");
            } else {
                et_pw_confirm.setError(null);
            }if (sPw.length() == sPw_confirm.length()) {
                for (int i = 0; i < sPw.length(); i++) {
                    if (sPw.charAt(i) == sPw_confirm.charAt(i)) {
                        pwCnt++;
                    }
                }
                if (pwCnt == sPw.length()) {
                    et_pw_confirm.setError(null);
                    joinCheck = true;
                    passwordCheck = true;
                    pwCnt=0;
                } else {
                    et_pw_confirm.setError("같은 비밀번호를 입력하세요");
                    joinCheck = false;
                    pwCnt=0;
                    passwordCheck = false;
                }
            }if (sName.length() == 0 || sName.length() > 5) {
                et_name.setError("올바른 이름을 입력하세요");
                joinCheck = false;
            } else {
                et_name.setError(null);
                joinCheck = true;
            }if(sBirth.length()==0||sBirth.length()<6){
                et_birthday.setError("올바른 생년월일6자리를 입력하세요.");
                joinCheck=false;
            }else{
                et_birthday.setError(null);
                joinCheck=true;
            }if(sHeight.length()==0){
                et_height.setError("키를 입력하세요.");
                joinCheck=false;
            }else{
                et_height.setError(null);
                joinCheck=true;
            }if(sWeight.length()==0){
                et_weight.setError("몸무게를 입력하세요.");
                joinCheck=false;
            }else{
                et_weight.setError(null);
                joinCheck=true;
            }if(sPlace.length()==0){
                et_place.setError("주소를 입력하세요.");
                joinCheck=false;
            }else{
                et_place.setError(null);
                joinCheck=true;
            }if(sPhone.length()==0||sPhone.length()<9){
                et_phone.setError("올바른 핸드폰번호를 입력하세요.");
                joinCheck=false;
            }else{
                et_phone.setError(null);
                joinCheck=true;
            }
            if (v == join_but && joinCheck == true && passwordCheck == true) {
                new AlertDialog.Builder(this)
                        .setTitle("회원가입 완료!")
                        .setMessage("회원가입이 완료되었습니다!")
                        .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dlg, int something) {
                            }
                        })
                        .show();
            }
        } else if (v == id_but) {
            new AlertDialog.Builder(this)
                    .setTitle("사용가능!")
                    .setMessage("사용가능한 아이디 입니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something) {
                        }
                    })
                    .show();
        } else if (v == phone_but) {
            new AlertDialog.Builder(this)
                    .setTitle("인증완료!")
                    .setMessage("핸드폰 인증이 완료되었습니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something) {
                        }
                    })
                    .show();
        } else if (v == email_but) {
            new AlertDialog.Builder(this)
                    .setTitle("인증완료!")
                    .setMessage("이메일 인증이 완료되었습니다!")
                    .setNeutralButton("닫기", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dlg, int something) {
                        }
                    })
                    .show();
        }
    }
}


