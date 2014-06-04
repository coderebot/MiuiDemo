/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.widget.ScreenView;

import com.example.miui.R;

import miui.app.Activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ScreenViewDemo extends Activity
        implements View.OnClickListener, AdapterView.OnItemSelectedListener,
        CompoundButton.OnCheckedChangeListener {

    private ScreenView mScreenView;
    private Spinner mSpinnerTransitionType;
    private Button mBtnAddScreen;
    private Button mBtnRemoveScreen;
    private Spinner mSpinnerScreenWidth;
    private CheckBox mCheckBoxScrollWhole;

    private int[] mTextBgColors;
    private float mScreenWidthRatio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_screen_view_demo);

        mScreenView = (ScreenView) findViewById(R.id.screen_view);
        FrameLayout.LayoutParams seekbarParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM);
        mScreenView.setSeekBarPosition(seekbarParams);
        FrameLayout.LayoutParams slidebarParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT,
                Gravity.CENTER_HORIZONTAL | Gravity.TOP);
        mScreenView.setSlideBarPosition(slidebarParams);
        mScreenView.setScrollWholeScreen(true);
        mSpinnerTransitionType = (Spinner) findViewById(R.id.spinner_transition_type);
        mSpinnerTransitionType.setOnItemSelectedListener(this);
        mBtnAddScreen = (Button) findViewById(R.id.btn_action_add);
        mBtnAddScreen.setOnClickListener(this);
        mBtnRemoveScreen = (Button) findViewById(R.id.btn_action_remove);
        mBtnRemoveScreen.setOnClickListener(this);
        mSpinnerScreenWidth = (Spinner) findViewById(R.id.spinner_screen_width);
        mSpinnerScreenWidth.setOnItemSelectedListener(this);
        mCheckBoxScrollWhole = (CheckBox) findViewById(R.id.checkbox_scroll_whole);
        mCheckBoxScrollWhole.setOnCheckedChangeListener(this);

        Resources res = getResources();
        mTextBgColors = new int[] {
                res.getColor(android.R.color.holo_orange_light),
                res.getColor(android.R.color.holo_blue_light),
                res.getColor(android.R.color.holo_green_light)
        };
        mScreenWidthRatio = 1f;

        for (int i = 0; i < 3; ++i) {
            addScreen();
        }
    }

    private void addScreen() {
        int index = mScreenView.getScreenCount();
        TextView textView = new TextView(this);
        textView.setGravity(Gravity.CENTER);
        textView.setText("Screen_" + index);
        textView.setBackgroundColor(mTextBgColors[index % mTextBgColors.length]);

        int width = (int) (getResources().getDisplayMetrics().widthPixels * mScreenWidthRatio);
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(
                width, ViewGroup.LayoutParams.MATCH_PARENT);
        mScreenView.addView(textView, index, lp);
    }

    private void removeScreen() {
        int index = mScreenView.getScreenCount();
        if (index > 0) {
            mScreenView.removeScreen(index - 1);
        }
    }

    private void recreateScreens() {
        int count = mScreenView.getScreenCount();
        mScreenView.removeAllScreens();
        for (int i = 0; i < count; ++i) {
            addScreen();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_action_add:
                addScreen();
                break;
            case R.id.btn_action_remove:
                removeScreen();
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position,
            long id) {
        if (parent == mSpinnerTransitionType) {
            // Some transition type, such as SCREEN_TRANSITION_TYPE_STACK, will
            // change screen's properties. Before transition type changed,
            // re-create screens to avoid these changes.
            recreateScreens();
            // Change transition type must before re-create screens
            mScreenView.setScreenTransitionType(position);
        } else if (parent == mSpinnerScreenWidth) {
            mScreenWidthRatio = 1f / (position + 1);
            recreateScreens();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView == mCheckBoxScrollWhole) {
            mScreenView.setScrollWholeScreen(isChecked);
        }
    }
}
