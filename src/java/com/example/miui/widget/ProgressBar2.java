/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */
package com.example.miui.widget;

import miui.app.Activity;

import com.example.miui.R;

import android.os.Bundle;
import android.view.Window;


/**
 * Demonstrates the use of indeterminate progress bars as widgets and in the
 * window's title bar. The widgets show the 3 different sizes of circular
 * progress bars that can be used.
 */
public class ProgressBar2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.progressbar_2);
    }
}
