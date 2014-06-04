/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app.actionbar;

import miui.app.ActionBar;
import miui.app.Activity;

import android.app.Fragment;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.common.DemoControlList;
import com.example.miui.CodeStyles;
import com.example.miui.R;

public class ActionBarTabs extends Activity {

    //CODE-BEGIN AddFragmentTab
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ActionBar bar = getActionBar();
        //1. set FragementViewPageMode
        bar.setFragmentViewPagerMode(this, getFragmentManager());

        //2. add fragments

        // Last parameter is "false" : No Action Menu
        bar.addFragmentTab("0", bar.newTab().setText("List"), ArrayListFragment.class, null, false);

        // Use Bunndle to pass the parameters
        Bundle bundle = new Bundle();
        bundle.putInt("count", 0);
        // Last parameter is "ture" : Has Action Menu
        bar.addFragmentTab("1", bar.newTab().setText("Cursor#1"), CursorFragment.class, bundle, true);

        bundle = new Bundle();
        bundle.putInt("count", 1);
        bar.addFragmentTab("2", bar.newTab().setText("Cursor#2"), CursorFragment.class, bundle, true);

        bar.addFragmentTab("3", bar.newTab().setText("Simple"), SimpleFragment.class, null, false);

        bar.addFragmentTab("4", bar.newTab().setText("Source"), SourceFragment.class, null, true);

    }
    //CODE-END AddFragmentTab

    //CODE-BEGIN FragementActionMenuSelectedInActivity
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return false;
    }
    //CODE-END FragementActionMenuSelectedInActivity

    public static class SimpleFragment extends Fragment {

        //CODE-BEGIN SimpleFragementOnAttach
        @Override
        public void onAttach(android.app.Activity activity) {
            super.onAttach(activity);
            Log.v("SimpleFragment", "Fragment.onAttach()");
        }
        //CODE-END SimpleFragementOnAttach

        //CODE-BEGIN SimpleFragmentOnCreate
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Log.v("SimpleFragment", "Fragment.onCreate()");
            // Has OptionsMenu Even set false when addFragementTab
            setHasOptionsMenu(true);
        }
        //CODE-END SimpleFragmentOnCreate

        //CODE-BEGIN SimpleFragmentOnCreateView
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            Log.v("SimpleFragment", "Fragment.onCreateView()");
            TextView v = new TextView(inflater.getContext());
            v.setGravity(Gravity.CENTER);
            v.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            v.setText("Hello, world!");
            return v;
        }
        //CODE-END SimpleFragmentOnCreateView

        //CODE-BEGIN SimpleFragmentOnActivityCreated
        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.v("SimpleFragment", "Fragment.onActivityCreated()");
        }
        //CODE-END SimpleFragmentOnActivityCreated

        @Override
        public void onStart() {
            super.onStart();
            Log.v("SimpleFragment", "Fragment.onStart()");
        }

        @Override
        public void onResume() {
            super.onResume();
            Log.v("SimpleFragment", "Fragment.onResume()");
        }

        @Override
        public void onPause() {
            super.onPause();
            Log.v("SimpleFragment", "Fragment.onPause()");
        }

        @Override
        public void onStop() {
            super.onStop();
            Log.v("SimpleFragment", "Fragment.onStop()");
        }

        //CODE-BEGIN SimpleFragmentOnDestroyView
        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Log.v("SimpleFragment", "Fragment.onDestroyView()");
        }
        //CODE-END SimpleFragmentOnDestroyView

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.v("SimpleFragment", "Fragment.onDestroy()");
        }

        //CODE-BEGIN SimpleFragmentOnDetach
        @Override
        public void onDetach() {
            super.onDetach();
            Log.v("SimpleFragment", "Fragment.onDetach()");
        }
        //CODE-END SimpleFragmentOnDetach

        //CODE-BEGIN SimpleFragmentOnCreateOptionsMenu
        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            menu.add(Menu.NONE, android.R.id.edit, 0, "Replace");
        }
        //CODE-END SimpleFragmentOnCreateOptionsMenu

        //CODE-BEGIN SimpleFragmentOnOptionsItemSelected
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.edit) {
                final ActionBar bar = ((Activity) getActivity()).getActionBar();
                //replace current fragment
                bar.removeFragmentTabAt(3);
                bar.addFragmentTab("3", bar.newTab().setText("List2"), ArrayListFragment.class, null, false);
                bar.selectTab(bar.getTabAt(3));
                return true;
            }
            return false;
        }
        //CODE-END SimpleFragmentOnOptionsItemSelected
    }

    public static class ArrayListFragment extends ListFragment {
        static String[] ITEMS = {"Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG", "Xiaomi", "iPhone", "Samsung", "HTC", "Moto", "LG"};

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            //set list adapter in onActivityCreated
            setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.simple_list_item_1, ITEMS));
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            Toast.makeText(getActivity(), ITEMS[(int) id] + " clicked", Toast.LENGTH_SHORT).show();
        }
    }

    public static class CursorFragment extends ListFragment
            implements LoaderManager.LoaderCallbacks<Cursor> {

        // This is the Adapter being used to display the list's data.
        SimpleCursorAdapter mAdapter;

        // If non-null, this is the current filter the user has provided.
        String mCurFilter;

        int mCount;

        MenuItem mActionItem;

        //CODE-BEGIN CursorFragmentOnCreate
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //Get Parameter in onCreate or onActivityCreated
            mCount = getArguments().getInt("count", 0);
        }
        //CODE-END CursorFragmentOnCreate

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            // Give some text to display if there is no data. In a real
            // application this would come from a resource.
            setEmptyText("No phone numbers");

            // We have a menu item to show in action bar.
            setHasOptionsMenu(true);

            // Create an empty adapter we will use to display the loaded data.
            mAdapter = new SimpleCursorAdapter(getActivity(), R.layout.simple_list_item_1,
                    null, new String[] {
                    Contacts.DISPLAY_NAME
            }, new int[] {
                    android.R.id.text1
            }, 0);
            setListAdapter(mAdapter);

            // Start out with a progress indicator.
            setListShown(false);

            // Prepare the loader. Either re-connect with an existing one,
            // or start a new one.
            getLoaderManager().initLoader(0, null, this);
        }

        @Override
        public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
            // Place an action bar item for searching.
            MenuItem item = mCount == 0 ? menu.add(Menu.NONE, android.R.id.button1, Menu.NONE, "Hide Action Menu") :
                    menu.add("Add");
            item.setIcon(mCount == 0 ? miui.R.drawable.action_button_search_light :
                    miui.R.drawable.action_button_new_light);
            //CODE-BEGIN MenuItemShowAsAction
            item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);
            //CODE-END MenuItemShowAsAction
            if (mCount == 1) {
                menu.add(Menu.NONE, android.R.id.button2, Menu.NONE, "Show Cursor#1 Action Menu ");
            }
            mActionItem = item;
        }

        //CODE-BEGIN CursorFragmentOnOptionsItemSelected
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            //Show/Hide Special Fragment the Action Menu
            if (item.getItemId() == android.R.id.button1) {
                //same as ((Activity)getActivity()).getActionBar().getFragmentAt(1).setHasOptionsMenu(false);
                ((Activity)getActivity()).getActionBar().setFragmentActionMenuAt(1, false);
            } else if (item.getItemId() == android.R.id.button2) {
                ((Activity)getActivity()).getActionBar().setFragmentActionMenuAt(1, true);
            }
            return false;
        }
        //CODE-END CursorFragmentOnOptionsItemSelected


        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            // Insert desired behavior here.
            Toast.makeText(getActivity(), "Item clicked: " + id, Toast.LENGTH_SHORT).show();
        }

        // These are the Contacts rows that we will retrieve.
        static final String[] CONTACTS_SUMMARY_PROJECTION = new String[] {
                Contacts._ID, Contacts.DISPLAY_NAME, Contacts.CONTACT_STATUS,
                Contacts.CONTACT_PRESENCE, Contacts.PHOTO_ID, Contacts.LOOKUP_KEY,
        };

        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            // This is called when a new Loader needs to be created. This
            // sample only has one Loader, so we don't care about the ID.
            // First, pick the base URI to use depending on whether we are
            // currently filtering.
            Uri baseUri;
            if (mCurFilter != null) {
                baseUri = Uri.withAppendedPath(Contacts.CONTENT_FILTER_URI, Uri.encode(mCurFilter));
            } else {
                baseUri = Contacts.CONTENT_URI;
            }

            // Now create and return a CursorLoader that will take care of
            // creating a Cursor for the data being displayed.
            String select = "((" + Contacts.DISPLAY_NAME + " NOTNULL) AND ("
                    + Contacts.HAS_PHONE_NUMBER + "=1) AND (" + Contacts.DISPLAY_NAME + " != '' ))";
            return new CursorLoader(getActivity(), baseUri, CONTACTS_SUMMARY_PROJECTION, select, null,
                    Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC");
        }

        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            // Swap the new cursor in. (The framework will take care of closing the
            // old cursor once we return.)
            mAdapter.swapCursor(data);

            // The list should now be shown.
            if (isResumed()) {
                setListShown(true);
            } else {
                setListShownNoAnimation(true);
            }
        }

        public void onLoaderReset(Loader<Cursor> loader) {
            // This is called when the last Cursor provided to onLoadFinished()
            // above is about to be closed. We need to make sure we are no
            // longer using it.
            mAdapter.swapCursor(null);
        }
    }

    public static class SourceFragment extends Fragment {
        DemoControlList mList;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            mList = new DemoControlList(getActivity(), null);
            mList.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
            return mList;
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            mList.addItem("Add Fragement Tab",
                          "Called In onCreate",
                          CodeStyles.AddFragmentTab,
                          null, null);

            mList.addItem("Get Option Selected Event In Activity",
                    "When Action Menu Clicked In Fragment, Always",
                    CodeStyles.FragementActionMenuSelectedInActivity,
                    null, null);

            mList.addItem("Fragment Callback: onAttach",
                    null,
                    CodeStyles.SimpleFragementOnAttach,
                    null, null);
            mList.addItem("Fragment Callback: onActivityCreated",
                    null,
                    CodeStyles.SimpleFragmentOnActivityCreated,
                    null, null);
            mList.addItem("Fragment Callback: onCreate",
                    null,
                    CodeStyles.SimpleFragmentOnCreate,
                    null, null);
            mList.addItem("Fragment Callback: onCreateOptionsMenu",
                    null,
                    CodeStyles.SimpleFragmentOnCreateOptionsMenu,
                    null, null);
            mList.addItem("Fragment Callback: onActivityCreated",
                    null,
                    CodeStyles.SimpleFragmentOnActivityCreated,
                    null, null);
            mList.addItem("Fragment Callback: onCreateView",
                    null,
                    CodeStyles.SimpleFragmentOnCreateView,
                    null, null);
            mList.addItem("Fragment Callback: onDestroyView",
                    null,
                    CodeStyles.SimpleFragmentOnDestroyView,
                    null, null);
            mList.addItem("Fragment Callback: onDetach",
                    null,
                    CodeStyles.SimpleFragmentOnDetach,
                    null, null);
            mList.addItem("Fragment Callback: onOptionsItemSelected",
                    null,
                    CodeStyles.SimpleFragmentOnOptionsItemSelected,
                    null, null);

            mList.addItem("Process the parameter from Bundle",
                    "Called In onCreate or onActivityCreated",
                    CodeStyles.CursorFragmentOnCreate,
                    null, null);

            mList.addItem("Set any fragment has OptionsMenu",
                    null,
                    CodeStyles.CursorFragmentOnOptionsItemSelected,
                    null, null);
        }
    }
}
