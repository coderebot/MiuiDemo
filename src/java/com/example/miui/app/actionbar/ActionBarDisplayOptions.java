/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.ActionBar;
import miui.app.Activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.example.miui.R;

/**
 * This demo shows how various action bar display option flags can be combined
 * and their effects.
 */
public class ActionBarDisplayOptions extends Activity implements View.OnClickListener,
        ActionBar.TabListener {
    private View mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar_display_options);

        findViewById(R.id.toggle_home_as_up).setOnClickListener(this);
        findViewById(R.id.toggle_show_home).setOnClickListener(this);
        findViewById(R.id.toggle_use_logo).setOnClickListener(this);
        findViewById(R.id.toggle_show_title).setOnClickListener(this);
        findViewById(R.id.toggle_show_custom).setOnClickListener(this);
        findViewById(R.id.toggle_navigation).setOnClickListener(this);
        findViewById(R.id.cycle_custom_gravity).setOnClickListener(this);

        mCustomView = getLayoutInflater().inflate(R.layout.action_bar_display_options_custom, null);
        // Configure several action bar elements that will be toggled by display
        // options.
        final ActionBar bar = getActionBar();
        bar.setCustomView(mCustomView, new ActionBar.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT));

        bar.addTab(bar.newTab().setText("Tab 1").setTabListener(this));
        bar.addTab(bar.newTab().setText("Tab 2").setTabListener(this));
        bar.addTab(bar.newTab().setText("Tab 3").setTabListener(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.display_options_actions, menu);
        return true;
    }

    public void onClick(View v) {
        final ActionBar bar = getActionBar();
        int flags = 0;
        switch (v.getId()) {
            case R.id.toggle_home_as_up:
                flags = ActionBar.DISPLAY_HOME_AS_UP;
                break;
            case R.id.toggle_show_home:
                flags = ActionBar.DISPLAY_SHOW_HOME;
                break;
            case R.id.toggle_use_logo:
                flags = ActionBar.DISPLAY_USE_LOGO;
                break;
            case R.id.toggle_show_title:
                flags = ActionBar.DISPLAY_SHOW_TITLE;
                break;
            case R.id.toggle_show_custom:
                flags = ActionBar.DISPLAY_SHOW_CUSTOM;
                break;

            case R.id.toggle_navigation:
                bar.setNavigationMode(bar.getNavigationMode() == ActionBar.NAVIGATION_MODE_STANDARD ? ActionBar.NAVIGATION_MODE_TABS
                        : ActionBar.NAVIGATION_MODE_STANDARD);
                return;
            case R.id.cycle_custom_gravity:
                ActionBar.LayoutParams lp = (ActionBar.LayoutParams) mCustomView.getLayoutParams();
                int newGravity = 0;
                switch (lp.gravity & Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
                    case Gravity.START:
                        newGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case Gravity.CENTER_HORIZONTAL:
                        newGravity = Gravity.END;
                        break;
                    case Gravity.END:
                        newGravity = Gravity.START;
                        break;
                }
                lp.gravity = lp.gravity & ~Gravity.RELATIVE_HORIZONTAL_GRAVITY_MASK | newGravity;
                bar.setCustomView(mCustomView, lp);
                return;
        }

        int change = bar.getDisplayOptions() ^ flags;
        bar.setDisplayOptions(change, flags);
    }

    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
    }

    public static class TitleStyle extends ActionBarDisplayOptions {}
}
