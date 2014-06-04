/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar.fragment;

import miui.app.ListFragment;
import miui.util.AttributeResolver;

import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miui.R;

public class MechanicsFragment extends ListFragment {

    private static int[] ITEMS = {
            R.id.show_split_action_bar,
            R.id.hide_split_action_bar,
            R.id.set_action_button_title,
            R.id.set_action_button_icon,
            R.id.set_action_button_visibility,
            R.id.add_action_button,
            R.id.remove_action_button,
            R.id.clear_action_button,
    };

    private static String[] TEXTS = {
            "show split action bar",
            "hide split action bar",
            "set action button title",
            "set action button icon",
            "set action button visibility",
            "add action button",
            "remove action button",
            "clear action button",
    };

    private int mCount;
    private Menu mMenu;
    private boolean mSetTitle;
    private boolean mSetIcon;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeRes(R.style.Theme);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        getListView().setAdapter(new ListAdapter() {
            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public int getViewTypeCount() {
                return 1;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getActivity())
                            .inflate(R.layout.simple_list_item_1, null);
                }
                convertView.setId(ITEMS[position]);
                ((TextView) convertView).setText(TEXTS[position]);
                return convertView;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public long getItemId(int position) {
                return ITEMS[position];
            }

            @Override
            public Object getItem(int position) {
                return ITEMS[position];
            }

            @Override
            public int getCount() {
                return ITEMS.length;
            }

            @Override
            public boolean isEnabled(int position) {
                return true;
            }

            @Override
            public boolean areAllItemsEnabled() {
                return true;
            }
        });
        setListShownNoAnimation(true);
    }

    protected String generateMenuBarItemLabel() {
        String label = "item " + mCount;
        mCount++;
        return label;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int iconId = AttributeResolver.resolve(getThemedContext(), miui.R.attr.actionBarEditIcon);
        menu.add(Menu.NONE, R.id.set_action_button_title, Menu.NONE, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(Menu.NONE, R.id.set_action_button_title, Menu.NONE, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(Menu.NONE,R.id.set_action_button_title, Menu.NONE, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(Menu.NONE, R.id.set_action_button_title,Menu.NONE, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(Menu.NONE, R.id.set_action_button_title, Menu.NONE, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        mMenu = menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        MenuItem item;

        switch ((int) id) {
            case R.id.show_split_action_bar:
                getActionBar().showSplitActionBar(true, true);
                break;

            case R.id.hide_split_action_bar:
                getActionBar().showSplitActionBar(false, true);
                break;

            case R.id.set_action_button_title:
                item = mMenu.findItem(R.id.set_action_button_title);
                String title = (String) item.getTitle();
                item.setTitle(mSetTitle ? title.toLowerCase() : title.toUpperCase());
                mSetTitle = !mSetTitle;
                break;

            case R.id.set_action_button_icon:
                item = mMenu.findItem(R.id.set_action_button_title);
                item.setIcon(mSetIcon ? AttributeResolver.resolve(getThemedContext(),
                        miui.R.attr.actionBarFavoriteIcon) : AttributeResolver.resolve(getThemedContext(),
                        miui.R.attr.actionBarUnfavoriteIcon));
                mSetIcon = !mSetIcon;
                break;

            case R.id.set_action_button_visibility:
                item = mMenu.findItem(R.id.set_action_button_title);
                item.setVisible(!item.isVisible());
                break;

            case R.id.add_action_button:
                mMenu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                        .setIcon(AttributeResolver.resolve(getThemedContext(), miui.R.attr.actionBarEditIcon))
                        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
                break;

            case R.id.remove_action_button:
                mMenu.removeItem(R.id.set_action_button_title);
                break;

            case R.id.clear_action_button:
                mMenu.clear();
                break;
        }
    }
}
