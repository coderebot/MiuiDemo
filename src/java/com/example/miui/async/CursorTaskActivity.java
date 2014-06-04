/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.async;

import miui.app.ListActivity;
import miui.util.async.TaskManager;
import miui.util.async.tasks.CursorTask;
import miui.util.async.tasks.listeners.ProgressDialogListener;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miui.R;

public class CursorTaskActivity extends ListActivity {

    static final String[] CONTACTS_SUMMARY_PROJECTION = new String[] {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.CONTACT_PRESENCE,
            ContactsContract.Contacts.PHOTO_ID,
            ContactsContract.Contacts.LOOKUP_KEY,
    };

    TaskManager mTaskManager = new TaskManager();
    CursorTask.Cookie mCursorTaskCookie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listView = getListView();
        final CursorAdapter cursorAdapter = new CursorAdapter(this, null, 0) {
            @Override
            public View newView(Context context, Cursor cursor, ViewGroup parent) {
                return getLayoutInflater().inflate(R.layout.simple_list_item_1, null);
            }

            @Override
            public void bindView(View view, Context context, Cursor cursor) {
                ((TextView) view).setText(cursor.getString(1));
            }
        };
        listView.setAdapter(cursorAdapter);

        CursorTask ct = new CursorTask(ContactsContract.Contacts.CONTENT_URI,
                CONTACTS_SUMMARY_PROJECTION,
                "((" + ContactsContract.Contacts.DISPLAY_NAME + " NOTNULL) AND ("
                        + ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1) AND (" + ContactsContract.Contacts.DISPLAY_NAME + " != '' ))",
                null,
                ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC") {
            @Override
            public Cursor doLoad() throws Exception {
                return query();
            }

            @Override
            public void onResult(TaskManager tm, Cursor result) {
                super.onResult(tm, result);
                cursorAdapter.changeCursor(result);
            }
        };
        ct.addListener(new ProgressDialogListener(getFragmentManager()));
        mCursorTaskCookie = ct.enableAutoRequery();
        mTaskManager.add(ct);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mCursorTaskCookie.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCursorTaskCookie.resume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTaskManager.shutdown();
        if (mCursorTaskCookie != null) {
            mCursorTaskCookie.release();
        }
    }
}
