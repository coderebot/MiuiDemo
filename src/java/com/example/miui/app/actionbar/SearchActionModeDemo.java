/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.view.SearchActionMode;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.example.common.ActionBarDemoBaseActivity;
import com.example.common.DemoControlList;
import com.example.miui.CodeStyles;
import com.example.miui.R;

public class SearchActionModeDemo extends ActionBarDemoBaseActivity {

    DemoControlList mList;
    DemoControlList mSearchResultView;
    View mAnchorView;
    ActionMode mSearchActionMode;
    SearchItemFilter mSearchItemFilter;

    SearchActionMode.Callback mSearchCallback = new SearchActionModeCallback();

    int mCount;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Drawable icon = miui.util.AttributeResolver.resolveDrawable(this, miui.R.attr.actionBarEditIcon);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(icon)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(icon)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(icon)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(icon)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(icon)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        //mMenu = menu;
        return true;
    }
    protected String generateMenuBarItemLabel() {
        String label = "item " + mCount;
        mCount++;
        return label;
    }


    //CODE-BEGIN ActionBarSearchActionModeTextWatcher
    private TextWatcher mSearchTextWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String newText = null;
            if (s != null) {
                newText = s.toString();
            }
            // show or hide search fragment
            if (TextUtils.isEmpty(newText)) {
                if (mSearchResultView.getVisibility() != View.VISIBLE) {
                    mSearchResultView.setVisibility(View.GONE);
                }
            } else {
                mSearchResultView.setVisibility(View.VISIBLE);
                mSearchItemFilter.query(newText);
            }
        }
        public void afterTextChanged(Editable s) {
        }
    };
    //CODE-END ActionBarSearchActionModeTextWatcher


    //CODE-BEGIN ActionBarSearchActionModeResultView
    private DemoControlList getSearchResultView() {
        if (mSearchResultView == null) {
            mSearchResultView = new DemoControlList(this, null);
            mSearchResultView.setBackgroundColor(0xffffccff);
            ViewGroup vg = (ViewGroup)findViewById(android.R.id.content);
            vg.addView(mSearchResultView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT));

            initSearchResultView();
        }
        return mSearchResultView;
    }
    //CODE-END ActionBarSearchActionModeResultView

    private class SearchItemFilter implements DemoControlList.ItemFilter {
        List<Integer> mFounds = new ArrayList<Integer>();
        @Override
        public int getItemPosition(int pos) {
            return mFounds.get(pos);
        }

        @Override
        public int getItemCount() {
            return mFounds.size();
        }

        void query(String text) {
            mFounds.clear();
            List<DemoControlList.Item> items = mSearchResultView.getItems();
            for (int i = 0; i < items.size(); i ++) {
                DemoControlList.Item item = items.get(i);
                if (item.title.indexOf(text) >= 0
                    || (item.summary != null && item.summary.indexOf(text) >= 0)
                    || (item.codes != null && item.codes.indexOf(text) >= 0)
                    || (item.styles != null && item.styles.indexOf(text) >= 0)) {
                    mFounds.add(i);
                }
            }
            mSearchResultView.update();
        }
    }

    private void initSearchResultView() {
        mSearchItemFilter = new SearchItemFilter();
        mSearchResultView.setItems(mList.getItems());
        mSearchResultView.setItemFilter(mSearchItemFilter);
    }

    //CODE-BEGIN SearchActionModeActionModeCallback
    private class SearchActionModeCallback implements SearchActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            mSearchActionMode = actionMode;

            SearchActionMode searchActionMode = (SearchActionMode) actionMode;
            searchActionMode.setAnchorView(mAnchorView);
            searchActionMode.setAnimateView(mList);
            searchActionMode.setResultView(getSearchResultView());

            searchActionMode.getSearchInput().addTextChangedListener(mSearchTextWatcher);

            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }


        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mSearchActionMode = null;
            SearchActionMode searchActionMode = (SearchActionMode) actionMode;
            searchActionMode.getSearchInput().removeTextChangedListener(mSearchTextWatcher);
            mSearchResultView.setVisibility(View.GONE);
        }
    }
    //CODE-END SearchActionModeActionModeCallback


    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        mList = getControlList();

        //CODE-BEGIN SearchActionModeActionModeAnchorView
        mAnchorView = getLayoutInflater()
                .inflate(miui.R.layout.search_stub, null);
        mList.addHeaderView(mAnchorView);
        mAnchorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActionMode(mSearchCallback);
            }
        });
        //CODE-END SearchActionModeActionModeAnchorView

        mList.addItem("Search ActionMode Callback",
                null,
                CodeStyles.SearchActionModeActionModeCallback,
                null, //style
                null);

        mList.addItem("Start Search ActionMode",
                null,
                CodeStyles.SearchActionModeStartActionMode,
                null, //style
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN SearchActionModeStartActionMode
                        if (mSearchActionMode == null) {
                            startActionMode(mSearchCallback);
                        }
                        //CODE-END SearchActionModeStartActionMode
                    }
                });
        mList.addItem("Finish Search ActionMode",
                null,
                CodeStyles.SearchActionModeEndActionMode,
                null, //style
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN SearchActionModeEndActionMode
                        if (mSearchActionMode != null) {
                            mSearchActionMode.finish();
                        }
                        //CODE-END SearchActionModeEndActionMode
                    }
                });

        mList.addItem("Listen the Text Change",
                null,
                CodeStyles.ActionBarSearchActionModeTextWatcher,
                null,
                null);

        mList.addItem("Create the Search Result View",
                null,
                CodeStyles.ActionBarSearchActionModeResultView,
                null,
                null);

        mList.addItem("Get the Anchor View",
                null,
                CodeStyles.SearchActionModeActionModeAnchorView,
                null,
                null);

        mList.addItem("Search Action Mode Theme",
                null,
                null,
                CodeStyles.ActionBarSearchActionModeTheme,
                null);
        mList.addItem("Search Text Action ModeStyle",
                null,
                null,
                CodeStyles.ActionBarSearchActionModeTextStyle,
                null);

    }

}
