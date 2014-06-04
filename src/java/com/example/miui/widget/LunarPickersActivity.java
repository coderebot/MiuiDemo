/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.app.Activity;
import miui.date.Calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.miui.R;

public class LunarPickersActivity extends Activity implements View.OnClickListener {
    private EditText mLunarYear;
    private EditText mLunarMonth;
    private EditText mLunarDay;
    private EditText mLunarLeap;
    private Button mAddYear;
    private Button mAddMonth;
    private Button mAddDay;
    private Button mAddLeap;
    private Button mRedYear;
    private Button mRedMonth;
    private Button mRedDay;
    private TextView mTextYear;
    private TextView mTextMonth;
    private TextView mTextDay;
    private TextView mTextLeap;
    private Calendar mCalendar = new Calendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lunarpickers_activity);
        mLunarYear = (EditText) findViewById(R.id.lunar_year);
        mLunarMonth = (EditText) findViewById(R.id.lunar_month);
        mLunarDay = (EditText) findViewById(R.id.lunar_day);
        mLunarLeap = (EditText) findViewById(R.id.lunar_leap);
        mAddYear = (Button) findViewById(R.id.add_year);
        mAddMonth = (Button) findViewById(R.id.add_month);
        mAddDay = (Button) findViewById(R.id.add_day);
        mAddLeap = (Button) findViewById(R.id.add_leap);
        mRedYear = (Button) findViewById(R.id.red_year);
        mRedMonth = (Button) findViewById(R.id.red_month);
        mRedDay = (Button) findViewById(R.id.red_day);
        mTextYear = (TextView) findViewById(R.id.text_year);
        mTextMonth = (TextView) findViewById(R.id.text_month);
        mTextDay = (TextView) findViewById(R.id.text_day);
        mTextLeap = (TextView) findViewById(R.id.text_leap);
        mTextYear.setText("年");
        mTextMonth.setText("月");
        mTextDay.setText("日");
        mTextLeap.setText("是否闰月");
        mAddYear.setText("+");
        mAddMonth.setText("+");
        mAddDay.setText("+");
        mRedYear.setText("-");
        mRedMonth.setText("-");
        mRedDay.setText("-");
        mAddLeap.setText("change");
        mAddYear.setOnClickListener(this);
        mAddMonth.setOnClickListener(this);
        mAddDay.setOnClickListener(this);
        mAddLeap.setOnClickListener(this);
        mRedYear.setOnClickListener(this);
        mRedMonth.setOnClickListener(this);
        mRedDay.setOnClickListener(this);
        mLunarYear.setText("" + mCalendar.get(Calendar.CHINESE_YEAR));
        mLunarMonth.setText("" + mCalendar.get(Calendar.CHINESE_MONTH));
        mLunarDay.setText("" + mCalendar.get(Calendar.DAY_OF_CHINESE_MONTH));
        mLunarLeap.setText(mCalendar.isChineseLeapMonth() ? "1" : "0");
    }

    @Override
    public void onClick(View v) {
        int year = Integer.parseInt(mLunarYear.getText().toString());
        int month = Integer.parseInt(mLunarMonth.getText().toString());
        int day = Integer.parseInt(mLunarDay.getText().toString());
        boolean leap = Integer.parseInt(mLunarLeap.getText().toString()) != 0;
        mCalendar.setChineseTime(year, month, day, leap, 0, 0, 0, 0);
        int field = -1;
        int value = 1;
        switch (v.getId()) {
            case R.id.red_day:
                value = -1;
            case R.id.add_day:
                field = Calendar.DAY_OF_CHINESE_MONTH;
                break;
            case R.id.red_month:
                value = -1;
            case R.id.add_month:
                field = Calendar.CHINESE_MONTH;
                break;
            case R.id.red_year:
                value = -1;
            case R.id.add_year:
                field = Calendar.CHINESE_YEAR;
                break;
            case R.id.add_leap:
                leap = !leap;
                mCalendar.setChineseTime(year, month, day, leap, 0, 0, 0, 0);
                break;
        }
        if (field != -1) {
            mCalendar.add(field, value);
        }
        mLunarYear.setText("" + mCalendar.get(Calendar.CHINESE_YEAR));
        mLunarMonth.setText("" + mCalendar.get(Calendar.CHINESE_MONTH));
        mLunarDay.setText("" + mCalendar.get(Calendar.DAY_OF_CHINESE_MONTH));
        mLunarLeap.setText(mCalendar.isChineseLeapMonth() ? "1" : "0");
    }
}
