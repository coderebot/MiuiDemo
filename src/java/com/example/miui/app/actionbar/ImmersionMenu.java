/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import com.example.miui.R;
import com.example.miui.app.actionbar.fragment.ImmersionMenuFragment;

import miui.app.Activity;

import android.app.FragmentManager;
import android.os.Bundle;

public class ImmersionMenu extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.fragment);

        super.onCreate(savedInstanceState);

        FragmentManager fm = getFragmentManager();
        ImmersionMenuFragment fragment = (ImmersionMenuFragment) fm.findFragmentById(R.id.fragment);
        if (fragment == null) {
            fragment = new ImmersionMenuFragment();
            fm.beginTransaction().replace(R.id.fragment, fragment).commitAllowingStateLoss();
            fm.executePendingTransactions();
        }
    }

}
