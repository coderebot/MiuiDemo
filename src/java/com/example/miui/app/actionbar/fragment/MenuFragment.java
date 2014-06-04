/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar.fragment;

import miui.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.miui.R;
import com.example.miui.app.actionbar.ActionBarDemo;

import java.util.ArrayList;

public class MenuFragment extends Fragment {
    private ListView mListView;

    private ArrayList<String> mDemoList = new ArrayList<String>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeRes(R.style.Theme_Navigation);
    }

    @Override
    public View onInflateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_list, null);
        findViews(contentView);
        prepareDemoList();

        mListView.setAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.simple_list_item_1, mDemoList));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ActionBarDemo activity = (ActionBarDemo) getActivity();
                activity.changeContent(mDemoList.get(position), false);
            }
        });
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ActionBarDemo activity = (ActionBarDemo) getActivity();
                activity.changeContent(mDemoList.get(position), true);
                return true;
            }
        });
        return contentView;
    }

    private void findViews(View contentView) {
        mListView = (ListView) contentView.findViewById(R.id.listView);
    }

    private void prepareDemoList() {
        mDemoList.add(getString(R.string.actionbar_mechanics));
        mDemoList.add(getString(R.string.actionbar_tabs));
        mDemoList.add(getString(R.string.actionbar_display_options));
        mDemoList.add(getString(R.string.actionbar_usage));
        mDemoList.add(getString(R.string.actionbar_list_fragment));
        mDemoList.add(getString(R.string.actionbar_searchview));
        mDemoList.add(getString(R.string.actionbar_immersionmenu));
    }
}
