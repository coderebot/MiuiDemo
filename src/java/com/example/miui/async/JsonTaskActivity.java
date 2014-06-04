/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.async;

import miui.app.Activity;
import miui.net.http.HttpSession;
import miui.util.async.TaskManager;
import miui.util.async.tasks.HttpJsonArrayTask;
import miui.util.async.tasks.listeners.ProgressDialogListener;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;

public class JsonTaskActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(android.R.layout.simple_list_item_1);
        final TextView textView = (TextView) findViewById(android.R.id.text1);
        ViewGroup.LayoutParams params = textView.getLayoutParams();
        params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        textView.setLayoutParams(params);

        new TaskManager().add(
                new HttpJsonArrayTask("http://zhuomian.xiaomi.com/mobile/analytics2.json") {
                    @Override
                    public void onResult(TaskManager tm, JSONArray result) {
                        super.onResult(tm, result);
                        textView.setText(result.toString());
                    }
                }.addListener(new ProgressDialogListener(getFragmentManager())));
    }
}
