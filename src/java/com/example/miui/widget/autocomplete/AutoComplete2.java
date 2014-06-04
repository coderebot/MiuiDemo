/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.autocomplete;

import com.example.miui.R;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import miui.app.Activity;

public class AutoComplete2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_2);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                miui.R.layout.simple_arrow_popup_item,
                AutoComplete1.COUNTRIES);
        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.edit);
        textView.setAdapter(adapter);
    }
}
