/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar.fragment;

import miui.app.ListFragment;
import miui.view.SearchActionMode;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import com.example.miui.R;

public class SearchFragment extends ListFragment
        implements LoaderManager.LoaderCallbacks<Cursor> {

    private SimpleCursorAdapter mAdapter;

    private View mAnchorView;

    // These are the Contacts rows that we will retrieve.
    static final String[] CONTACTS_SUMMARY_PROJECTION = new String[] {
            ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.CONTACT_PRESENCE,
            ContactsContract.Contacts.PHOTO_ID,
            ContactsContract.Contacts.LOOKUP_KEY,
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setThemeRes(R.style.Theme);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setEmptyText("No phone numbers");
        setHasOptionsMenu(true);

        // Create an empty adapter we will use to display the loaded data.
        mAdapter = new SimpleCursorAdapter(getActivity(), android.R.layout.simple_list_item_1,
                null, new String[] {
                ContactsContract.Contacts.DISPLAY_NAME
        }, new int[] {
                android.R.id.text1
        }, 0);

        // Prepare the loader. Either re-connect with an existing one,
        // or start a new one.
        getLoaderManager().initLoader(0, null, this);

        mAnchorView = getActivity().getLayoutInflater()
                .inflate(miui.R.layout.search_stub, null);
        getListView().addHeaderView(mAnchorView);

        mAnchorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActionMode(mSearchCallback);
            }
        });

        setListAdapter(mAdapter);

        // Start out with a progress indicator.
        setListShown(false);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Uri baseUri = ContactsContract.Contacts.CONTENT_URI;

        // Now create and return a CursorLoader that will take care of
        // creating a Cursor for the data being displayed.
        String select = "((" + ContactsContract.Contacts.DISPLAY_NAME + " NOTNULL) AND ("
                + ContactsContract.Contacts.HAS_PHONE_NUMBER + "=1) AND (" + ContactsContract.Contacts.DISPLAY_NAME + " != '' ))";
        return new CursorLoader(getActivity(), baseUri, CONTACTS_SUMMARY_PROJECTION, select, null,
                ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.searchview, menu);
        return true;
    }

    private SearchActionMode.Callback mSearchCallback = new SearchActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode,
                Menu menu) {
            SearchActionMode searchActionMode = (SearchActionMode) actionMode;
            searchActionMode.setAnchorView(mAnchorView);
            searchActionMode.setAnimateView(getListView());
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode,
                Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode,
                MenuItem menuItem) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_search:
                startActionMode(mSearchCallback);
                return true;
            case R.id.action_toggle_actionbar:
                if (getActionBar().isShowing()) {
                    getActionBar().hide();
                } else {
                    getActionBar().show();
                }
                return true;
            case R.id.action_change_display_mode:

                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
        if (isResumed()) {
            setListShown(true);
        } else {
            setListShownNoAnimation(true);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }
}
