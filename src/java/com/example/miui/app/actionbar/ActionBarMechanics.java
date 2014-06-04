/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.ActionBar;
import miui.app.Activity;
import miui.util.AttributeResolver;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.example.miui.R;

/**
 * This demonstrates the basics of the Action Bar and how it interoperates with the standard options menu. This demo is
 * for informative purposes only; see ActionBarUsage for an example of using the Action Bar in a more idiomatic manner.
 */
public class ActionBarMechanics extends Activity {

    private boolean mProgressBarVisible;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // the requestExtraWindowFeature must be called before super.onCreate
        requestExtraWindowFeature(Window.FEATURE_ACTION_BAR);
        requestExtraWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_mechanics);
        final ActionBar actionBar = getActionBar();
        actionBar.setProgressBarIndeterminateVisibility(false);

        findViewById(R.id.toggle_progress).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressBarVisible = !mProgressBarVisible;
                actionBar.setProgressBarIndeterminateVisibility(mProgressBarVisible);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Menu items default to never show in the action bar. On most devices
        // this means
        // they will show in the standard options menu panel when the menu
        // button is pressed.
        // On xlarge-screen devices a "More" button will appear in the far right
        // of the
        // Action Bar that will display remaining items in a cascading menu.
        menu.add("Normal item");

        MenuItem actionItem = menu.add("Action Button");

        // Items that show as actions should favor the "if room" setting, which
        // will
        // prevent too many buttons from crowding the bar. Extra items will show
        // in the
        // overflow area.
        actionItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

        // Items that show as actions are strongly encouraged to use an icon.
        // These icons are shown without a text description, and therefore
        // should
        // be sufficiently descriptive on their own.
        actionItem.setIcon(AttributeResolver.resolveDrawable(this, miui.R.attr.actionBarEditIcon));

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
}
