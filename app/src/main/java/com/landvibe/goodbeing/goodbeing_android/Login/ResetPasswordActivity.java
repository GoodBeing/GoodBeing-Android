package com.landvibe.goodbeing.goodbeing_android.Login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.landvibe.goodbeing.goodbeing_android.R;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Length;
import com.mobsandgeeks.saripaar.annotation.Max;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.rey.material.widget.Button;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 고승빈 on 2017-08-08.
 */
public class ResetPasswordActivity extends AppCompatActivity implements Validator.ValidationListener {


    @BindView(R.id.reset_password_id)
    @NotEmpty
    EditText resetPasswordId;

    @BindView(R.id.btn_reset_password)
    @Password(min = 6, scheme = Password.Scheme.ALPHA_NUMERIC_SYMBOLS)
    @Length(max = 12)
    Button resetPasswordSubmit;

    @BindView(R.id.btn_back)
    Button back;

    Intent intent;

    Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        ButterKnife.bind(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @OnClick(R.id.btn_reset_password)
    void resetResetPasswordSubmit()
    {
        validator.validate();
    }

    @OnClick(R.id.btn_back)
    void back()
    {
        onBackPressed();
    }

    @Override
    public void onValidationSucceeded() {
        intent = new Intent();
        intent.setClassName(this , LoginActivity.class.getName());
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
