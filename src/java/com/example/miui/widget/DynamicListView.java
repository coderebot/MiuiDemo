/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */


package com.example.miui.widget;


import miui.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.example.miui.R;

public class DynamicListView extends Activity {

    private miui.widget.DynamicListView mListView;

    private StableArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_listview);
        final ArrayList<String> mCheeseList = new ArrayList<String>();
        for (int i = 0; i < Cheeses.sCheeseStrings.length; ++i) {
            mCheeseList.add(Cheeses.sCheeseStrings[i]);
        }
        mListView = (miui.widget.DynamicListView) findViewById(R.id.listview);
        mAdapter = new StableArrayAdapter(this, mCheeseList, mListView);
        mListView.setAdapter(mAdapter);
        mListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        mListView.setRearrangeListener(
                new miui.widget.DynamicListView.RearrangeListener() {
                    @Override
                    public void onOrderChanged(int from, int to) {
                        swapElements(mCheeseList, from, to);
                    }

                    @Override
                    public void onDragStart() {
                        Toast.makeText(getApplicationContext(), "onDragStart", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onDragEnd() {
                        Toast.makeText(getApplicationContext(), "onDragEnd", Toast.LENGTH_SHORT).show();
                    }

                });
        mListView.setOnItemRemoveListener(
                new miui.widget.DynamicListView.OnItemRemoveListener() {
                    @Override
                    public void onItemRemove(List<Long> ids) {
                        List<String> itemsToRemove = new ArrayList<String>(
                                ids.size());
                        for (Long id : ids) {
                            itemsToRemove.add(mAdapter.getItemForId(id));
                        }
                        mCheeseList.removeAll(itemsToRemove);
                    }
                });
        mListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        mListView.setMultiChoiceModeListener(new ModeCallback());
    }

    private class ModeCallback implements ListView.MultiChoiceModeListener {

        private List<Long> mIdsToRemove = new ArrayList<Long>(1);

        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.dynamic_listview_action_menu, menu);
            mode.setTitle("Select Items");
            setSubtitle(mode);
            return true;
        }

        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.delete:
                    mListView.removeItems(mIdsToRemove);
                    mode.finish();
                    break;
                default:
                    break;
            }
            return true;
        }

        public void onDestroyActionMode(ActionMode mode) {
            mIdsToRemove.clear();
        }

        public void onItemCheckedStateChanged(ActionMode mode, int position,
                long id,
                boolean checked) {
            setSubtitle(mode);
            if (checked) {
                mIdsToRemove.add(id);
            } else {
                mIdsToRemove.remove(new Long(id));
            }
            mAdapter.notifyDataSetChanged();
        }

        private void setSubtitle(ActionMode mode) {
            final int checkedCount = mListView.getCheckedItemCount();
            switch (checkedCount) {
                case 0:
                    mode.setSubtitle(null);
                    break;
                case 1:
                    mode.setSubtitle("One item selected");
                    break;
                default:
                    mode.setSubtitle("" + checkedCount + " items selected");
                    break;
            }
        }
    }

    private void swapElements(ArrayList arrayList, int indexOne, int indexTwo) {
        Object temp = arrayList.get(indexOne);
        arrayList.set(indexOne, arrayList.get(indexTwo));
        arrayList.set(indexTwo, temp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dynamic_listview, menu);
        return true;
    }

    private long DEFAULT_DURATION = 250;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.duration_default:
                mListView.setDuration(DEFAULT_DURATION);
                break;
            case R.id.duration_2:
                mListView.setDuration(DEFAULT_DURATION * 2);
                break;
            case R.id.duration_4:
                mListView.setDuration(DEFAULT_DURATION * 4);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class StableArrayAdapter extends BaseAdapter {

        final int INVALID_ID = -1;

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        HashMap<Integer, String> mItemMap = new HashMap<Integer, String>();

        private List<String> mData;

        private Context mContext;

        private LayoutInflater mInflater;

        private miui.widget.DynamicListView mListView;

        public StableArrayAdapter(Context context, List<String> objects,
                miui.widget.DynamicListView listView) {
            mListView = listView;
            mData = objects;
            for (int i = 0; i < objects.size(); ++i) {
                mIdMap.put(objects.get(i), i);
                mItemMap.put(i, objects.get(i));
            }
            mContext = context;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public String getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            if (position < 0 || position >= mIdMap.size()) {
                return INVALID_ID;
            }
            String item = getItem(position);
            return mIdMap.get(item);
        }

        public String getItemForId(long id) {
            return mItemMap.get(new Integer((int) id));
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = newView();
            }
            bindView(position, convertView);
            return convertView;
        }

        public View newView() {
            return mInflater.inflate(R.layout.listitem_dynamic_listview, null);
        }

        public void bindView(int position, View convertView) {
            Holder holder = (Holder) convertView.getTag();
            if (holder == null) {
                holder = new Holder(convertView);
            }
            holder.textView
                    .setText(mData.get(position) + " " + getItemId(position));
            holder.position = position;
            holder.drag_handle.setAlpha(mListView.isItemChecked(position) ? 1 : 0.5f);
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        private class Holder implements View.OnTouchListener {

            View convertView;

            int position;

            final TextView textView;

            final View drag_handle;

            private Holder(View convertView) {
                this.convertView = convertView;
                textView = (TextView) convertView.findViewById(R.id.textView);
                drag_handle = convertView.findViewById(R.id.drag_handle);
                drag_handle.setOnTouchListener(this);
            }

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
                    mListView.startDragging(position);
                }
                return false;
            }
        }
    }
}
