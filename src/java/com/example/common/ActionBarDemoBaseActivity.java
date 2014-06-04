/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.common;

import miui.app.ActionBar;
import miui.app.Activity;

import android.os.Bundle;
import android.view.ViewGroup;

public class ActionBarDemoBaseActivity extends Activity {

    DemoControlList mControlList;
    ActionBar mActionBar;

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        mActionBar = getActionBar();
    }

    public DemoControlList getControlList () {
        if (mControlList == null) {
            mControlList = new DemoControlList(this, null);
            setContentView(mControlList,
                    new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT));
        }

        return mControlList;
    }

}
