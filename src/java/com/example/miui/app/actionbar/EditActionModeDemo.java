/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.view.EditActionMode;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.common.ActionBarDemoBaseActivity;
import com.example.common.DemoControlList;
import com.example.miui.CodeStyles;

public class EditActionModeDemo extends ActionBarDemoBaseActivity {

    private static final int COPY = 100;
    private static final int CUT = 101;
    private static final int PASTE = 102;
    private static final int DELETE = 103;


    DemoControlList mList;
    ActionMode mEditActionMode;
    private boolean mSelectAll = true;

    private int mCount = 0;

    //CODE-BEGIN EditActionModeActionModeCallback
    private class ActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            mEditActionMode = actionMode;
            mEditActionMode.setTitle("Editting Mode!");
            menu.add(Menu.NONE, COPY,Menu.NONE, "copy")
                    .setIcon(miui.R.drawable.action_button_copy_light)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            menu.add(Menu.NONE, CUT,Menu.NONE, "cut")
                    .setIcon(miui.R.drawable.action_button_cut_light)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            menu.add(Menu.NONE, PASTE,Menu.NONE, "paste")
                    .setIcon(miui.R.drawable.action_button_paste_light)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
            menu.add(Menu.NONE, DELETE,Menu.NONE, "delete")
                    .setIcon(miui.R.drawable.action_button_delete_light)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

            mSelectAll = true;
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        //CODE-BEGIN EditActionModeOnActionItemClicked
        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            String text;
            if (menuItem.getItemId() == android.R.id.button1) //cancel
            {
                actionMode.finish();
                text = "Finish Edit Mode";
            }
            else if(menuItem.getItemId() == android.R.id.button2) //select/unselect all
            {
                mSelectAll = !mSelectAll;
                text = mSelectAll ? "UnSelect All" : "Select All";
                ((EditActionMode)actionMode).setButton(android.R.id.button2,
                        mSelectAll ? com.miui.internal.R.string.select_all:
                                com.miui.internal.R.string.deselect_all);
            }
            else {
                text = (String)menuItem.getTitle();
            }
            Toast.makeText(EditActionModeDemo.this, text, Toast.LENGTH_SHORT).show();
            return true;
        }
        //CODE-END EditActionModeOnActionItemClicked

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            mEditActionMode = null;
        }
    }
    //CODE-END EditActionModeActionModeCallback


    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);

        mList = getControlList();

        mList.addItem("Edit ActionMode Callback",
                null,
                CodeStyles.EditActionModeActionModeCallback,
                null, //style
                null);

        mList.addItem("Select All/Cancel Item onClicked",
                null,
                CodeStyles.EditActionModeOnActionItemClicked,
                null, //style
                null);
        mList.addItem("Start Edit ActionMode",
                null,
                CodeStyles.EditActionModeStartActionMode,
                null, //style
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN EditActionModeStartActionMode
                        if (mEditActionMode == null) {
                            startActionMode(new ActionModeCallback());
                        }
                        //CODE-END EditActionModeStartActionMode
                    }
                });
        mList.addItem("Finish Edit ActionMode",
                null,
                CodeStyles.EditActionModeEndActionMode,
                null, //style
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN EditActionModeEndActionMode
                        if (mEditActionMode != null) {
                            mEditActionMode.finish();
                        }
                        //CODE-END EditActionModeEndActionMode
                    }
                });

        mList.addItem("Set Edit ActionMode Title",
                null,
                CodeStyles.EditActionModeSetTitle,
                null, //style
                new Runnable() {
                    @Override
                    public void run() {
                        //CODE-BEGIN EditActionModeSetTitle
                        if (mEditActionMode != null) {
                            mEditActionMode.setTitle("Edit Mode Title:" + mCount);
                            mEditActionMode.setSubtitle("subtitle:" + mCount ++);
                        }
                        //CODE-END EditActionModeSetTitle
                    }
                });

        mList.addItem("Action Mode Theme",
                null,
                null,
                CodeStyles.ActionBarActionModeTheme,
                null);
        mList.addItem("Action Mode ActionBar Style",
                null,
                null,
                CodeStyles.ActionBarActionModeStyle,
                null);
        mList.addItem("Action Mode ActionButton Style",
                null,
                null,
                CodeStyles.ActionBarActionModeActionButtonStyle,
                null);
        mList.addItem("Action Mode Cancel Button Style",
                null,
                null,
                CodeStyles.ActionBarActionButtonStyle,
                null);
        mList.addItem("Action Mode Select/OK Button Style",
                null,
                null,
                CodeStyles.ActionBarActionModeDefultButtonStyle,
                null);
    }

}
