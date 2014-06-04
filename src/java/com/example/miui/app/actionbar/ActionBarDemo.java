/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.Activity;
import miui.widget.NavigationLayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;

import com.example.miui.app.actionbar.fragment.DisplayOptionsFragment;
import com.example.miui.app.actionbar.fragment.ImmersionMenuFragment;
import com.example.miui.app.actionbar.fragment.MenuFragment;
import com.example.miui.app.actionbar.fragment.ListFragmentDemo;
import com.example.miui.app.actionbar.fragment.MechanicsFragment;
import com.example.miui.app.actionbar.fragment.SearchFragment;
import com.example.miui.app.actionbar.fragment.TabsFragment;
import com.example.miui.app.actionbar.fragment.UsageFragment;
import com.example.miui.R;

public class ActionBarDemo extends Activity {

    private static final String KEY_CONTENT = "content";

    private String mCurrentContent;

    private NavigationLayout mNavigationLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mNavigationLayout = (NavigationLayout)findViewById(R.id.navigation_layout);
        mNavigationLayout.openNavigationDrawer(false);

        if (savedInstanceState != null) {
            mCurrentContent = savedInstanceState.getString(KEY_CONTENT);
        } else {
            mCurrentContent = getString(R.string.actionbar_mechanics);
            getFragmentManager().beginTransaction().replace(miui.R.id.navigation,
                    getFragment(MenuFragment.class)).commit();
        }
        changeContent(mCurrentContent, false);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_CONTENT, mCurrentContent);
    }

    private Fragment getFragment(Class fragmentClass) {
        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag(fragmentClass.getSimpleName());
        if (fragment == null) {
            try {
                fragment = (Fragment) fragmentClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fragment;
    }

    public void changeContent(String name, boolean startActivity) {
        if (startActivity) {
            if (name.equals(getString(R.string.actionbar_mechanics))) {
                startActivity(new Intent(this, ActionBarMechanics.class));
            } else if (name.equals(getString(R.string.actionbar_tabs))) {
                startActivity(new Intent(this, ActionBarTabs.class));
            } else if (name.equals(getString(R.string.actionbar_display_options))) {
                startActivity(new Intent(this, ActionBarDisplayOptions.class));
            } else if (name.equals(getString(R.string.actionbar_usage))) {
                startActivity(new Intent(this, ActionBarUsage.class));
            } else if (name.equals(getString(R.string.actionbar_searchview))){
                startActivity(new Intent(this, SearchDemo.class));
            } else if (name.equals(getString(R.string.actionbar_immersionmenu))) {
                startActivity(new Intent(this, ImmersionMenu.class));
            }
            return;
        }

        Fragment fragment = null;
        if (name.equals(getString(R.string.actionbar_mechanics))) {
            fragment = getFragment(MechanicsFragment.class);
        } else if (name.equals(getString(R.string.actionbar_tabs))) {
            fragment = getFragment(TabsFragment.class);
        } else if (name.equals(getString(R.string.actionbar_display_options))) {
            fragment = getFragment(DisplayOptionsFragment.class);
        } else if (name.equals(getString(R.string.actionbar_usage))) {
            fragment = getFragment(UsageFragment.class);
        } else if (name.equals(getString(R.string.actionbar_list_fragment))) {
            fragment = getFragment(ListFragmentDemo.class);
        } else if (name
                .equals(getString(R.string.actionbar_searchview))) {
            fragment = getFragment(SearchFragment.class);
        } else if (name.equals(getString(R.string.actionbar_immersionmenu))) {
            fragment = getFragment(ImmersionMenuFragment.class);
        }
        changeContentFragment(fragment, fragment.getClass().getSimpleName());
        mCurrentContent = name;
    }

    private void changeContentFragment(Fragment fragment, String tag) {
        if (fragment == null) {
            return;
        }
        getFragmentManager().beginTransaction().replace(miui.R.id.content, fragment, tag).commit();
    }
}
