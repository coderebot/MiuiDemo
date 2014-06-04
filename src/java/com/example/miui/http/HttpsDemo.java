/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.http;

import miui.app.Activity;
import miui.net.http.HttpResponse;
import miui.net.http.HttpSession;
import miui.util.IOUtils;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

public class HttpsDemo extends Activity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupContentView();

        new Thread() {
            @Override
            public void run() {
                String url = "https://www.google.com";
                try {
                    HttpResponse r = HttpSession.getDefault().get(url, null, null, null);
                    String result = IOUtils.toString(r.getContent(), r.getContentEncoding());
                    int start = result.indexOf("<title>");
                    if (start >= 0) {
                        start += 7;
                        int end = result.indexOf("</title>", start);
                        if (end >= 0) {
                            result = result.substring(start, end);
                        } else {
                            start = -1;
                        }
                    }

                    final String text = start >= 0 ? result : "failed";
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextView.setText(text);
                        }
                    });
                } catch (IOException e) {
                    Log.e("HttpsDemo", "Cannot get url " + url, e);
                }
            }
        }.start();
    }

    void setupContentView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        mTextView = new TextView(this);
        linearLayout.addView(mTextView,
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

        addContentView(linearLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }
}
