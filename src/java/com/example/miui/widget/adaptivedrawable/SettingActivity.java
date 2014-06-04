package com.example.miui.widget.adaptivedrawable;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.miui.R;

public class SettingActivity extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings);
    }

}
