/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.autocomplete;

import com.example.miui.R;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.widget.AutoCompleteTextView;

import miui.app.Activity;

public class AutoComplete5 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.autocomplete_5);

        ContentResolver content = getContentResolver();
        Cursor cursor = content.query(Contacts.CONTENT_URI,
                AutoComplete4.CONTACT_PROJECTION, null, null, null);
        AutoComplete4.ContactListAdapter adapter =
                new AutoComplete4.ContactListAdapter(this, cursor);

        AutoCompleteTextView textView = (AutoCompleteTextView)
                findViewById(R.id.edit);
        textView.setAdapter(adapter);
    }
}