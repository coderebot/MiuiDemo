/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.ActionBar;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.example.common.ActionBarDemoBaseActivity;
import com.example.common.DemoControlList;

import com.example.miui.CodeStyles;
import com.example.miui.R;

public class ActionBarTitleDemo extends ActionBarDemoBaseActivity {

    private View mCustomView;

    class DisplayOptionsRunnable implements Runnable {
        boolean state = false;
        @Override
        public void run() {
            call(state);
            state = !state;
        }
        protected void call(boolean b) {}
    }

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        mCustomView = getLayoutInflater().inflate(R.layout.action_bar_display_options_custom, null);
        // Configure several action bar elements that will be toggled by display
        // options.
        final ActionBar bar = getActionBar();
        bar.setCustomView(mCustomView, new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        DemoControlList list = getControlList();

        list.addItem("Theme", //title
                "show the action bar theme",
                null, //code
                "<!--- themes.xml ---!>\n" + CodeStyles.ActionBarTitleTheme
                        + "<!-- style.xml --!>\n"
                        + CodeStyles.ActionBarTitleStyle,
                null);
        list.addItem("Set Status Bar Style",
                    "miui:windowTranslucentStatus(private) = opaque|transparentLight|transparentDark",
                    null,
                    "<!-- in themes.xml ActionBar.Title -->\n"
                    + CodeStyles.ActionBarTranslucentStatus,
                    null);

        list.addItem("DISPLAY_HOME_AS_UP", //title
                    "DISPLAY_HOME_AS_UP", //summary
                    CodeStyles.DISPLAY_HOME_AS_UP,
                    "<!-- theme.xml in ActionBar.Title -->\n"
                    + CodeStyles.ActionBarHomeAsUp, //style
                    new DisplayOptionsRunnable() {
                        @Override
                        public void call(boolean b) {
                            //CODE-BEGIN DISPLAY_HOME_AS_UP
                            getActionBar().setDisplayHomeAsUpEnabled(b);
                            //actionBar.setDisplayOptions(b ? ActionBar.DISPLAY_HOME_AS_UP: 0, ActionBar.DISPLAY_HOME_AS_UP);
                            //CODE-END DISPLAY_HOME_AS_UP
                        }
                    });
        list.addItem("DISPLAY_SHOW_HOME", //title
                     "DISPLAY_SHOW_HOME", //summary
                     CodeStyles.DISPLAY_SHOW_HOME,
                     null, //style
                     new DisplayOptionsRunnable() {
                        @Override
                        public void call(boolean b) {
                            //CODE-BEGIN DISPLAY_SHOW_HOME
                            getActionBar().setDisplayShowHomeEnabled(b);
                            //getActionBar().setDisplayOptions(b ? ActionBar.DISPLAY_SHOW_HOME: 0, ActionBar.DISPLAY_SHOW_HOME);
                            //CODE-END DISPLAY_SHOW_HOME
                        }
                    });
        list.addItem("DISPLAY_USE_LOGO", //title
                "DISPLAY_USE_LOGO", //summary
                CodeStyles.DISPLAY_USE_LOGO,
                null, //style
                new DisplayOptionsRunnable() {
                    @Override
                    public void call(boolean b) {
                        //CODE-BEGIN DISPLAY_USE_LOGO
                        getActionBar().setDisplayUseLogoEnabled(b);
                        //getActionBar().setDisplayOptions(b ? ActionBar.DISPLAY_USE_LOGO: 0, ActionBar.DISPLAY_USE_LOGO);
                        getActionBar().setLogo(R.drawable.ic_logo);
                        //CODE-END DISPLAY_USE_LOGO
                    }
                });
        list.addItem("DISPLAY_SHOW_TITLE", //title
                "Content Auto Fit System Window", //summary
                //code
                CodeStyles.DISPLAY_SHOW_TITLE,
                //style
                "<!-- in themes.xml -->\n" +
                        CodeStyles.ActionBarContentAutoFitSystemWindow +
                        "<!-- in styles.xml -->\n" +
                        CodeStyles.ActionBarTitleTextStyle,
                new DisplayOptionsRunnable() {
                    @Override
                    public void call(boolean b) {
                        //CODE-BEGIN DISPLAY_SHOW_TITLE
                        getActionBar().setDisplayShowTitleEnabled(b);
                        //getActionBar().setDisplayOptions(b ? ActionBar.DISPLAY_SHOW_TITLE: 0, ActionBar.DISPLAY_SHOW_TITLE);
                        //CODE-END DISPLAY_SHOW_TITLE
                    }
                });
        list.addItem("Set Sub Title", //title
                    null,
                    CodeStyles.SetSubTitle,
                    CodeStyles.ActionBarSubTitleTextStyle, //style
                    new DisplayOptionsRunnable() {
                        @Override
                        public void call(boolean setsubtitle) {
                            //CODE-BEGIN SetSubTitle
                            if (setsubtitle) {
                                getActionBar().setSubtitle(null);
                            } else {
                                getActionBar().setSubtitle("Sub Title");
                            }
                            //CODE-END SetSubTitle
                        }
                    });
        list.addItem("Set Custom View",
                    "Custom View Auto Fit the System Window",
                    CodeStyles.SetCustomView,
                    "<!-- in themes.xml -->\n" + CodeStyles.ActionBarCoustomViewAutoFitSystemWindow,
                    new DisplayOptionsRunnable() {
                        @Override
                        public void call(boolean b) {
                            //CODE-BEGIN SetCustomView
                            getActionBar().setDisplayShowCustomEnabled(b);
                            //getActionBar().setDisplayOptions(b ? DISPLAY_SHOW_CUSTOM: 0, DISPLAY_SHOW_CUSTOM);
                            //CODE-END SetCustomView
                        }
                    });

    }

    class DoSetDisplayOptions implements Runnable {
        int flags;
        @Override
        public void run() {
            getActionBar().setDisplayOptions(getActionBar().getDisplayOptions() ^ flags, flags);
            if (flags == ActionBar.DISPLAY_USE_LOGO) {
                getActionBar().setLogo(R.drawable.ic_logo);
            }
        }
        DoSetDisplayOptions(int flags) {
            this.flags = flags;
        }
    }

    private Runnable createRunnable(int flags) {
        return new DoSetDisplayOptions(flags);
    }



}
