/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.http;

import miui.app.Activity;
import miui.net.http.HttpSession;
import miui.widget.ProgressBar;

import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class DownloadDemo extends Activity {
    DownloadThread mThread = null;

    @Override
    public Object onRetainNonConfigurationInstance() {
        DownloadThread t = mThread;
        mThread = null;
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final ProgressBar pb = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
        linearLayout.addView(pb,
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        final TextView textView = new TextView(this);
        textView.setText("0/0");
        linearLayout.addView(textView,
                new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        addContentView(linearLayout, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        mThread = (DownloadThread) getLastNonConfigurationInstance();
        if (mThread == null) {
            mThread = new DownloadThread();
            mThread.mActivity = this;
            mThread.mTextView = textView;
            mThread.mProgressBar = pb;
            mThread.start();
        } else {
            mThread.mActivity = this;
            mThread.mTextView = textView;
            mThread.mProgressBar = pb;
            if (!mThread.isAlive()) {
                textView.setText("Done");
                pb.setMax(100);
                pb.setProgress(100);
            }
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mThread != null) {
            mThread.interrupt();
            new File(getCacheDir(), "tmp").delete();
        }
    }

    private static class DownloadThread extends Thread {
        public Activity mActivity;
        public TextView mTextView;
        public ProgressBar mProgressBar;

        @Override
        public void run() {
            String url = "http://bigota.d.miui.com/tools/dz_tools.zip";
            File file = new File(mActivity.getCacheDir(), "tmp");
            file.delete();
            try {
                HttpSession.getDefault().download(file, url, null, null, new HttpSession.ProgressListener() {
                    @Override
                    public void onProgress(final long max, final long current) {
                        mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText(Long.toString(current) + "/" + Long.toString(max));
                                if (max < 0) {
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

                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                raf.setLength(file.length() / 2);
                raf.close();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }

                HttpSession.getDefault().download(file, url, null, null, new HttpSession.ProgressListener() {
                    @Override
                    public void onProgress(final long max, final long current) {
                        mActivity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mTextView.setText(Long.toString(current) + "/" + Long.toString(max));
                                if (max < 0) {
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
            } catch (IOException e) {
                Log.e("DownloadDemo", "Cannot download url " + url + " due to " + e.getMessage(), e);
            } finally {
                file.delete();
            }
        }
    }
}
