/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */
package com.example.miui.widget;

import miui.app.Activity;

import com.example.miui.R;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * Demonstrates how to use progress bars as widgets and in the title bar.  The progress bar
 * in the title will be shown until the progress is complete, at which point it fades away.
 */
public class ProgressBar1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.progressbar_1);

        final ProgressBar progressHorizontal = (ProgressBar) findViewById(R.id.progress_horizontal);

        Button button = (Button) findViewById(R.id.increase);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementProgressBy(1);
            }
        });

        button = (Button) findViewById(R.id.decrease);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementProgressBy(-1);
            }
        });

        button = (Button) findViewById(R.id.increase_secondary);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementSecondaryProgressBy(1);
            }
        });

        button = (Button) findViewById(R.id.decrease_secondary);
        button.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                progressHorizontal.incrementSecondaryProgressBy(-1);
            }
        });

    }
}
