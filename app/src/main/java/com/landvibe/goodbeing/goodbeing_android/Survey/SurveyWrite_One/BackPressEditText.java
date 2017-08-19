package com.landvibe.goodbeing.goodbeing_android.Survey.SurveyWrite_One;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;

/**
 * Created by jik on 2017-08-16.
 */

public class BackPressEditText extends android.support.v7.widget.AppCompatEditText {

    private OnBackPressListener _listener;

    public BackPressEditText(Context context) {
        super(context);
    }

    public BackPressEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BackPressEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && _listener != null)
        {
            _listener.onBackPress();
        }
          return super.onKeyPreIme(keyCode, event);
    }

    public void setOnFocusChangeListener(OnBackPressListener onBackPressListener) {

        _listener = onBackPressListener;
    }

    public interface OnBackPressListener
    {
        public void onBackPress();
    }


}
