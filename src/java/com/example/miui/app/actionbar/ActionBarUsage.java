/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.Activity;
import miui.util.AttributeResolver;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miui.R;

/**
 * This demonstrates idiomatic usage of the Action Bar. The default Honeycomb
 * theme includes the action bar by default and a menu resource is used to
 * populate the menu data itself. If you'd like to see how these things work
 * under the hood, see ActionBarMechanics.
 */
public class ActionBarUsage extends Activity implements SearchView.OnQueryTextListener {
    TextView mSearchText;

    int mSortMode = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSearchText = new TextView(this);
        setContentView(mSearchText);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (mSortMode != -1) {
            Drawable icon = menu.findItem(mSortMode).getIcon();
            menu.findItem(R.id.action_sort).setIcon(icon);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        switch (item.getItemId()) {
            case R.id.action_sort_size:
            case R.id.action_sort_alpha:
                onSort(item);
            case R.id.action_search:
                mSearchText.startActionMode(mActionModeCallback);
                break;
        }
        return true;
    }

    // This method is specified as an onClick handler in the menu xml and will
    // take precedence over the Activity's onOptionsItemSelected method.
    // See res/menu/actions.xml for more info.
    public void onSort(MenuItem item) {
        mSortMode = item.getItemId();
        // Request a call to onPrepareOptionsMenu so we can change the sort icon
        invalidateOptionsMenu();
    }

    // The following callbacks are called for the
    // SearchFragment.OnQueryChangeListener
    // For more about using SearchFragment, see src/.../view/SearchView1.java and
    // SearchView2.java
    public boolean onQueryTextChange(String newText) {
        newText = newText.isEmpty() ? "" : "Query so far: " + newText;
        mSearchText.setText(newText);
        return true;
    }

    public boolean onQueryTextSubmit(String query) {
        Toast.makeText(this, "Searching for: " + query + "...", Toast.LENGTH_SHORT).show();
        return true;
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            Drawable icon = AttributeResolver.resolveDrawable(ActionBarUsage.this, miui.R.attr.actionBarEditIcon);
            actionMode.setTitle("Action Mode");
            menu.add("item 0").setIcon(icon);
            menu.add("item 1").setIcon(icon);
            menu.add("item 2").setIcon(icon);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (menuItem.getItemId() == android.R.id.button1) {
                actionMode.finish();
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
        }
    };
}
