package com.landvibe.goodbeing.goodbeing_android.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.landvibe.goodbeing.goodbeing_android.Main.MainActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Signup.SignupActivity;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.rey.material.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements Validator.ValidationListener {

    @BindView(R.id.login_id)
    @NotEmpty
    EditText loginId;

    @BindView(R.id.login_password)
    @NotEmpty
    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_SYMBOLS)
    @Length(max = 12)
    EditText loginPassword;

    @BindView(R.id.btn_login)
    com.rey.material.widget.Button loginBtn;

    @BindView(R.id.btn_reset_password)
    Button resetPasswordBtn;

    @BindView(R.id.btn_signup)
    Button signupBtn;

    Intent intent;

    Validator validator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.btn_login)
    void loginBtnEvent()
    {
        validator.validate();
    }

    @OnClick(R.id.btn_reset_password)
    void resetPasswordBtnEvent()
    {
        intent = new Intent();
        intent.setClassName(this , ResetPasswordActivity.class.getName());
        startActivity(intent);
    }

    @OnClick(R.id.btn_signup)
    void signupBtnEvent() {
        intent = new Intent();
        intent.setClassName(this , SignupActivity.class.getName());
        startActivity(intent);
    }


    @Override
    public void onValidationSucceeded() {
        intent = new Intent();
        intent.setClassName(this , MainActivity.class.getName());
        startActivity(intent);

    }

    @Override

    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }

        }
    }




}
