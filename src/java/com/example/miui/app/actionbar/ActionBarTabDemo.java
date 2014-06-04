/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.ActionBar;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;

import com.example.common.ActionBarDemoBaseActivity;
import com.example.common.DemoControlList;
import com.example.miui.CodeStyles;

public class ActionBarTabDemo extends ActionBarDemoBaseActivity{

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        DemoControlList list = getControlList();

        list.addItem("Theme", //title
                "show the action bar Tab theme",
                null, //code
                "<!--- themes.xml ---!>\n" + CodeStyles.ActionBarTabTheme,
                null);
        list.addItem("ActionBar Style", //title
                "This style remove the tab indicator",
                null, //code
                "<!---styles.xml ---!>\n" + CodeStyles.ActionBarTabActionBarStyle,
                null);
        list.addItem("ActionBar Tab Style", //title
                "This style set EVERY Tab styles, make the Tab Center!",
                null, //code
                "<!---styles.xml ---!>\n" + CodeStyles.ActionBarTabStyle,
                null);

        list.addItem("ActionBar Tab Bar Style", //title
                "This style Tab Bar style",
                null, //code
                "<!---styles.xml ---!>\n" + CodeStyles.ActionBarTabBarStyle,
                null);

        list.addItem("ActionBar Tab Text Style", //title
                "This style Tab Text style",
                null, //code
                "<!---styles.xml ---!>\n" + CodeStyles.ActionBarTabTextStyle,
                null);

        list.addItem("Add Tab", //Title
                    "Add the Tab",
                    CodeStyles.ActionBarAddTab,
                    null,
                    new Runnable() {
                        @Override
                        public void run() {
                            //CODE-BEGIN ActionBarAddTab
                            final ActionBar bar = getActionBar();
                            final int tabCount = bar.getTabCount();
                            final String text = "Tab " + tabCount;
                            bar.addTab(bar.newTab().setText(text)
                                    .setTabListener(new TabListener()));
                            //CODE-END ActionBarAddTab
                        }
                    });
        list.addItem("Remove Tab", //Title
                "Remove the Tab",
                CodeStyles.ActionBarRemoveTab,
                null,
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN ActionBarRemoveTab
                        final ActionBar bar = getActionBar();
                        if (bar.getTabCount() > 0) {
                            bar.removeTabAt(bar.getTabCount() - 1);
                        }
                        //CODE-END ActionBarRemoveTab
                    }
                });
        list.addItem("Remove All Tab", //Title
                "Remove the All Tab",
                CodeStyles.ActionBarRemoveAllTab,
                null,
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN ActionBarRemoveAllTab
                        getActionBar().removeAllTabs();
                        //CODE-END ActionBarRemoveAllTab
                    }
                });

        list.addItem("Open/Hide Tabs", //Title
                "Open/Hide Tabs",
                CodeStyles.ActionBarToggleTab,
                null,
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN ActionBarToggleTab
                        final ActionBar bar = getActionBar();
                        if (bar.getNavigationMode() == android.app.ActionBar.NAVIGATION_MODE_TABS) {
                            bar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_STANDARD);
                        } else {
                            bar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);
                        }
                        //CODE-END ActionBarToggleTab
                    }
                });

        list.addItem("ActionBar Tab Listener", //title
                null,
                CodeStyles.ActionBarTabListener, //code
                null,
                null);

        list.addItem("DISPLAY_SHOW_TITLE", //title
                "DISPLAY_SHOW_TITLE", //summary
                //code
                CodeStyles.DISPLAY_SHOW_TITLE,
                //style
                null,
                new Runnable() {
                    boolean state = false;
                    @Override
                    public void run() {
                        getActionBar().setDisplayShowTitleEnabled(state);
                        state = !state;
                    }
                });
    }

    //CODE-BEGIN ActionBarTabListener
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

        public void onTabSelected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(ActionBarTabDemo.this, "TabSelected:" + tab.getText(), Toast.LENGTH_SHORT).show();
        }

        public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(ActionBarTabDemo.this, "TabUnselected:" + tab.getText(), Toast.LENGTH_SHORT).show();
        }

        public void onTabReselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {
            Toast.makeText(ActionBarTabDemo.this, "Reselected:" + tab.getText(), Toast.LENGTH_SHORT).show();
        }
    }
    //CODE-END ActionBarTabListener

}
