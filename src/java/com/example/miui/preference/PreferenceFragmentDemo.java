/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.preference;

import miui.app.Activity;
import miui.preference.AnimatedPreference;
import miui.preference.ButtonPreference;

import android.preference.Preference;
import android.preference.Preference.OnPreferenceChangeListener;
import miui.preference.PreferenceFragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.miui.R;

public class PreferenceFragmentDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FragmentManager fm = getFragmentManager();
        Fragment fg = fm.findFragmentByTag(SimplePreferenceFragment.TAG);
        if (fg == null) {
            fg = SimplePreferenceFragment.initialize();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(android.R.id.content, fg, SimplePreferenceFragment.TAG);
            ft.commit();
        }
    }

    public static class SimplePreferenceFragment extends PreferenceFragment implements OnPreferenceChangeListener {

        private static String TAG = SimplePreferenceFragment.class.getSimpleName();

        public static SimplePreferenceFragment initialize() {
            return new SimplePreferenceFragment();
        }

        public SimplePreferenceFragment() {
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setThemeRes(miui.R.style.Theme_Light);
            addPreferencesFromResource(R.xml.preferences);
            ButtonPreference buttonPreference = (ButtonPreference) findPreference("button_preference");
            buttonPreference.setText(R.string.button_preferences);

            AnimatedPreference animatedPreference = (AnimatedPreference) findPreference("animated_preference");
            animatedPreference.setOnPreferenceChangeListener(this);
            animatedPreference.setChecked(false);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.actions, menu);
            return true;
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

}
