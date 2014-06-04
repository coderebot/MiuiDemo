package com.example.miui.widget.adaptivedrawable;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;

import com.example.miui.R;

public class CostumPreference extends Preference {

    public CostumPreference(Context context) {
        super(context);
    }

    public CostumPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CostumPreference(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        view.setBackgroundResource(miui.R.drawable.preference_item_bg);
    }

}
