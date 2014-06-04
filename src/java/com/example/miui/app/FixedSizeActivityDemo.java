/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app;

import miui.app.Activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.miui.CodeStyles;

public class FixedSizeActivityDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        textView.setText("<!-- AndroidManifest.xml -->\n" + CodeStyles.FixedSizeActivityDemoAndroidManifest);
        setContentView(textView);
    }
}
