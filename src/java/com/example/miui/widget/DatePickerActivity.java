/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.app.Activity;
import miui.date.Calendar;
import miui.date.DateUtils;
import miui.widget.DatePicker;

import android.os.Bundle;
import android.widget.TextView;

import com.example.miui.R;

public class DatePickerActivity extends Activity {
    private DatePicker mDatePicker;
    private DatePicker mDatePicker1;
    private TextView mTextView;
    private Calendar mCalendar = new Calendar();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datepicker_activity);

        mTextView = (TextView) findViewById(R.id.text_view);
        mDatePicker = (DatePicker) findViewById(R.id.date_picker);
        mDatePicker1 = (DatePicker) findViewById(R.id.date_picker1);
        mDatePicker1.showDayPicker(false);
        mDatePicker1.showYearPicker(true);

        mDatePicker.init(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth, boolean isLunar) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, monthOfYear);
                mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateTime();
            }
        });

        mDatePicker1.init(mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                mCalendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth, boolean isLunar) {
                mCalendar.set(Calendar.YEAR, year);
                mCalendar.set(Calendar.MONTH, monthOfYear);
                mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateTime();
            }
        });
        updateTime();
    }

    private void updateTime() {
        mTextView.setText(formatTime(mCalendar.getTimeInMillis()));
    }

    private String formatTime(long m) {
        return DateUtils.formatDateTime(m, DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_BRIEF_TIME);
    }
}
