/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.preference;

import miui.preference.AnimatedPreference;
import miui.preference.ButtonPreference;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import miui.preference.PreferenceActivity;

import android.os.Bundle;

import com.example.miui.R;

public class PreferenceActivityDemo extends PreferenceActivity implements OnPreferenceChangeListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
        ButtonPreference buttonPreference = (ButtonPreference) getPreferenceScreen().findPreference("button_preference");
        buttonPreference.setText(R.string.button_preferences);

        AnimatedPreference animatedPreference = (AnimatedPreference) findPreference("animated_preference");
        animatedPreference.setOnPreferenceChangeListener(this);
        animatedPreference.setChecked(false);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        if ("animated_preference".equals(preference.getKey())) {
            AnimatedPreference animatedPreference = (AnimatedPreference)preference;
            animatedPreference.setAnimating((Boolean)newValue);
        }
        return true;
    }
}
