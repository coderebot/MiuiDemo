/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.autocomplete;

import com.example.miui.R;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CursorAdapter;
import android.widget.FilterQueryProvider;
import android.widget.Filterable;
import android.widget.TextView;

import miui.app.Activity;

public class AutoComplete4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_4);

        ContentResolver content = getContentResolver();
        Cursor cursor = content.query(Contacts.CONTENT_URI,
                CONTACT_PROJECTION, null, null, null);

        ContactListAdapter adapter = new ContactListAdapter(this, cursor);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.edit);
        textView.setAdapter(adapter);
    }

    // XXX compiler bug in javac 1.5.0_07-164, we need to implement Filterable
    // to make compilation work
    public static class ContactListAdapter extends CursorAdapter implements Filterable {
        public ContactListAdapter(Context context, Cursor c) {
            super(context, c);
            mContent = context.getContentResolver();
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            final LayoutInflater inflater = LayoutInflater.from(context);
            final TextView view = (TextView) inflater.inflate(
                    android.R.layout.simple_dropdown_item_1line, parent, false);
            view.setText(cursor.getString(COLUMN_DISPLAY_NAME));
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            ((TextView) view).setText(cursor.getString(COLUMN_DISPLAY_NAME));
        }

        @Override
        public String convertToString(Cursor cursor) {
            return cursor.getString(COLUMN_DISPLAY_NAME);
        }

        @Override
        public Cursor runQueryOnBackgroundThread(CharSequence constraint) {
            FilterQueryProvider filter = getFilterQueryProvider();
            if (filter != null) {
                return filter.runQuery(constraint);
            }

            Uri uri = Uri.withAppendedPath(
                    Contacts.CONTENT_FILTER_URI,
                    Uri.encode(constraint.toString()));
            return mContent.query(uri, CONTACT_PROJECTION, null, null, null);
        }

        private ContentResolver mContent;
    }

    public static final String[] CONTACT_PROJECTION = new String[] {
        Contacts._ID,
        Contacts.DISPLAY_NAME
    };

    private static final int COLUMN_DISPLAY_NAME = 1;
}