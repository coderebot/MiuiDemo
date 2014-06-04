/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.app.Activity;
import miui.date.Calendar;
import miui.date.DateUtils;
import miui.widget.DatePicker;
import miui.widget.DatePicker.OnDateChangedListener;
import miui.widget.DateTimePicker;
import miui.widget.DateTimePicker.OnDateTimeChangedListener;
import miui.widget.TimePicker;
import miui.widget.TimePicker.OnTimeChangedListener;

import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TextView;

import com.example.miui.R;

public class DateTimePickerActivity extends Activity {
    private TimePicker mTimePicker;
    private DateTimePicker mDateTimePicker;
    private TextView mTextView;
    private Calendar mCalendar = new Calendar();

    private static final long MS_IN_HOUR = 3600l * 1000;
    private static final long MS_IN_DAY = 24l * MS_IN_HOUR;
    private static final long MS_IN_YEAR = 365l * MS_IN_DAY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_time_picker_activity);

        mTextView = (TextView) findViewById(R.id.text_view);
        mTimePicker = (TimePicker) findViewById(R.id.time_picker);
        mDateTimePicker = (DateTimePicker) findViewById(R.id.datetime_picker);
        Calendar c = new Calendar();

        mTimePicker.setIs24HourView(DateFormat.is24HourFormat(this));
        mTimePicker.setOnTimeChangedListener(new OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                Calendar c = mCalendar;
                c.set(Calendar.HOUR, hourOfDay);
                c.set(Calendar.MINUTE, minute);
                updateTime();
            }
        });
        mDateTimePicker.setMinuteInterval(3);
        Calendar t = new Calendar();
        mDateTimePicker.setMinDateTime(t.getTimeInMillis());
        t.add(Calendar.DAY_OF_YEAR, +10);
        mDateTimePicker.setMaxDateTime(t.getTimeInMillis());
        mDateTimePicker.setOnTimeChangedListener(new OnDateTimeChangedListener() {
            @Override
            public void onDateTimeChanged(DateTimePicker view, long timeInMillis) {
                mCalendar.setTimeInMillis(timeInMillis);
                updateTime();
            }
        });
        c = new Calendar();
        c.add(Calendar.MINUTE, 500);
        c.add(Calendar.SECOND, 100);
        mDateTimePicker.update(c.getTimeInMillis());
        mCalendar.setTimeInMillis(mDateTimePicker.getTimeInMillis());
        updateTime();
    }

    private void updateTime() {
        mTextView.setText(formatTime(mCalendar.getTimeInMillis()));
    }

    private String formatTime(long m) {
        return DateUtils.formatDateTime(m, DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_BRIEF_TIME);
    }
}
