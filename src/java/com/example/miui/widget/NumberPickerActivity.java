/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.app.Activity;
import android.os.Bundle;
import miui.widget.NumberPicker;

import com.example.miui.R;

public class NumberPickerActivity extends Activity {
    private NumberPicker mNumberPicker1;
    private NumberPicker mNumberPicker2;
    private NumberPicker mNumberPicker3;
    private NumberPicker mNumberPicker4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numberpicker_activity);
        mNumberPicker1 = (NumberPicker) findViewById(R.id.num1);
        mNumberPicker2 = (NumberPicker) findViewById(R.id.num2);
        mNumberPicker3 = (NumberPicker) findViewById(R.id.num3);
        mNumberPicker4 = (NumberPicker) findViewById(R.id.num4);
        mNumberPicker1.setMinValue(0);
        mNumberPicker2.setMinValue(0);
        mNumberPicker3.setMinValue(0);
        mNumberPicker4.setMinValue(0);
        mNumberPicker1.setMaxValue(100);
        mNumberPicker2.setMaxValue(100);
        mNumberPicker3.setMaxValue(100);
        mNumberPicker4.setMaxValue(100);
    }
}
