/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar.fragment;

import miui.app.Fragment;
import miui.util.AttributeResolver;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miui.R;

public class UsageFragment extends Fragment implements
        SearchView.OnQueryTextListener {

    TextView mSearchText;

    int mSortMode = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeRes(R.style.Theme);
    }

    @Override
    public View onInflateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mSearchText = new TextView(getActivity());
        return mSearchText;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.actions, menu);
        return true;
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        if (mSortMode != -1) {
            Drawable icon = menu.findItem(mSortMode).getIcon();
            menu.findItem(R.id.action_sort).setIcon(icon);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getActivity(), "Selected Item: " + item.getTitle(), Toast.LENGTH_SHORT)
                .show();
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
        Toast.makeText(getActivity(), "Searching for: " + query + "...", Toast.LENGTH_SHORT).show();
        return true;
    }

    private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

        private static final String TITLE = "action mode";

        private boolean mToUpperCase;

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            Drawable icon = AttributeResolver.resolveDrawable(getThemedContext(), miui.R.attr.actionBarEditIcon);
            actionMode.setTitle(TITLE);
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

            mToUpperCase = !mToUpperCase;
            actionMode.setTitle(mToUpperCase ? TITLE.toUpperCase() : TITLE.toLowerCase());
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
        }
    };
}
