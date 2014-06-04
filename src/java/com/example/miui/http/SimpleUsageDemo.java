/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.http;

import miui.app.Activity;
import miui.net.http.HttpResponse;
import miui.net.http.HttpSession;
import miui.widget.ProgressBar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;

public class SimpleUsageDemo extends Activity {

    private Thread mThread;

    private ProgressBar mProgressBar;

    private TextView mTextView;

    private ImageView mImageView;

    private Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupContentView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mThread != null) {
            mThread.interrupt();
        }
    }

    void setupContentView() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        setupButtons(linearLayout);

        mProgressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        mProgressBar.setIndeterminate(true);
        linearLayout.addView(mProgressBar,
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        mTextView = new TextView(this);
        mTextView.setText("0");
        linearLayout.addView(mTextView,
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        mImageView = new ImageView(this);
        linearLayout.addView(mImageView,
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) mImageView.getLayoutParams();
        lp.weight = 1;
        mImageView.setLayoutParams(lp);

        addContentView(linearLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
    }

    void setupButtons(ViewGroup parent) {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        mStart = createButton(ll, "Start", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                if ("Start".equals(button.getText())) {
                    mImageView.setImageDrawable(null);
                    mProgressBar.setIndeterminate(true);
                    mTextView.setText("0");
                    mThread = new WorkThread();
                    mThread.start();
                    button.setText("Stop");
                } else {
                    Thread thread = mThread;
                    if (thread != null) {
                        thread.interrupt();
                    }
                    mThread = null;
                    button.setText("Start");
                }
            }
        });

        createButton(ll, "Clear Cache", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpSession.getDefault().clearCacheContent();
            }
        });

        parent.addView(ll, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
    }

    Button createButton(LinearLayout parent, String text, View.OnClickListener listener) {
        Button button = new Button(this);
        button.setText(text);
        button.setOnClickListener(listener);

        LinearLayout.LayoutParams lp;
        if (parent.getOrientation() == LinearLayout.HORIZONTAL) {
            lp = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
            lp.leftMargin = 5;
            lp.rightMargin = 5;
        } else {
            lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0);
            lp.topMargin = 5;
            lp.bottomMargin = 5;
        }
        lp.weight = 1;
        parent.addView(button, lp);

        return button;
    }

    private class WorkThread extends Thread {
        @Override
        public void run() {
            String url = "http://ww4.sinaimg.cn/mw690/6b2031fdjw1eb5ad63do0j20hs0hs76h.jpg";
            try {
                HttpResponse r = HttpSession.getDefault().get(url,
                        null, null, new HttpSession.ProgressListener() {
                    @Override
                    public void onProgress(final long max, final long current) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText(Float.toString(current * 10 / max / (float) 10));
                                if (max <= 0) {
                                    mProgressBar.setIndeterminate(true);
                                } else {
                                    mProgressBar.setIndeterminate(false);
                                    mProgressBar.setMax((int) max);
                                    mProgressBar.setProgress((int) current);
                                }
                            }
                        });
                    }
                });

                final Bitmap bitmap = BitmapFactory.decodeStream(r.getContent());
                r.release();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mImageView.setImageBitmap(bitmap);
                        mStart.setText("Start");
                    }
                });
            } catch (IOException e) {
                Log.e("SimpleUsageDemo", "Cannot download " + url, e);
            }
        }
    }
}
