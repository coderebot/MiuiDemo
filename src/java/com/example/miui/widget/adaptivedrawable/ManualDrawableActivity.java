/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.adaptivedrawable;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

import com.example.miui.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ManualDrawableActivity extends Activity implements OnClickListener, OnItemClickListener {
    private static final String ITEM_TEXT = "item_text";

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;
    private Button mButton5;
    private Button mButton6;
    private Button mButton7;
    private Button mButton8;
    private Button mButton9;

    private final List<HashMap<String, String>> mSimpleAdapterData = new ArrayList<HashMap<String, String>>();

    private ListView mListView;
    private GridView mGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manualdrawable_activity);
        mButton1 = (Button) findViewById(R.id.btn1);
        mButton2 = (Button) findViewById(R.id.btn2);
        mButton3 = (Button) findViewById(R.id.btn3);
        mButton4 = (Button) findViewById(R.id.btn4);
        mButton5 = (Button) findViewById(R.id.btn5);
        mButton6 = (Button) findViewById(R.id.btn6);
        mButton7 = (Button) findViewById(R.id.btn7);
        mButton8 = (Button) findViewById(R.id.btn8);
        mButton9 = (Button) findViewById(R.id.btn9);
        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
        mButton4.setOnClickListener(this);
        mButton5.setOnClickListener(this);
        mButton6.setOnClickListener(this);
        mButton7.setOnClickListener(this);
        mButton8.setOnClickListener(this);
        mButton9.setOnClickListener(this);

        initSimpleAdapterData(200);
        SimpleAdapter adapter = new SimpleAdapter(this, mSimpleAdapterData, R.layout.list_item,
                new String[] { ITEM_TEXT }, new int[] { R.id.item_text });
        mListView = (ListView) findViewById(R.id.list);
        mGridView = (GridView) findViewById(R.id.grid);
        if (mListView != null) {
            mListView.setAdapter(adapter);
            mListView.setOnItemClickListener(this);
        }
        if (mGridView != null) {
            mGridView.setAdapter(adapter);
        }
    }

    private void initSimpleAdapterData(int count) {
        for (int i = 1; i <= count; ++i) {
            String d = "Data: " + i;
            HashMap<String, String> data = new HashMap<String, String>();
            data.put(ITEM_TEXT, d);
            mSimpleAdapterData.add(data);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                switchVisibility(mButton2);
                break;
            case R.id.btn2:
                switchVisibility(mButton1);
                break;
            case R.id.btn3:
                switchVisibility(mButton4);
                break;
            case R.id.btn4:
                switchVisibility(mButton5);
                break;
            case R.id.btn5:
                Drawable bg = mButton5.getBackground();
                for (int state : bg.getState()) {
                    Log.d("hanwei", "state: " + Integer.toHexString(state));
                }
                break;
            case R.id.btn6:
                switchVisibility(mButton7);
                break;
            case R.id.btn7:
                switchVisibility(mButton6);
                break;
            case R.id.btn8:
                switchVisibility(mButton9);
                break;
            case R.id.btn9:
                switchVisibility(mButton8);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adaptiveddrawable_activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_settings:
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void switchVisibility(View v) {
        if (v.getVisibility() == View.INVISIBLE) {
            v.setVisibility(View.GONE);
        } else if (v.getVisibility() == View.VISIBLE) {
            v.setVisibility(View.INVISIBLE);
        } else {
            v.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switchVisibility(mButton5);
    }

}
