/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.popupwindow;

import com.example.miui.R;

import java.util.ArrayList;

import miui.os.Build;

import miui.app.Activity;
import miui.widget.ArrowPopupWindow;
import miui.widget.ListPopupWindow;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ArrowPopupWindowDemo extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.arrow_popup_window);

        final Button arrowTop = (Button) findViewById(R.id.arrow_top);
        arrowTop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ListPopupWindow popup = new ListPopupWindow(ArrowPopupWindowDemo.this);
                popup.setAdapter(createAdapter());
                popup.setAnchorView(arrowTop);
                popup.setWidth(400);
                popup.setModal(true);
                popup.setListSelector(getResources().getDrawable(android.R.color.transparent));
                popup.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        popup.dismiss();
                    }
                });
                ArrowPopupWindow popupWindow = popup.getPopupWindow();
                popupWindow.setTitle(R.string.arrow_top);
                popupWindow.setPositiveButton(android.R.string.ok, null);
                popupWindow.setNegativeButton(android.R.string.cancel, null);
                popup.show();
            }
        });

        final Button arrowBottom = (Button) findViewById(R.id.arrow_bottom);
        arrowBottom.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ListPopupWindow popup = new ListPopupWindow(ArrowPopupWindowDemo.this);
                popup.setAdapter(createAdapter());
                popup.setAnchorView(arrowBottom);
                popup.setWidth(400);
                popup.setModal(true);
                popup.setListSelector(getResources().getDrawable(android.R.color.transparent));
                popup.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        popup.dismiss();
                    }
                });
                popup.show();
            }
        });

        final Button arrowLeft = (Button) findViewById(R.id.arrow_left);
        arrowLeft.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ListPopupWindow popup = new ListPopupWindow(ArrowPopupWindowDemo.this);
                popup.setAdapter(createAdapter());
                popup.setAnchorView(arrowLeft);
                popup.setWidth(400);
                popup.setModal(true);
                popup.setListSelector(getResources().getDrawable(android.R.color.transparent));
                popup.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        popup.dismiss();
                    }
                });
                popup.show();
            }
        });

        final Button arrowRight = (Button) findViewById(R.id.arrow_right);
        arrowRight.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ListPopupWindow popup = new ListPopupWindow(ArrowPopupWindowDemo.this);
                popup.setAdapter(createAdapter());
                popup.setAnchorView(arrowRight);
                popup.setWidth(400);
                popup.setModal(true);
                popup.setListSelector(getResources().getDrawable(android.R.color.transparent));
                popup.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        popup.dismiss();
                    }
                });
                popup.show();
            }
        });
    }

    private ArrayAdapter<String> createAdapter() {
        ArrayList<String> demoList = new ArrayList<String>();
        final int MAX_LINE = 10;
        for (int i = 0; i < MAX_LINE; i++) {
            demoList.add(String.valueOf(i));
        }
        return new ArrayAdapter<String>(this,
                miui.R.layout.simple_arrow_popup_item, demoList);
    }
}
