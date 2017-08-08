package com.landvibe.goodbeing.goodbeing_android.Signup.Terms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.landvibe.goodbeing.goodbeing_android.R;

import butterknife.ButterKnife;

/**
 * Created by 고승빈 on 2017-08-08.
 */
public class TermsOfServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termsofservice);

        ButterKnife.bind(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
