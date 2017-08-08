package com.landvibe.goodbeing.goodbeing_android.Signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.landvibe.goodbeing.goodbeing_android.Login.LoginActivity;
import com.landvibe.goodbeing.goodbeing_android.R;
import com.landvibe.goodbeing.goodbeing_android.Signup.Terms.TermsOfServiceActivity;
import com.landvibe.goodbeing.goodbeing_android.Signup.Terms.TermsOfUseActivity;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Checked;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.rey.material.widget.Button;
import com.rey.material.widget.ImageButton;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 고승빈 on 2017-08-08.
 */
public class SignupActivity extends AppCompatActivity implements Validator.ValidationListener {


    @BindView(R.id.signup_id)
    @NotEmpty
    EditText signupId;

    @BindView(R.id.signup_password)
    @NotEmpty
    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_SYMBOLS)
    @Length(max = 12)
    EditText signupPassword;

    @BindView(R.id.signup_address)
    @NotEmpty
    EditText signupAddress;

    @BindView(R.id.signup_age)
    @NotEmpty
    EditText signup_age;

    @BindView(R.id.signup_name)
    @NotEmpty
    EditText signupName;

    @BindView(R.id.signup_gender)
    @Checked(message = "You must agree to the gender.")
    RadioGroup signupGender;

    @BindView(R.id.signup_man)
    RadioButton signupMan;

    @BindView(R.id.signup_woman)
    RadioButton signupWoman;

    @BindView(R.id.signup_terms_of_use)
    @Checked(message = "You must agree to the terms of use.")
    CheckBox signupTermsOfUse;

    @BindView(R.id.signup_terms_of_service)
    @Checked(message = "You must agree to the terms of services.")
    CheckBox signupTermsOfService;

    @BindView(R.id.signup_submit_button)
    Button signupSubmit;

    @BindView(R.id.signup_terms_of_use_view)
    ImageButton signupTermsOfUseView;

    @BindView(R.id.signup_terms_of_service_view)
    ImageButton signupTermsOfServiceView;

    Intent intent;

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.signup_submit_button)
    void signupSubmitEvent() {
        validator.validate();
    }

    @OnClick(R.id.signup_terms_of_use_view)
    void signupTermsOfUseViewEvent() {
        intent = new Intent();
        intent.setClassName(this, TermsOfUseActivity.class.getName());
        startActivity(intent);
    }

    @OnClick(R.id.signup_terms_of_service_view)
    void signupTermsOfServiceViewEvent() {
        intent = new Intent();
        intent.setClassName(this, TermsOfServiceActivity.class.getName());
        startActivity(intent);
    }


    @Override
    public void onValidationSucceeded() {
        intent = new Intent();
        intent.setClassName(this, LoginActivity.class.getName());
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
