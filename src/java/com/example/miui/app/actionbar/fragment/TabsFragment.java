/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar.fragment;

import miui.app.ActionBar;
import miui.app.Fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miui.R;

public class TabsFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeRes(R.style.Theme);
    }

    @Override
    public View onInflateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.action_bar_tabs, null);
        findViews(contentView);
        return contentView;
    }

    private void findViews(View contentView) {
        contentView.findViewById(R.id.btn_add_tab).setOnClickListener(this);
        contentView.findViewById(R.id.btn_remove_all_tabs).setOnClickListener(this);
        contentView.findViewById(R.id.btn_remove_tab).setOnClickListener(this);
        contentView.findViewById(R.id.btn_toggle_tabs).setOnClickListener(this);
    }

    public void onAddTab(View v) {
        final ActionBar bar = getActionBar();
        final int tabCount = bar.getTabCount();
        final String text = "Tab " + tabCount;
        bar.addTab(bar.newTab().setText(text)
                .setTabListener(new TabListener(new TabContentFragment(text))));
    }

    public void onRemoveTab(View v) {
        final ActionBar bar = getActionBar();
        if (bar.getTabCount() > 0) {
            bar.removeTabAt(bar.getTabCount() - 1);
        }
    }

    public void onToggleTabs(View v) {
        final ActionBar bar = getActionBar();

        if (bar.getNavigationMode() == android.app.ActionBar.NAVIGATION_MODE_TABS) {
            bar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_STANDARD);
            bar.setDisplayOptions(android.app.ActionBar.DISPLAY_SHOW_TITLE, android.app.ActionBar.DISPLAY_SHOW_TITLE);
        } else {
            bar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
            bar.setDisplayOptions(0, android.app.ActionBar.DISPLAY_SHOW_TITLE);
        }
    }

    public void onRemoveAllTabs(View v) {
        getActionBar().removeAllTabs();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add_tab:
                onAddTab(v);
                break;
            case R.id.btn_toggle_tabs:
                onToggleTabs(v);
                break;
            case R.id.btn_remove_all_tabs:
                onRemoveAllTabs(v);
                break;
            case R.id.btn_remove_tab:
                onRemoveTab(v);
                break;
        }
    }

    /**
     * A TabListener receives event callbacks from the action bar as tabs are
     * deselected, selected, and reselected. A FragmentTransaction is provided
     * to each of these callbacks; if any operations are added to it, it will be
     * committed at the end of the full tab switch operation. This lets tab
     * switches be atomic without the app needing to track the interactions
     * between different tabs. NOTE: This is a very simple implementation that
     * does not retain fragment state of the non-visible tabs across activity
     * instances. Look at the FragmentTabs example for how to do a more complete
     * implementation.
     */
    private class TabListener implements android.app.ActionBar.TabListener {
        private TabContentFragment mFragment;

        public TabListener(TabContentFragment fragment) {
            mFragment = fragment;
        }

        public void onTabSelected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
        }

        public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
        }

        public void onTabReselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(getActivity(), "Reselected!", Toast.LENGTH_SHORT).show();
        }
    }

    private class TabContentFragment extends android.app.Fragment {
        private String mText;

        public TabContentFragment(String text) {
            mText = text;
        }

        public String getText() {
            return mText;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View fragView = inflater.inflate(R.layout.action_bar_tab_content, container, false);

            TextView text = (TextView) fragView.findViewById(R.id.text);
            text.setText(mText);

            return fragView;
        }

    }
}
