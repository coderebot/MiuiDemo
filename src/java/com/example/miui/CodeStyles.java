
/**
 * This file is auto generated, don't edit
 */

package com.example.miui;

public class CodeStyles {

    public static final String DialogMultiChoice =
        "final boolean[] checkedItems = {true, true, false};\n"
        + "AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_LIGHT_EDIT);\n"
        + "builder.setTitle(\"Multi Choice\")\n"
        + "        .setMultiChoiceItems(R.array.entryvalues_list_preference, checkedItems,\n"
        + "                mOnMultiChoiceClickListener)\n"
        + "        .setPositiveButton(\"Positive\", mDialogOnClickListener)\n"
        + "        .setNegativeButton(\"Negative\", mDialogOnClickListener);\n"
        + "dialog = builder.create();\n"
    ;

    public static final String CursorFragmentOnOptionsItemSelected =
        "@Override\n"
        + "public boolean onOptionsItemSelected(MenuItem item) {\n"
        + "    //Show/Hide Special Fragment the Action Menu\n"
        + "    if (item.getItemId() == android.R.id.button1) {\n"
        + "        //same as ((Activity)getActivity()).getActionBar().getFragmentAt(1).setHasOptionsMenu(false);\n"
        + "        ((Activity)getActivity()).getActionBar().setFragmentActionMenuAt(1, false);\n"
        + "    } else if (item.getItemId() == android.R.id.button2) {\n"
        + "        ((Activity)getActivity()).getActionBar().setFragmentActionMenuAt(1, true);\n"
        + "    }\n"
        + "    return false;\n"
        + "}\n"
    ;

    public static final String ActionBarTranslucentStatus =
        "<item name=\"*miui:windowTranslucentStatus\">transparentDark</item>\n"
    ;

    public static final String DialogProgress =
        "ProgressDialog progressDialog = new ProgressDialog(this, R.style.AlertDialog_Progress);\n"
        + "progressDialog.setMessage(\"progressing...\");\n"
        + "progressDialog.setIndeterminate(true);\n"
        + "dialog = progressDialog;\n"
    ;

    public static final String SimpleFragmentOnDestroyView =
        "@Override\n"
        + "public void onDestroyView() {\n"
        + "    super.onDestroyView();\n"
        + "    Log.v(\"SimpleFragment\", \"Fragment.onDestroyView()\");\n"
        + "}\n"
    ;

    public static final String ActionBarMovableLayoutScrollListenerMethods =
        "@Override\n"
        + "public boolean onContentScrolled() {\n"
        + "    Log.i(TAG, \"onContentScrolled\");\n"
        + "    return false;\n"
        + "}\n"
        + "\n"
        + "@Override\n"
        + "public void onStartScroll() {\n"
        + "    Log.i(TAG, \"onStartScroll\");\n"
        + "}\n"
        + "\n"
        + "@Override\n"
        + "public void onStopScroll() {\n"
        + "    Log.i(TAG, \"onStopScroll\");\n"
        + "}\n"
        + "\n"
        + "@Override\n"
        + "public void onScroll(int state, float offset) {\n"
        + "    Log.i(TAG, \"onScroll\");\n"
        + "}\n"
        + "\n"
        + "@Override\n"
        + "public void onFling(float distance, int duration) {\n"
        + "    Log.i(TAG, \"onFling\");\n"
        + "}\n"
    ;

    public static final String ActionBarSplitStyle =
        "<style name=\"actionbar_split\" parent=\"miui:Widget.ActionBar.Split\">\n"
        + "    <item name=\"android:height\">80dp</item>\n"
        + "    <!--MUST SET TO @null, Otherwise, in phone, it will cover the content area -->\n"
        + "    <item name=\"android:backgroundSplit\">@null</item>\n"
        + "</style>\n"
    ;

    public static final String FragementActionMenuSelectedInActivity =
        "@Override\n"
        + "public boolean onOptionsItemSelected(MenuItem item) {\n"
        + "    Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();\n"
        + "    return false;\n"
        + "}\n"
    ;

    public static final String ActionBarActionOverflowButtonStyle =
        "<style name=\"actionbar_action_button_more\" parent=\"miui:Widget.ActionButton.Overflow\">\n"
        + "    <item name=\"android:textColor\">#ff880088</item>\n"
        + "    <item name=\"android:textSize\">15sp</item>\n"
        + "</style>\n"
    ;

    public static final String AlertDialogProgressHorizontalTheme =
        "<style name=\"AlertDialog.ProgressHorizontal\">\n"
        + "    <item name=\"android:progressBarStyleHorizontal\">@style/dialog_progressbar_horizontal</item>\n"
        + "</style>\n"
    ;

    public static final String DISPLAY_HOME_AS_UP =
        "getActionBar().setDisplayHomeAsUpEnabled(b);\n"
        + "//actionBar.setDisplayOptions(b ? ActionBar.DISPLAY_HOME_AS_UP: 0, ActionBar.DISPLAY_HOME_AS_UP);\n"
    ;

    public static final String AlertDialogSimpleWithoutTitleTheme =
        "<style name=\"AlertDialog.WithoutTitle\">\n"
        + "    <item name=\"android:buttonBarButtonStyle\">@style/dialog_buttonbar_button</item>\n"
        + "    <item name=\"*miui:buttonBarDefaultButtonStyle\">@style/dialog_buttonbar_button_default</item>\n"
        + "</style>\n"
    ;

    public static final String SimpleFragmentOnCreateOptionsMenu =
        "@Override\n"
        + "public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {\n"
        + "    menu.add(Menu.NONE, android.R.id.edit, 0, \"Replace\");\n"
        + "}\n"
    ;

    public static final String AlertDialogListItemTheme =
        "<style name=\"AlertDialog.ListItem\">\n"
        + "    <item name=\"android:listDividerAlertDialog\">@drawable/btn_bg_light_single_h_middle_v_pressed</item>\n"
        + "</style>\n"
    ;

    public static final String ShowHideSplitActionBar =
        "getActionBar().showSplitActionBar(show, true);\n"
        + "show = !show;\n"
    ;

    public static final String ActionBarSearchActionModeTextStyle =
        "<style name=\"actionbar_search_text\" parent=\"miui:Widget.EditText.Search\">\n"
        + "    <item name=\"android:textColor\">#ffff5533</item>\n"
        + "    <item name=\"android:textSize\">20sp</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarTabBarStyle =
        "<style name=\"actionbar_tabbar\">\n"
        + "    <item name=\"android:background\">#ffdfffc3</item>\n"
        + "    <item name=\"android:height\">70dip</item>\n"
        + "</style>\n"
    ;

    public static final String EditActionModeEndActionMode =
        "if (mEditActionMode != null) {\n"
        + "    mEditActionMode.finish();\n"
        + "}\n"
    ;

    public static final String ActionBarMovableTheme =
        "<style name=\"ActionBar.Movable\" parent=\"miui:Theme.Light.ActionBarMovable\">\n"
        + "    <item name=\"android:actionBarStyle\">@style/ActionBarStyle.Movable</item>\n"
        + "    <item name=\"miui:actionBarMovableLayoutStyle\">@style/ActionBarMovableLayout</item>\n"
        + "</style>\n"
    ;

    public static final String AddActionButton =
        "mMenu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())\n"
        + "        .setIcon(AttributeResolver.resolve(ActionBarSplitBarDemo.this, miui.R.attr.actionBarEditIcon))\n"
        + "        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
    ;

    public static final String DialogDatePicker =
        "Calendar c = new Calendar();\n"
        + "DatePickerDialog d = new DatePickerDialog(this, R.style.AlertDialog_DatePicker,\n"
        + "        null, c.get(Calendar.YEAR), c.get(Calendar.MONTH),\n"
        + "        c.get(Calendar.DAY_OF_MONTH));\n"
        + "d.show();\n"
    ;

    public static final String ActionBarSearchActionModeTextWatcher =
        "private TextWatcher mSearchTextWatcher = new TextWatcher() {\n"
        + "    public void beforeTextChanged(CharSequence s, int start, int count, int after) {\n"
        + "    }\n"
        + "    public void onTextChanged(CharSequence s, int start, int before, int count) {\n"
        + "        String newText = null;\n"
        + "        if (s != null) {\n"
        + "            newText = s.toString();\n"
        + "        }\n"
        + "        // show or hide search fragment\n"
        + "        if (TextUtils.isEmpty(newText)) {\n"
        + "            if (mSearchResultView.getVisibility() != View.VISIBLE) {\n"
        + "                mSearchResultView.setVisibility(View.GONE);\n"
        + "            }\n"
        + "        } else {\n"
        + "            mSearchResultView.setVisibility(View.VISIBLE);\n"
        + "            mSearchItemFilter.query(newText);\n"
        + "        }\n"
        + "    }\n"
        + "    public void afterTextChanged(Editable s) {\n"
        + "    }\n"
        + "};\n"
    ;

    public static final String DialogContentStyle =
        "<style name=\"dialog_content\" parent=\"miui:TextAppearance.Medium\">\n"
        + "    <item name=\"android:textSize\">22sp</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarSearchActionModeTheme =
        "<style name=\"ActionBar.SearchActionMode\">\n"
        + "    <item name=\"*miui:editTextSearchStyle\">@style/actionbar_search_text</item>\n"
        + "    <!-- action mode background and cancel button style cannot be changed -->\n"
        + "</style>\n"
    ;

    public static final String ActionBarMovableLayoutImplementsSetOnScrollListener =
        "public class ActionBarMovableLayoutDemo extends Activity implements ActionBarMovableLayout.OnScrollListener {\n"
    ;

    public static final String ActionBarPopupMenuShortcurTextStyle =
        "<style name=\"actionbar_popupmenu_shortcuttext\" parent=\"miui:TextAppearance.Widget.PopupMenu.Small\">\n"
        + "    <item name=\"android:textColor\">#ff888888</item>\n"
        + "</style>\n"
    ;

    public static final String SetActionButtonTitle =
        "MenuItem item = mMenu.findItem(R.id.set_action_button_title);\n"
        + "String title = (String) item.getTitle();\n"
        + "item.setTitle(mSetTitle ? title.toLowerCase() : title.toUpperCase());\n"
        + "mSetTitle = !mSetTitle;\n"
    ;

    public static final String DialogSimpleWithoutTitle =
        "AlertDialog.Builder builder = new AlertDialog.Builder(this,\n"
        + "        R.style.AlertDialog_WithoutTitle);\n"
        + "builder.setMessage(\"Message\")\n"
        + "        .setPositiveButton(\"Positive\", mDialogOnClickListener)\n"
        + "        .setNegativeButton(\"Negative\", mDialogOnClickListener);\n"
        + "dialog = builder.create();\n"
    ;

    public static final String ActionBarSearchActionModeResultView =
        "private DemoControlList getSearchResultView() {\n"
        + "    if (mSearchResultView == null) {\n"
        + "        mSearchResultView = new DemoControlList(this, null);\n"
        + "        mSearchResultView.setBackgroundColor(0xffffccff);\n"
        + "        ViewGroup vg = (ViewGroup)findViewById(android.R.id.content);\n"
        + "        vg.addView(mSearchResultView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,\n"
        + "                ViewGroup.LayoutParams.MATCH_PARENT));\n"
        + "\n"
        + "        initSearchResultView();\n"
        + "    }\n"
        + "    return mSearchResultView;\n"
        + "}\n"
    ;

    public static final String ActionBarTitleTheme =
        "<style name=\"ActionBar.Title\">\n"
        + "    <item name=\"android:actionBarStyle\">@style/actionbar_title</item>\n"
        + "    <!-- set the actionbar height -->\n"
        + "    <item name=\"android:actionBarSize\">80dip</item>\n"
        + "    <!-- set the home up -->\n"
        + "    <item name=\"android:homeAsUpIndicator\">@drawable/bar_back</item>\n"
        + "    <!-- set the status bar transparent dark -->\n"
        + "    <item name=\"*miui:windowTranslucentStatus\">transparentDark</item>\n"
        + "    <item name=\"miui:contentAutoFitSystemWindow\">true</item>\n"
        + "    <item name=\"miui:customViewAutoFitSystemWindow\">true</item>\n"
        + "</style>\n"
    ;

    public static final String DialogSimple =
        "AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog_Simple);\n"
        + "builder.setTitle(\"Title\")\n"
        + "        .setMessage(\"Message\")\n"
        + "        .setPositiveButton(\"Positive\", mDialogOnClickListener)\n"
        + "        .setNeutralButton(\"Neutral\", mDialogOnClickListener)\n"
        + "        .setNegativeButton(\"Negative\", mDialogOnClickListener);\n"
        + "dialog = builder.create();\n"
    ;

    public static final String MenuItemShowAsAction =
        "item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW);\n"
    ;

    public static final String DISPLAY_USE_LOGO =
        "getActionBar().setDisplayUseLogoEnabled(b);\n"
        + "//getActionBar().setDisplayOptions(b ? ActionBar.DISPLAY_USE_LOGO: 0, ActionBar.DISPLAY_USE_LOGO);\n"
        + "getActionBar().setLogo(R.drawable.ic_logo);\n"
    ;

    public static final String DialogProgressBarStyle =
        "    <style name=\"dialog_progressbar\" parent=\"miui:Widget.ProgressBar\">\n"
        + "   <item name=\"android:minWidth\">56dp</item>\n"
        + "   <item name=\"android:maxWidth\">56dp</item>\n"
        + "   <item name=\"android:minHeight\">56dp</item>\n"
        + "   <item name=\"android:maxHeight\">56dp</item>\n"
        + "    </style>\n"
    ;

    public static final String DialogSingleChoice =
        "AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog_SingleChoice);\n"
        + "builder.setTitle(\"Single Choice\")\n"
        + "       .setPositiveButton(\"Positive\", mDialogOnClickListener)\n"
        + "       .setSingleChoiceItems(R.array.entryvalues_list_preference, 0, mOnSingleChoiceListener);\n"
        + "dialog = builder.create();\n"
    ;

    public static final String AlertDialogTimePickerTheme =
        "<style name=\"AlertDialog.TimePicker\" parent=\"miui:Theme.Light.Dialog\">\n"
        + "    <item name=\"android:windowBackground\">@drawable/movable_bg</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarActionModeActionButtonStyle =
        "<style name=\"actionbar_actionmode_actionbutton\" parent=\"miui:Widget.ActionMode.ActionButton\">\n"
        + "    <item name=\"android:textColor\">#ff881b14</item>\n"
        + "    <item name=\"android:textSize\">14sp</item>\n"
        + "</style>\n"
        + "<style name=\"actionbar_search_text\" parent=\"miui:Widget.EditText.Search\">\n"
        + "    <item name=\"android:textColor\">#ffff5533</item>\n"
        + "    <item name=\"android:textSize\">20sp</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_title\" parent=\"*miui:Widget.DialogTitle\">\n"
        + "    <item name=\"android:textSize\">26sp</item>\n"
        + "    <item name=\"android:textColor\">#ffff0000</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_content\" parent=\"miui:TextAppearance.Medium\">\n"
        + "    <item name=\"android:textSize\">22sp</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_buttonbar_button\" parent=\"miui:Widget.Button.Dialog\">\n"
        + "    <item name=\"android:textStyle\">italic</item>\n"
        + "    <item name=\"android:textColor\">@android:color/holo_green_light</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_buttonbar_button_default\" parent=\"miui:Widget.Button.Dialog.Default\">\n"
        + "    <item name=\"android:textStyle\">italic</item>\n"
        + "    <item name=\"android:textColor\">@android:color/holo_green_light</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_progressbar\" parent=\"miui:Widget.ProgressBar\">\n"
        + "    <item name=\"android:minWidth\">56dp</item>\n"
        + "    <item name=\"android:maxWidth\">56dp</item>\n"
        + "    <item name=\"android:minHeight\">56dp</item>\n"
        + "    <item name=\"android:maxHeight\">56dp</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_progressbar_horizontal\" parent=\"miui:Widget.ProgressBar.Horizontal\">\n"
        + "    <item name=\"android:background\">#ff00ff00</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_custom_title\" parent=\"*miui:Widget.DialogTitle\">\n"
        + "    <item name=\"android:textSize\">24sp</item>\n"
        + "    <item name=\"android:textColor\">#fffb6003</item>\n"
        + "</style>\n"
        + "\n"
        + "<style name=\"dialog_date_picker_title\" parent=\"*miui:Widget.DialogTitle\">\n"
        + "    <item name=\"android:textSize\">28sp</item>\n"
        + "</style>\n"
        + "\n"
        + "</resources>\n"
    ;

    public static final String ActionBarTabListener =
        "/**\n"
        + " * A TabListener receives event callbacks from the action bar as tabs are\n"
        + " * deselected, selected, and reselected. A FragmentTransaction is provided\n"
        + " * to each of these callbacks; if any operations are added to it, it will be\n"
        + " * committed at the end of the full tab switch operation. This lets tab\n"
        + " * switches be atomic without the app needing to track the interactions\n"
        + " * between different tabs. NOTE: This is a very simple implementation that\n"
        + " * does not retain fragment state of the non-visible tabs across activity\n"
        + " * instances. Look at the FragmentTabs example for how to do a more complete\n"
        + " * implementation.\n"
        + " */\n"
        + "private class TabListener implements android.app.ActionBar.TabListener {\n"
        + "\n"
        + "    public void onTabSelected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {\n"
        + "        Toast.makeText(ActionBarTabDemo.this, \"TabSelected:\" + tab.getText(), Toast.LENGTH_SHORT).show();\n"
        + "    }\n"
        + "\n"
        + "    public void onTabUnselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {\n"
        + "        Toast.makeText(ActionBarTabDemo.this, \"TabUnselected:\" + tab.getText(), Toast.LENGTH_SHORT).show();\n"
        + "    }\n"
        + "\n"
        + "    public void onTabReselected(android.app.ActionBar.Tab tab, FragmentTransaction ft) {\n"
        + "        Toast.makeText(ActionBarTabDemo.this, \"Reselected:\" + tab.getText(), Toast.LENGTH_SHORT).show();\n"
        + "    }\n"
        + "}\n"
    ;

    public static final String ActionBarActionModeDefultButtonStyle =
        "<style name=\"actionbar_actionmode_button_default\" parent=\"miui:Widget.ActionMode.Button.Default\">\n"
        + "    <item name=\"android:textColor\">#ff58a7ff</item>\n"
        + "    <item name=\"android:textSize\">14sp</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarTabTheme =
        "<style name=\"ActionBar.Tab\">\n"
        + "    <item name=\"android:actionBarStyle\">@style/actionbar_tab_actionbar</item>\n"
        + "    <item name=\"android:actionBarTabStyle\">@style/actionbar_tab</item>\n"
        + "    <item name=\"android:actionBarTabBarStyle\">@style/actionbar_tabbar</item>\n"
        + "    <item name=\"android:actionBarTabTextStyle\">@style/actionbar_tabtext</item>\n"
        + "</style>\n"
    ;

    public static final String DialogProgressHorizontal =
        "ProgressDialog progressDialog = new ProgressDialog(this, R.style.AlertDialog_ProgressHorizontal);\n"
        + "progressDialog.setMessage(\"progressing...\");\n"
        + "progressDialog.setIndeterminate(true);\n"
        + "progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);\n"
        + "dialog = progressDialog;\n"
    ;

    public static final String SearchActionModeActionModeCallback =
        "private class SearchActionModeCallback implements SearchActionMode.Callback {\n"
        + "\n"
        + "    @Override\n"
        + "    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {\n"
        + "        mSearchActionMode = actionMode;\n"
        + "\n"
        + "        SearchActionMode searchActionMode = (SearchActionMode) actionMode;\n"
        + "        searchActionMode.setAnchorView(mAnchorView);\n"
        + "        searchActionMode.setAnimateView(mList);\n"
        + "        searchActionMode.setResultView(getSearchResultView());\n"
        + "\n"
        + "        searchActionMode.getSearchInput().addTextChangedListener(mSearchTextWatcher);\n"
        + "\n"
        + "        return true;\n"
        + "    }\n"
        + "\n"
        + "    @Override\n"
        + "    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {\n"
        + "        return false;\n"
        + "    }\n"
        + "\n"
        + "    @Override\n"
        + "    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {\n"
        + "        return false;\n"
        + "    }\n"
        + "\n"
        + "\n"
        + "    @Override\n"
        + "    public void onDestroyActionMode(ActionMode actionMode) {\n"
        + "        mSearchActionMode = null;\n"
        + "        SearchActionMode searchActionMode = (SearchActionMode) actionMode;\n"
        + "        searchActionMode.getSearchInput().removeTextChangedListener(mSearchTextWatcher);\n"
        + "        mSearchResultView.setVisibility(View.GONE);\n"
        + "    }\n"
        + "}\n"
    ;

    public static final String ActionBarActionModeButtonStyle =
        "<style name=\"actionbar_actionmode_button\" parent=\"miui:Widget.ActionMode.Button\">\n"
        + "    <item name=\"android:textColor\">#ff0a0988</item>\n"
        + "    <item name=\"android:textSize\">12sp</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarPopupMenuTitleTextStyle =
        "<style name=\"actionbar_popupmenu_titletext\" parent=\"miui:TextAppearance.Widget.PopupMenu.Large\">\n"
        + "    <item name=\"android:textColor\">#ff880088</item>\n"
        + "    <item name=\"android:textSize\">15sp</item>\n"
        + "</style>\n"
    ;

    public static final String OnOptionsItemSelected =
        "@Override\n"
        + "public boolean onOptionsItemSelected(MenuItem item) {\n"
        + "    Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();\n"
        + "    return true;\n"
        + "}\n"
    ;

    public static final String DialogDateTimePicker =
        "DateTimePickerDialog d = new DateTimePickerDialog(this,\n"
        + "        null, 5);\n"
        + "d.show();\n"
    ;

    public static final String SimpleFragmentOnCreateView =
        "@Override\n"
        + "public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {\n"
        + "    Log.v(\"SimpleFragment\", \"Fragment.onCreateView()\");\n"
        + "    TextView v = new TextView(inflater.getContext());\n"
        + "    v.setGravity(Gravity.CENTER);\n"
        + "    v.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));\n"
        + "    v.setText(\"Hello, world!\");\n"
        + "    return v;\n"
        + "}\n"
    ;

    public static final String ActionBarSubTitleTextStyle =
        "<style name=\"actionbar_subtitle_text\" parent=\"miui:TextAppearance.WindowTitle.Subtitle\">\n"
        + "    <item name=\"android:textColor\">#ff88bb88</item>\n"
        + "    <item name=\"android:textSize\">15sp</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarRemoveAllTab =
        "getActionBar().removeAllTabs();\n"
    ;

    public static final String ActionBarSplitTheme =
        "<style name=\"ActionBar.SplitBar\">\n"
        + "    <item name=\"android:actionBarSplitStyle\">@style/actionbar_split</item>\n"
        + "    <item name=\"android:actionButtonStyle\">@style/actionbar_action_button</item>\n"
        + "    <item name=\"android:actionOverflowButtonStyle\">@style/actionbar_action_button_more</item>\n"
        + "    <!-- action bar split bar background -->\n"
        + "    <item name=\"*miui:actionBarSplitBackground\">@color/action_bar_splitbar_bg_color</item>\n"
        + "    <!-- action bar split bar expand background only in PHONE -->\n"
        + "    <item name=\"*miui:actionBarExpandBackground\">@color/action_bar_splitbar_bg_color</item>\n"
        + "    <!-- set the expand menu view list background -->\n"
        + "    <item name=\"*miui:listMenuBackground\">@color/action_bar_splitbar_bg_color</item>\n"
        + "    <!-- Menu Title Text style in Popup Menu Window -->\n"
        + "    <item name=\"android:textAppearanceLargePopupMenu\">@style/actionbar_popupmenu_titletext</item>\n"
        + "    <!-- Menu Shortcut Text style in Popup Menu Window -->\n"
        + "    <item name=\"android:textAppearanceSmallPopupMenu\">@style/actionbar_popupmenu_shortcuttext</item>\n"
        + "    <!-- Popup Menu Window Style, Only in PAD Need the two attribute-->\n"
        + "    <item name=\"android:popupMenuStyle\">@style/actionbar_popupmenu_window</item>\n"
        + "    <item name=\"android:dropDownListViewStyle\">@style/actionbar_popupmenu_dropdownlistview</item>\n"
        + "</style>\n"
    ;

    public static final String DialogButtonStyle =
        "<style name=\"dialog_buttonbar_button\" parent=\"miui:Widget.Button.Dialog\">\n"
        + "    <item name=\"android:textStyle\">italic</item>\n"
        + "    <item name=\"android:textColor\">@android:color/holo_green_light</item>\n"
        + "</style>\n"
    ;

    public static final String EditActionModeStartActionMode =
        "if (mEditActionMode == null) {\n"
        + "    startActionMode(new ActionModeCallback());\n"
        + "}\n"
    ;

    public static final String ActionBarHomeAsUp =
        "<item name=\"android:homeAsUpIndicator\">@drawable/bar_back</item>\n"
    ;

    public static final String EditActionModeActionModeCallback =
        "private class ActionModeCallback implements ActionMode.Callback {\n"
        + "\n"
        + "    @Override\n"
        + "    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {\n"
        + "        mEditActionMode = actionMode;\n"
        + "        mEditActionMode.setTitle(\"Editting Mode!\");\n"
        + "        menu.add(Menu.NONE, COPY,Menu.NONE, \"copy\")\n"
        + "                .setIcon(miui.R.drawable.action_button_copy_light)\n"
        + "                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "        menu.add(Menu.NONE, CUT,Menu.NONE, \"cut\")\n"
        + "                .setIcon(miui.R.drawable.action_button_cut_light)\n"
        + "                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "        menu.add(Menu.NONE, PASTE,Menu.NONE, \"paste\")\n"
        + "                .setIcon(miui.R.drawable.action_button_paste_light)\n"
        + "                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "        menu.add(Menu.NONE, DELETE,Menu.NONE, \"delete\")\n"
        + "                .setIcon(miui.R.drawable.action_button_delete_light)\n"
        + "                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "\n"
        + "        mSelectAll = true;\n"
        + "        return true;\n"
        + "    }\n"
        + "\n"
        + "    @Override\n"
        + "    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {\n"
        + "        return true;\n"
        + "    }\n"
        + "\n"
        + "    @Override\n"
        + "    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {\n"
        + "        String text;\n"
        + "        if (menuItem.getItemId() == android.R.id.button1) //cancel\n"
        + "        {\n"
        + "            actionMode.finish();\n"
        + "            text = \"Finish Edit Mode\";\n"
        + "        }\n"
        + "        else if(menuItem.getItemId() == android.R.id.button2) //select/unselect all\n"
        + "        {\n"
        + "            mSelectAll = !mSelectAll;\n"
        + "            text = mSelectAll ? \"UnSelect All\" : \"Select All\";\n"
        + "            ((EditActionMode)actionMode).setButton(android.R.id.button2,\n"
        + "                    mSelectAll ? com.miui.internal.R.string.select_all:\n"
        + "                            com.miui.internal.R.string.deselect_all);\n"
        + "        }\n"
        + "        else {\n"
        + "            text = (String)menuItem.getTitle();\n"
        + "        }\n"
        + "        Toast.makeText(EditActionModeDemo.this, text, Toast.LENGTH_SHORT).show();\n"
        + "        return true;\n"
        + "    }\n"
        + "\n"
        + "    @Override\n"
        + "    public void onDestroyActionMode(ActionMode actionMode) {\n"
        + "        mEditActionMode = null;\n"
        + "    }\n"
        + "}\n"
    ;

    public static final String DialogTimePicker =
        "Calendar c = new Calendar();\n"
        + "TimePickerDialog d = new TimePickerDialog(this, R.style.AlertDialog_TimePicker,\n"
        + "        null, c.get(Calendar.HOUR),\n"
        + "        c.get(Calendar.MINUTE), DateFormat.is24HourFormat(this));\n"
        + "d.show();\n"
    ;

    public static final String ActionBarMovableLayoutInflateLayout =
        "setContentView(R.layout.action_bar_movable_layout);\n"
        + "mViewPager = (ViewPager) findViewById(miui.R.id.view_pager);\n"
        + "final ActionBar actionBar = getActionBar();\n"
        + "actionBar.setDisplayShowTitleEnabled(false);\n"
        + "actionBar.setDisplayHomeAsUpEnabled(false);\n"
        + "actionBar.setDisplayShowCustomEnabled(true);\n"
        + "actionBar.setCustomView(new TextView(this, null));\n"
        + "\n"
        + "actionBar.setFragmentViewPagerMode(this, getFragmentManager());\n"
        + "actionBar.addFragmentTab(\"tab-0\", actionBar.newTab().setText(\"tab-0\"), ArrayListFragment.class, null, false);\n"
        + "actionBar.addFragmentTab(\"tab-1\", actionBar.newTab().setText(\"tab-1\"), ArrayListFragment.class, null, false);\n"
    ;

    public static final String ActionBarActionModeStyle =
        "<style name=\"actionbar_actionmode\" parent=\"miui:Widget.ActionMode\">\n"
        + "    <item name=\"android:height\">80dp</item>\n"
        + "    <item name=\"android:titleTextStyle\">@style/actionbar_title_text</item>\n"
        + "    <item name=\"android:subtitleTextStyle\">@style/actionbar_subtitle_text</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarMovableLayoutStyleMovable =
        "<style name=\"ActionBarStyle.Movable\">\n"
        + "    <item name=\"android:height\">300dip</item>\n"
        + "    <item name=\"android:background\">@drawable/movable_bg</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarTitleStyle =
        "<style name=\"actionbar_title\" parent=\"miui:Widget.ActionBar\">\n"
        + "    <!-- set the actionbar background -->\n"
        + "    <item name=\"android:background\">#ff222222</item>\n"
        + "    <item name=\"android:titleTextStyle\">@style/actionbar_title_text</item>\n"
        + "    <item name=\"android:subtitleTextStyle\">@style/actionbar_subtitle_text</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarSize =
        "<item name=\"android:actionBarSize\">80dip</item>\n"
    ;

    public static final String ActionBarMovableLayout =
        "<miui.view.ViewPager xmlns:android=\"http://schemas.android.com/apk/res/android\"\n"
        + "    android:id=\"@miui:id/view_pager\"\n"
        + "    android:layout_width=\"match_parent\"\n"
        + "    android:layout_height=\"match_parent\"\n"
        + "    android:background=\"#ffffffff\" />\n"
    ;

    public static final String CreateActionBarOptionMenu =
        "@Override\n"
        + "public boolean onCreateOptionsMenu(Menu menu) {\n"
        + "    int iconId = AttributeResolver.resolve(this, miui.R.attr.actionBarEditIcon);\n"
        + "    menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())\n"
        + "            .setIcon(iconId)\n"
        + "            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "    menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())\n"
        + "            .setIcon(iconId)\n"
        + "            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "    menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())\n"
        + "            .setIcon(iconId)\n"
        + "            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "    menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())\n"
        + "            .setIcon(iconId)\n"
        + "            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "    menu.add(0, R.id.set_action_button_title, 0, generateMenuBarItemLabel())\n"
        + "            .setIcon(iconId)\n"
        + "            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);\n"
        + "    mMenu = menu;\n"
        + "    return true;\n"
        + "}\n"
    ;

    public static final String EditActionModeOnActionItemClicked =
        "@Override\n"
        + "public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {\n"
        + "    String text;\n"
        + "    if (menuItem.getItemId() == android.R.id.button1) //cancel\n"
        + "    {\n"
        + "        actionMode.finish();\n"
        + "        text = \"Finish Edit Mode\";\n"
        + "    }\n"
        + "    else if(menuItem.getItemId() == android.R.id.button2) //select/unselect all\n"
        + "    {\n"
        + "        mSelectAll = !mSelectAll;\n"
        + "        text = mSelectAll ? \"UnSelect All\" : \"Select All\";\n"
        + "        ((EditActionMode)actionMode).setButton(android.R.id.button2,\n"
        + "                mSelectAll ? com.miui.internal.R.string.select_all:\n"
        + "                        com.miui.internal.R.string.deselect_all);\n"
        + "    }\n"
        + "    else {\n"
        + "        text = (String)menuItem.getTitle();\n"
        + "    }\n"
        + "    Toast.makeText(EditActionModeDemo.this, text, Toast.LENGTH_SHORT).show();\n"
        + "    return true;\n"
        + "}\n"
    ;

    public static final String SearchActionModeActionModeAnchorView =
        "mAnchorView = getLayoutInflater()\n"
        + "        .inflate(miui.R.layout.search_stub, null);\n"
        + "mList.addHeaderView(mAnchorView);\n"
        + "mAnchorView.setOnClickListener(new View.OnClickListener() {\n"
        + "    @Override\n"
        + "    public void onClick(View view) {\n"
        + "        startActionMode(mSearchCallback);\n"
        + "    }\n"
        + "});\n"
    ;

    public static final String ActionBarTitleTextStyle =
        "<style name=\"actionbar_title_text\" parent=\"miui:TextAppearance.WindowTitle\">\n"
        + "    <item name=\"android:textColor\">#ffbb88bb</item>\n"
        + "    <item name=\"android:textSize\">30sp</item>\n"
        + "</style>\n"
    ;

    public static final String DialogDefaultButtonStyle =
        "<style name=\"dialog_buttonbar_button_default\" parent=\"miui:Widget.Button.Dialog.Default\">\n"
        + "    <item name=\"android:textStyle\">italic</item>\n"
        + "    <item name=\"android:textColor\">@android:color/holo_green_light</item>\n"
        + "</style>\n"
    ;

    public static final String SetCustomView =
        "getActionBar().setDisplayShowCustomEnabled(b);\n"
        + "//getActionBar().setDisplayOptions(b ? DISPLAY_SHOW_CUSTOM: 0, DISPLAY_SHOW_CUSTOM);\n"
    ;

    public static final String DISPLAY_SHOW_TITLE =
        "getActionBar().setDisplayShowTitleEnabled(b);\n"
        + "//getActionBar().setDisplayOptions(b ? ActionBar.DISPLAY_SHOW_TITLE: 0, ActionBar.DISPLAY_SHOW_TITLE);\n"
    ;

    public static final String DialogDatePickerTitleStyle =
        "<style name=\"dialog_date_picker_title\" parent=\"*miui:Widget.DialogTitle\">\n"
        + "    <item name=\"android:textSize\">28sp</item>\n"
        + "</style>\n"
    ;

    public static final String AlertDialogSingleChoiceTheme =
        "    <style name=\"AlertDialog.SingleChoice\">\n"
        + "    <item name=\"android:listChoiceIndicatorSingle\">@drawable/ic_logo</item>\n"
        + "    </style>\n"
    ;

    public static final String RemoveActionButton =
        "mMenu.removeItem(R.id.set_action_button_title);\n"
    ;

    public static final String SimpleFragmentOnActivityCreated =
        "@Override\n"
        + "public void onActivityCreated(Bundle savedInstanceState) {\n"
        + "    super.onActivityCreated(savedInstanceState);\n"
        + "    Log.v(\"SimpleFragment\", \"Fragment.onActivityCreated()\");\n"
        + "}\n"
    ;

    public static final String SimpleFragmentOnOptionsItemSelected =
        "@Override\n"
        + "public boolean onOptionsItemSelected(MenuItem item) {\n"
        + "    if (item.getItemId() == android.R.id.edit) {\n"
        + "        final ActionBar bar = ((Activity) getActivity()).getActionBar();\n"
        + "        //replace current fragment\n"
        + "        bar.removeFragmentTabAt(3);\n"
        + "        bar.addFragmentTab(\"3\", bar.newTab().setText(\"List2\"), ArrayListFragment.class, null, false);\n"
        + "        bar.selectTab(bar.getTabAt(3));\n"
        + "        return true;\n"
        + "    }\n"
        + "    return false;\n"
        + "}\n"
    ;

    public static final String DialogListItem =
        "AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog_ListItem);\n"
        + "builder.setTitle(\"List Item\")\n"
        + "        .setItems(R.array.entryvalues_list_preference, mOnSingleChoiceListener);\n"
        + "dialog = builder.create();\n"
    ;

    public static final String AlertDialogProgressTheme =
        "<style name=\"AlertDialog.Progress\">\n"
        + "    <item name=\"android:progressBarStyle\">@style/dialog_progressbar</item>\n"
        + "</style>\n"
    ;

    public static final String FixedSizeActivityDemoAndroidManifest =
        "<activity\n"
        + "    android:name=\".app.FixedSizeActivityDemo\"\n"
        + "    android:theme=\"@miui:style/Theme.Light.Dialog.FixedSize\"\n"
        + "    android:label=\"App/Activity/Fixed size Activity\">\n"
        + "    <intent-filter>\n"
        + "        <action android:name=\"android.intent.action.MAIN\"/>\n"
        + "        <category android:name=\"android.intent.category.MIUI_SAMPLE_CODE\"/>\n"
        + "    </intent-filter>\n"
        + "</activity>\n"
    ;

    public static final String ActionBarPopupMenuWindowStyle =
        "<style name=\"actionbar_popupmenu_window\" parent=\"*miui:Widget.PopupMenu\">\n"
        + "    <item name=\"android:dropDownSelector\">@null</item>\n"
        + "    <item name=\"android:popupBackground\">#88ccffcc</item>\n"
        + "    <item name=\"android:dropDownVerticalOffset\">10dip</item>\n"
        + "    <item name=\"android:dropDownHorizontalOffset\">10dip</item>\n"
        + "    <item name=\"android:dropDownWidth\">wrap_content</item>\n"
        + "</style>\n"
        + "<style name=\"actionbar_popupmenu_dropdownlistview\" parent=\"miui:Widget.ListView\">\n"
        + "    <item name=\"android:background\">@color/action_bar_splitbar_bg_color</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarContentAutoFitSystemWindow =
        "<item name=\"miui:contentAutoFitSystemWindow\">true</item>\n"
    ;

    public static final String SearchActionModeStartActionMode =
        "if (mSearchActionMode == null) {\n"
        + "    startActionMode(mSearchCallback);\n"
        + "}\n"
    ;

    public static final String SetActionButtonVisible =
        "MenuItem item = mMenu.findItem(R.id.set_action_button_title);\n"
        + "item.setVisible(!item.isVisible());\n"
    ;

    public static final String DialogCustomAlertDialog =
        "MyAlertDialog custom = new MyAlertDialog(this, R.style.AlertDialog_Custom);\n"
        + "\n"
        + "custom.setTitle(\"Custom\");\n"
        + "custom.setButton(DialogInterface.BUTTON_POSITIVE, \"Positive\", mDialogOnClickListener);\n"
        + "custom.setButton(DialogInterface.BUTTON_NEGATIVE, \"Negative\", mDialogOnClickListener);\n"
        + "custom.setMessage(\"Message\");\n"
        + "custom.setCancelable(true);\n"
        + "dialog = custom;\n"
    ;

    public static final String SetActionButtonIcon =
        "MenuItem item = mMenu.findItem(R.id.set_action_button_title);\n"
        + "item.setIcon(mSetIcon ? AttributeResolver.resolve(ActionBarSplitBarDemo.this,\n"
        + "        miui.R.attr.actionBarFavoriteIcon) : AttributeResolver.resolve(ActionBarSplitBarDemo.this,\n"
        + "        miui.R.attr.actionBarUnfavoriteIcon));\n"
        + "mSetIcon = !mSetIcon;\n"
    ;

    public static final String ActionBarTabActionBarStyle =
        "<style name=\"actionbar_tab_actionbar\" parent=\"miui:Widget.ActionBar\">\n"
        + "    <item name=\"miui:tabIndicator\">@null</item>\n"
        + "</style>\n"
    ;

    public static final String DISPLAY_SHOW_HOME =
        "getActionBar().setDisplayShowHomeEnabled(b);\n"
        + "//getActionBar().setDisplayOptions(b ? ActionBar.DISPLAY_SHOW_HOME: 0, ActionBar.DISPLAY_SHOW_HOME);\n"
    ;

    public static final String AlertDialogDatePickerTheme =
        "    <style name=\"AlertDialog.DatePicker\" parent=\"miui:Theme.Light.Dialog\">\n"
        + "   <item name=\"android:windowTitleStyle\">@style/dialog_date_picker_title</item>\n"
        + "    </style>\n"
    ;

    public static final String ActionBarAddTab =
        "final ActionBar bar = getActionBar();\n"
        + "final int tabCount = bar.getTabCount();\n"
        + "final String text = \"Tab \" + tabCount;\n"
        + "bar.addTab(bar.newTab().setText(text)\n"
        + "        .setTabListener(new TabListener()));\n"
    ;

    public static final String AddFragmentTab =
        "protected void onCreate(Bundle savedInstanceState) {\n"
        + "    super.onCreate(savedInstanceState);\n"
        + "\n"
        + "    final ActionBar bar = getActionBar();\n"
        + "    //1. set FragementViewPageMode\n"
        + "    bar.setFragmentViewPagerMode(this, getFragmentManager());\n"
        + "\n"
        + "    //2. add fragments\n"
        + "\n"
        + "    // Last parameter is \"false\" : No Action Menu\n"
        + "    bar.addFragmentTab(\"0\", bar.newTab().setText(\"List\"), ArrayListFragment.class, null, false);\n"
        + "\n"
        + "    // Use Bunndle to pass the parameters\n"
        + "    Bundle bundle = new Bundle();\n"
        + "    bundle.putInt(\"count\", 0);\n"
        + "    // Last parameter is \"ture\" : Has Action Menu\n"
        + "    bar.addFragmentTab(\"1\", bar.newTab().setText(\"Cursor#1\"), CursorFragment.class, bundle, true);\n"
        + "\n"
        + "    bundle = new Bundle();\n"
        + "    bundle.putInt(\"count\", 1);\n"
        + "    bar.addFragmentTab(\"2\", bar.newTab().setText(\"Cursor#2\"), CursorFragment.class, bundle, true);\n"
        + "\n"
        + "    bar.addFragmentTab(\"3\", bar.newTab().setText(\"Simple\"), SimpleFragment.class, null, false);\n"
        + "\n"
        + "    bar.addFragmentTab(\"4\", bar.newTab().setText(\"Source\"), SourceFragment.class, null, true);\n"
        + "\n"
        + "}\n"
    ;

    public static final String SetSubTitle =
        "if (setsubtitle) {\n"
        + "    getActionBar().setSubtitle(null);\n"
        + "} else {\n"
        + "    getActionBar().setSubtitle(\"Sub Title\");\n"
        + "}\n"
    ;

    public static final String ActionBarMovableLayoutStyle =
        "<style name=\"ActionBarMovableLayout\" parent=\"miui:Widget.ActionBarMovableLayout\">\n"
        + "    <item name=\"miui:overScrollRange\">60dip</item>\n"
        + "    <item name=\"miui:scrollRange\">120dip</item>\n"
        + "    <item name=\"miui:scrollStart\">60dip</item>\n"
        + "</style>\n"
    ;

    public static final String ActionBarTabTextStyle =
        "<style name=\"actionbar_tabtext\">\n"
        + "    <item name=\"android:textColor\">#ff0a0988</item>\n"
        + "    <item name=\"android:textSize\">20sp</item>\n"
        + "</style>\n"
    ;

    public static final String SimpleFragmentOnDetach =
        "@Override\n"
        + "public void onDetach() {\n"
        + "    super.onDetach();\n"
        + "    Log.v(\"SimpleFragment\", \"Fragment.onDetach()\");\n"
        + "}\n"
    ;

    public static final String CursorFragmentOnCreate =
        "@Override\n"
        + "public void onCreate(Bundle savedInstanceState) {\n"
        + "    super.onCreate(savedInstanceState);\n"
        + "    //Get Parameter in onCreate or onActivityCreated\n"
        + "    mCount = getArguments().getInt(\"count\", 0);\n"
        + "}\n"
    ;

    public static final String ActionBarActionButtonStyle =
        "<style name=\"actionbar_action_button\" parent=\"miui:Widget.ActionButton\">\n"
        + "    <item name=\"android:textColor\">#ff880088</item>\n"
        + "    <item name=\"android:textSize\">15sp</item>\n"
        + "</style>\n"
    ;

    public static final String DialogProgressBarHorizontalStyle =
        "<style name=\"dialog_progressbar_horizontal\" parent=\"miui:Widget.ProgressBar.Horizontal\">\n"
        + "    <item name=\"android:background\">#ff00ff00</item>\n"
        + "</style>\n"
    ;

    public static final String EditActionModeSetTitle =
        "if (mEditActionMode != null) {\n"
        + "    mEditActionMode.setTitle(\"Edit Mode Title:\" + mCount);\n"
        + "    mEditActionMode.setSubtitle(\"subtitle:\" + mCount ++);\n"
        + "}\n"
    ;

    public static final String AlertDialogSimpleTheme =
        "<style name=\"AlertDialog.Simple\">\n"
        + "    <item name=\"android:windowTitleStyle\">@style/dialog_title</item>\n"
        + "    <item name=\"android:textAppearanceMedium\">@style/dialog_content</item>\n"
        + "</style>\n"
    ;

    public static final String AlertDialogCustomTheme =
        "    <style name=\"AlertDialog.Custom\" parent=\"miui:Theme.Light.Dialog\">\n"
        + "   <item name=\"android:windowTitleStyle\">@style/dialog_custom_title</item>\n"
        + "    </style>\n"
    ;

    public static final String ActionBarCoustomViewAutoFitSystemWindow =
        "<item name=\"miui:customViewAutoFitSystemWindow\">true</item>\n"
    ;

    public static final String SearchActionModeEndActionMode =
        "if (mSearchActionMode != null) {\n"
        + "    mSearchActionMode.finish();\n"
        + "}\n"
    ;

    public static final String ActionBarTabStyle =
        "<style name=\"actionbar_tab\">\n"
        + "    <!-- set the layout_weight = \\\"1\\\" -->\n"
        + "    <item name=\"android:layout_weight\">1.0</item>\n"
        + "    <!-- set the align center|left|right -->\n"
        + "    <item name=\"android:gravity\">center</item>\n"
        + "    <item name=\"android:background\">@drawable/tab_bg_light</item>\n"
        + "</style>\n"
    ;

    public static final String ClearAllActionButton =
        "mMenu.clear();\n"
    ;

    public static final String ActionBarToggleTab =
        "final ActionBar bar = getActionBar();\n"
        + "if (bar.getNavigationMode() == android.app.ActionBar.NAVIGATION_MODE_TABS) {\n"
        + "    bar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_STANDARD);\n"
        + "} else {\n"
        + "    bar.setNavigationMode(android.app.ActionBar.NAVIGATION_MODE_TABS);\n"
        + "}\n"
    ;

    public static final String ActionBarMovableLayoutSetScrollListener =
        "ActionBarMovableLayout movableLayout = (ActionBarMovableLayout) findViewById(\n"
        + "        com.miui.internal.R.id.action_bar_overlay_layout);\n"
        + "movableLayout.setOnScrollListener(this);\n"
    ;

    public static final String ActionBarRemoveTab =
        "final ActionBar bar = getActionBar();\n"
        + "if (bar.getTabCount() > 0) {\n"
        + "    bar.removeTabAt(bar.getTabCount() - 1);\n"
        + "}\n"
    ;

    public static final String SimpleFragmentOnCreate =
        "@Override\n"
        + "public void onCreate(Bundle savedInstanceState) {\n"
        + "    super.onCreate(savedInstanceState);\n"
        + "    Log.v(\"SimpleFragment\", \"Fragment.onCreate()\");\n"
        + "    // Has OptionsMenu Even set false when addFragementTab\n"
        + "    setHasOptionsMenu(true);\n"
        + "}\n"
    ;

    public static final String ActionBarActionModeTheme =
        "<style name=\"ActionBar.ActionMode\">\n"
        + "    <item name=\"android:actionModeStyle\">@style/actionbar_actionmode</item>\n"
        + "    <item name=\"android:actionModeBackground\">@color/actionmode_bar_bg</item>\n"
        + "    <item name=\"android:actionModeSplitBackground\">@color/actionmode_split_bar_bg</item>\n"
        + "    <item name=\"miui:actionModeButtonStyle\">@style/actionbar_actionmode_actionbutton</item>\n"
        + "    <item name=\"miui:actionModeCancelButtonStyle\">@style/actionbar_actionmode_button</item>\n"
        + "    <item name=\"miui:actionModeSelectButtonStyle\">@style/actionbar_actionmode_button_default</item>\n"
        + "</style>\n"
    ;

    public static final String SimpleFragementOnAttach =
        "@Override\n"
        + "public void onAttach(android.app.Activity activity) {\n"
        + "    super.onAttach(activity);\n"
        + "    Log.v(\"SimpleFragment\", \"Fragment.onAttach()\");\n"
        + "}\n"
    ;

    public static final String DialogCustomTitleStyle =
        "<style name=\"dialog_custom_title\" parent=\"*miui:Widget.DialogTitle\">\n"
        + "    <item name=\"android:textSize\">24sp</item>\n"
        + "    <item name=\"android:textColor\">#fffb6003</item>\n"
        + "</style>\n"
    ;

    public static final String DialogTitleStyle =
        "<style name=\"dialog_title\" parent=\"*miui:Widget.DialogTitle\">\n"
        + "    <item name=\"android:textSize\">26sp</item>\n"
        + "    <item name=\"android:textColor\">#ffff0000</item>\n"
        + "</style>\n"
    ;


}
