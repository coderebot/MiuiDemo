/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget;

import miui.app.ListActivity;
import miui.widget.EditableListView;
import miui.widget.EditableListViewWrapper;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.miui.R;

public class EditableListViewWrapperDemo extends ListActivity {

    private static final String HEADER = "header";

    private static final String FOOTER = "footer";

    private EditableListViewWrapper mEditableListViewWrapper;

    private AbsListView.MultiChoiceModeListener mMultiChoiceModeListener = new EditableListView.MultiChoiceModeListener() {
        @Override
        public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
        }

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater menuInflater = new MenuInflater(EditableListViewWrapperDemo.this);
            menuInflater.inflate(R.menu.actions, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
        }

        @Override
        public void onAllItemCheckedStateChanged(ActionMode mode, boolean checked) {
            Toast.makeText(EditableListViewWrapperDemo.this, String.valueOf(checked), Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addHeaderViews();
        addFooterViews();
        mEditableListViewWrapper = new EditableListViewWrapper(getListView());
        mEditableListViewWrapper.setAdapter(new SimpleListAdapter());
        mEditableListViewWrapper.setMultiChoiceModeListener(mMultiChoiceModeListener);
    }

    private void addHeaderViews() {
        TextView headerView = (TextView) View.inflate(this, R.layout.simple_list_item_1, null);
        headerView.setText(HEADER);
        getListView().addHeaderView(headerView);

        headerView = (TextView) View.inflate(this, R.layout.simple_list_item_1, null);
        headerView.setText(HEADER);
        getListView().addHeaderView(headerView);

        headerView = (TextView) View.inflate(this, R.layout.simple_list_item_1, null);
        headerView.setText(HEADER);
        getListView().addHeaderView(headerView);
    }

    private void addFooterViews() {
        TextView headerView = (TextView) View.inflate(this, R.layout.simple_list_item_1, null);
        headerView.setText(FOOTER);
        getListView().addFooterView(headerView);

        headerView = (TextView) View.inflate(this, R.layout.simple_list_item_1, null);
        headerView.setText(FOOTER);
        getListView().addFooterView(headerView);

        headerView = (TextView) View.inflate(this, R.layout.simple_list_item_1, null);
        headerView.setText(FOOTER);
        getListView().addFooterView(headerView);
    }

    private class SimpleListAdapter extends BaseAdapter {

        private static final int MAX_ITEMS = 256;

        private static final int TAG_VIEW_HOLDER = R.id.listView;

        private ArrayList<String> mItems;

        private class ViewHolder {

            private TextView textView;

        }

        public SimpleListAdapter() {
            init();
        }

        private void init() {
            mItems = new ArrayList<String>();
            for (int i = 0; i < MAX_ITEMS; i++) {
                mItems.add("item");
            }
        }

        @Override
        public int getCount() {
            return mItems.size();
        }

        @Override
        public Object getItem(int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                view = newView();

                ViewHolder holder = new ViewHolder();
                holder.textView = (TextView) view.findViewById(android.R.id.text1);
                view.setTag(TAG_VIEW_HOLDER, holder);
            }

            ViewHolder holder = (ViewHolder) view.getTag(TAG_VIEW_HOLDER);
            if (holder != null) {
                holder.textView.setText(mItems.get(position));
            }

            return view;
        }

        private View newView() {
            return View.inflate(EditableListViewWrapperDemo.this, R.layout.simple_list_item_2, null);
        }
    }
}
