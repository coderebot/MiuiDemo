/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.ActionBar;
import miui.app.Activity;
import miui.view.ViewPager;


import com.miui.internal.widget.ActionBarMovableLayout;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ListFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.DemoControlList;
import com.example.miui.CodeStyles;
import com.example.miui.R;

//CODE-BEGIN ActionBarMovableLayoutImplementsSetOnScrollListener
public class ActionBarMovableLayoutDemo extends Activity implements ActionBarMovableLayout.OnScrollListener {
//CODE-END ActionBarMovableLayoutImplementsSetOnScrollListener

    private static final String TAG="ActionBarMovableLayoutDemo";

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //CODE-BEGIN ActionBarMovableLayoutInflateLayout
        setContentView(R.layout.action_bar_movable_layout);
        mViewPager = (ViewPager) findViewById(miui.R.id.view_pager);
        final ActionBar actionBar = getActionBar();
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(new TextView(this, null));

        actionBar.setFragmentViewPagerMode(this, getFragmentManager());
        actionBar.addFragmentTab("tab-0", actionBar.newTab().setText("tab-0"), ArrayListFragment.class, null, false);
        actionBar.addFragmentTab("tab-1", actionBar.newTab().setText("tab-1"), ArrayListFragment.class, null, false);
        //CODE-END ActionBarMovableLayoutInflateLayout

        actionBar.addFragmentTab("Source", actionBar.newTab().setText("Source"), SourceFragment.class, null, false);

        //CODE-BEGIN ActionBarMovableLayoutSetScrollListener
        ActionBarMovableLayout movableLayout = (ActionBarMovableLayout) findViewById(
                com.miui.internal.R.id.action_bar_overlay_layout);
        movableLayout.setOnScrollListener(this);
        //CODE-END ActionBarMovableLayoutSetScrollListener
    }


    //CODE-BEGIN ActionBarMovableLayoutScrollListenerMethods
    @Override
    public boolean onContentScrolled() {
        Log.i(TAG, "onContentScrolled");
        return false;
    }

    @Override
    public void onStartScroll() {
        Log.i(TAG, "onStartScroll");
    }

    @Override
    public void onStopScroll() {
        Log.i(TAG, "onStopScroll");
    }

    @Override
    public void onScroll(int state, float offset) {
        Log.i(TAG, "onScroll");
    }

    @Override
    public void onFling(float distance, int duration) {
        Log.i(TAG, "onFling");
    }
    //CODE-END ActionBarMovableLayoutScrollListenerMethods

    public static class ArrayListFragment extends ListFragment {
        private static String[] ITEMS = {"Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG",
                "Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG",
                "Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG",
                "Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG",
                "Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG",
                "Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG"};

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_1, ITEMS));
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Toast.makeText(getActivity(), ITEMS[(int) id] + " clicked", Toast.LENGTH_SHORT).show();
        }
    }

    public static class SourceFragment extends Fragment {
        DemoControlList mList;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            mList = new DemoControlList(getActivity(), null);
            mList.setLayoutParams(new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            return mList;
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            mList.addItem("Use ActionBarMovableLayout Fragement Tab",
                    "Called In onCreate",
                    CodeStyles.ActionBarMovableLayoutInflateLayout + "...\nR.layout.action_bar_movable_layout:" +
                            CodeStyles.ActionBarMovableLayout,
                    null, null);
            mList.addItem("Optional: ScrollListener",
                    "internal classes",
                    CodeStyles.ActionBarMovableLayoutImplementsSetOnScrollListener + "...\n"
                        + "//In onCreate\n" + CodeStyles.ActionBarMovableLayoutSetScrollListener
                        + "...\n" + CodeStyles.ActionBarMovableLayoutScrollListenerMethods,
                    null, null);

            mList.addItem("ActionBarMovable Theme",
                    null,
                    null,
                    CodeStyles.ActionBarMovableTheme, null);
            mList.addItem("ActionBarMovable actionbar style",
                    null,
                    null,
                    CodeStyles.ActionBarMovableLayoutStyleMovable, null);
            mList.addItem("ActionBarMovable actionbar movable style",
                    null,
                    null,
                    CodeStyles.ActionBarMovableLayoutStyle, null);

        }
    }
}
