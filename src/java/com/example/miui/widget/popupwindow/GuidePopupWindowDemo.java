/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.popupwindow;

import com.example.miui.R;

import java.util.ArrayList;

import miui.os.Build;

import miui.app.Activity;
import miui.widget.GuidePopupWindow;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class GuidePopupWindowDemo extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.arrow_popup_window);

        final Button arrowTop = (Button) findViewById(R.id.arrow_top);
        arrowTop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GuidePopupWindow TopWindow = new GuidePopupWindow(GuidePopupWindowDemo.this);
                TopWindow.setArrowMode(GuidePopupWindow.ARROW_TOP_MODE);
                TopWindow.setGuideText(R.string.arrow_top);
                TopWindow.show(v, 0, 0, true);
            }
        });

        final Button arrowBottom = (Button) findViewById(R.id.arrow_bottom);
        arrowBottom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GuidePopupWindow bottomWindow = new GuidePopupWindow(GuidePopupWindowDemo.this);
                bottomWindow.setArrowMode(GuidePopupWindow.ARROW_BOTTOM_MODE);
                bottomWindow.setGuideText(R.string.arrow_bottom);
                bottomWindow.show(v, 0, 0, true);
            }
        });

        final Button arrowLeft = (Button) findViewById(R.id.arrow_left);
        arrowLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GuidePopupWindow leftWindow = new GuidePopupWindow(GuidePopupWindowDemo.this);
                leftWindow.setArrowMode(GuidePopupWindow.ARROW_LEFT_MODE);
                leftWindow.setGuideText(R.string.arrow_left);
                leftWindow.show(v, 0, 0, true);
            }
        });

        final Button arrowRight = (Button) findViewById(R.id.arrow_right);
        arrowRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                GuidePopupWindow rightWindow = new GuidePopupWindow(GuidePopupWindowDemo.this);
                rightWindow.setArrowMode(GuidePopupWindow.ARROW_RIGHT_MODE);
                rightWindow.setGuideText(R.string.arrow_right);
                rightWindow.show(v, 0, 0, true);
            }
        });
    }
}
