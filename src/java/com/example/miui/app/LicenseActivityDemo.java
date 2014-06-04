/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app;

import miui.app.Activity;
import miui.content.ExtraIntent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.miui.R;

public class LicenseActivityDemo extends Activity {

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(getIntent(v.getId()));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);

        findViewById(R.id.show_copyright).setOnClickListener(mOnClickListener);
        findViewById(R.id.show_agreement).setOnClickListener(mOnClickListener);
        findViewById(R.id.show_privacy).setOnClickListener(mOnClickListener);
    }

    private Intent getIntent(int id) {
        Intent intent = new Intent(ExtraIntent.ACTION_VIEW_LICENSE);

        int type;
        switch (id) {
            case R.id.show_copyright:
                type = ExtraIntent.LICENSE_COPYRIGHT;
                break;

            case R.id.show_agreement:
                type = ExtraIntent.LICENSE_USER_AGREEMENT;
                break;

            case R.id.show_privacy:
                type = ExtraIntent.LICENSE_PRIVACY_POCICY;
                break;

            default:
                type = ExtraIntent.LICENSE_INVALID;
                break;
        }

        intent.putExtra(ExtraIntent.EXTRA_LICENSE_TYPE, type);

        return intent;
    }

}
