/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.app.Activity;
import miui.widget.VerticalSeekBar;

import com.example.miui.R;

import android.os.Bundle;

/**
 * Demonstrates the use of {@link VerticalSeekBar}
 */
public class SeekBar2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seekbar_2);
        VerticalSeekBar seekBar = (VerticalSeekBar) findViewById(R.id.seek);
        seekBar.setMax(100);
        seekBar.setProgress(50);
    }

}
