/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.util.AttributeResolver;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.common.ActionBarDemoBaseActivity;
import com.example.common.DemoControlList;
import com.example.miui.CodeStyles;
import com.example.miui.R;

public class ActionBarSplitBarDemo extends ActionBarDemoBaseActivity {

    private int mCount = 0;
    private Menu mMenu;

    @Override
    public void onCreate(Bundle savedInstances) {
        super.onCreate(savedInstances);

        DemoControlList list = getControlList();


        list.addItem("Create the Options Menu",
                "Here! Get the mMenu!",
                CodeStyles.CreateActionBarOptionMenu,
                null,
                null);
        list.addItem("Create the Options Menu",
                null,
                CodeStyles.OnOptionsItemSelected,
                null,
                null);
        list.addItem("Show/Hide Split Action Bar",
                    null,
                    CodeStyles.ShowHideSplitActionBar,
                    null,
                    new Runnable() {
                        boolean show = true;
                        @Override
                        public void run() {
                            //CODE-BEGIN ShowHideSplitActionBar
                            getActionBar().showSplitActionBar(show, true);
                            show = !show;
                            //CODE-END ShowHideSplitActionBar
                        }
                    });
        list.addItem("Set Action Button Title",
                null,
                CodeStyles.SetActionButtonTitle,
                null,
                new Runnable() {
                    boolean mSetTitle = true;
                    @Override
                    public void run() {
                        //CODE-BEGIN SetActionButtonTitle
                        MenuItem item = mMenu.findItem(R.id.set_action_button_title);
                        String title = (String) item.getTitle();
                        item.setTitle(mSetTitle ? title.toLowerCase() : title.toUpperCase());
                        mSetTitle = !mSetTitle;
                        //CODE-END SetActionButtonTitle
                    }
                });
        list.addItem("Set Action Button Icon",
                null,
                CodeStyles.SetActionButtonIcon,
                null,
                new Runnable() {
                    boolean mSetIcon = true;
                    @Override
                    public void run() {
                        //CODE-BEGIN SetActionButtonIcon
                        MenuItem item = mMenu.findItem(R.id.set_action_button_title);
                        item.setIcon(mSetIcon ? AttributeResolver.resolve(ActionBarSplitBarDemo.this,
                                miui.R.attr.actionBarFavoriteIcon) : AttributeResolver.resolve(ActionBarSplitBarDemo.this,
                                miui.R.attr.actionBarUnfavoriteIcon));
                        mSetIcon = !mSetIcon;
                        //CODE-END SetActionButtonIcon
                    }
                });
        list.addItem("Set Action Button Visible",
                null,
                CodeStyles.SetActionButtonVisible,
                null,
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN SetActionButtonVisible
                        MenuItem item = mMenu.findItem(R.id.set_action_button_title);
                        item.setVisible(!item.isVisible());
                        //CODE-END SetActionButtonVisible
                    }
                });
        list.addItem("Add Action Button",
                null,
                CodeStyles.AddActionButton,
                null,
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN AddActionButton
                        mMenu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                                .setIcon(AttributeResolver.resolve(ActionBarSplitBarDemo.this, miui.R.attr.actionBarEditIcon))
                                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
                        //CODE-END AddActionButton
                    }
                });
        list.addItem("Remove Action Button",
                null,
                CodeStyles.RemoveActionButton,
                null,
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN RemoveActionButton
                        mMenu.removeItem(R.id.set_action_button_title);
                        //CODE-END RemoveActionButton
                    }
                });
        list.addItem("Clear Action Button",
                null,
                CodeStyles.ClearAllActionButton,
                null,
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN ClearAllActionButton
                        mMenu.clear();
                        //CODE-END ClearAllActionButton
                    }
                });

        list.addItem("Split Bar Theme",
                    null,
                    null,
                    "<!-- themes.xml -->\n" + CodeStyles.ActionBarSplitTheme,
                    null);
        list.addItem("Split Bar style",
                null,
                null,
                "<!-- styles.xml -->\n" + CodeStyles.ActionBarSplitStyle,
                null);
        list.addItem("Split Action Menu Item Style",
        null,
                null,
                "<!-- styles.xml -->\n" + CodeStyles.ActionBarActionButtonStyle,
                null);
        list.addItem("Split Action Menu Overflow Item Style",
                "Overflow button is more button (...)",
                null,
                "<!-- styles.xml -->\n" + CodeStyles.ActionBarActionOverflowButtonStyle,
                null);
        list.addItem("Split in Popup Window Style",
                null,
                null,
                "<!-- styles.xml -->\n" + CodeStyles.ActionBarPopupMenuWindowStyle,
                null);
        /*list.addItem("Split Action Menu Title Text Style in Popup Window Style",
                null,
                null,
                "<!-- styles.xml -->\n" + CodeStyles.ActionBarPopupMenuTitleTextStyle,
                null);
        list.addItem("Split Action Menu Shortcut Text Style in Popup Window Style",
                null,
                null,
                "<!-- styles.xml -->\n" + CodeStyles.ActionBarPopupMenuShortcurTextStyle,
                null);*/

    }

    //CODE-BEGIN CreateActionBarOptionMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        int iconId = AttributeResolver.resolve(this, miui.R.attr.actionBarEditIcon);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())
                .setIcon(iconId)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        mMenu = menu;
        return true;
    }
    //CODE-END CreateActionBarOptionMenu

    //CODE-BEGIN OnOptionsItemSelected
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }
    //CODE-END OnOptionsItemSelected

    protected String generateMenuBarItemLabel() {
        String label = "item " + mCount;
        mCount++;
        return label;
    }

}
