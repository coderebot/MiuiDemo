/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.app;

import miui.app.Activity;
import miui.app.AlertDialog;
import miui.app.DatePickerDialog;
import miui.app.DateTimePickerDialog;
import miui.app.ProgressDialog;
import miui.app.TimePickerDialog;
import miui.date.Calendar;
import miui.util.AttributeResolver;

import android.app.Dialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Toast;

import com.example.miui.R;

import com.example.common.ActionBarDemoBaseActivity;
import com.example.common.DemoControlList;
import com.example.miui.CodeStyles;

public class AlertDialogDemo extends ActionBarDemoBaseActivity {

    private static final int DIALOG_SIMPLE = R.id.simple_button;
    private static final int DIALOG_SIMPLE_WITHOUT_TITLE = R.id.simple_without_title_button;
    private static final int DIALOG_PROGRESS = R.id.progress_button;
    private static final int DIALOG_PROGRESS_HORIZONTAL = R.id.progress_horizontal_button;
    private static final int DIALOG_LIST_ITEM = R.id.list_item_button;
    private static final int DIALOG_SINGLE_CHOICE = R.id.single_choice_button;
    private static final int DIALOG_MULTI_CHOICE = R.id.multi_choice_button;
    private static final int DIALOG_CUSTOM_ALERT_DIALOG = R.id.custom_alert_dialog_button;
    private static final int DIALOG_TIMEPICKER = R.id.timepicker_alert_dialog_button;
    private static final int DIALOG_DATEPICKER = R.id.datepicker_alert_dialog_button;
    private static final int DIALOG_DATETIMEPICKER = R.id.datetimepicker_alert_dialog_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        DemoControlList list = getControlList();

        list.addItem(getString(R.string.alert_dialog_simple),
                null,
                CodeStyles.DialogSimple,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogSimpleTheme
                        + "\n<!--- styles.xml ---!>\n"
                        + CodeStyles.DialogTitleStyle + "\n" + CodeStyles.DialogContentStyle,
                getShowDialogRunnable(DIALOG_SIMPLE));

        list.addItem(
                getString(R.string.alert_dialog_simple_without_title),
                null,
                CodeStyles.DialogSimpleWithoutTitle,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogSimpleWithoutTitleTheme
                        + "\n<!--- styles.xml ---!>\n"
                        + CodeStyles.DialogButtonStyle + "\n" + CodeStyles.DialogDefaultButtonStyle,
                getShowDialogRunnable(DIALOG_SIMPLE_WITHOUT_TITLE));

        list.addItem(getString(R.string.alert_dialog_progress),
                null,
                CodeStyles.DialogProgress,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogProgressTheme
                        + "\n<!--- styles.xml ---!>\n"
                        + CodeStyles.DialogProgressBarStyle,
                getShowDialogRunnable(DIALOG_PROGRESS));

        list.addItem(getString(R.string.alert_dialog_progress_horizontal),
                null,
                CodeStyles.DialogProgressHorizontal,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogProgressHorizontalTheme
                        + "\n<!--- styles.xml ---!>\n"
                        + CodeStyles.DialogProgressBarHorizontalStyle,
                getShowDialogRunnable(DIALOG_PROGRESS_HORIZONTAL));

        list.addItem(getString(R.string.alert_dialog_list_item),
                null,
                CodeStyles.DialogListItem,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogListItemTheme,
                getShowDialogRunnable(DIALOG_LIST_ITEM));

        list.addItem(getString(R.string.alert_dialog_single_choice),
                null,
                CodeStyles.DialogSingleChoice,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogSingleChoiceTheme,
                getShowDialogRunnable(DIALOG_SINGLE_CHOICE));

        list.addItem(getString(R.string.alert_dialog_multi_choice),
                null,
                CodeStyles.DialogMultiChoice,
                null,
                getShowDialogRunnable(DIALOG_MULTI_CHOICE));

        list.addItem(getString(R.string.alert_dialog_custom),
                null,
                CodeStyles.DialogCustomAlertDialog,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogCustomTheme
                        + "\n<!--- styles.xml ---!>\n"
                        + CodeStyles.DialogCustomTitleStyle,
                getShowDialogRunnable(DIALOG_CUSTOM_ALERT_DIALOG));

        list.addItem(getString(R.string.alert_dialog_timepicker),
                null,
                CodeStyles.DialogTimePicker,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogTimePickerTheme,
                getShowDialogRunnable(DIALOG_TIMEPICKER));

        list.addItem(getString(R.string.alert_dialog_datepicker),
                null,
                CodeStyles.DialogDatePicker,
                "<!--- themes.xml ---!>\n" + CodeStyles.AlertDialogDatePickerTheme
                        + "\n<!--- styles.xml ---!>\n"
                        + CodeStyles.DialogDatePickerTitleStyle,
                getShowDialogRunnable(DIALOG_DATEPICKER));

        list.addItem(getString(R.string.alert_dialog_datetimepicker),
                null,
                CodeStyles.DialogDateTimePicker,
                null,
                getShowDialogRunnable(DIALOG_DATETIMEPICKER));
    }

    @Override
    protected Dialog onCreateDialog(int id, Bundle bundle) {
        Dialog dialog = null;
        switch (id) {
            case DIALOG_SIMPLE: {
                //CODE-BEGIN DialogSimple
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog_Simple);
                builder.setTitle("Title")
                        .setMessage("Message")
                        .setPositiveButton("Positive", mDialogOnClickListener)
                        .setNeutralButton("Neutral", mDialogOnClickListener)
                        .setNegativeButton("Negative", mDialogOnClickListener);
                dialog = builder.create();
              //CODE-END DialogSimple
            }
                break;

            case DIALOG_SIMPLE_WITHOUT_TITLE: {
                // CODE-BEGIN DialogSimpleWithoutTitle
                AlertDialog.Builder builder = new AlertDialog.Builder(this,
                        R.style.AlertDialog_WithoutTitle);
                builder.setMessage("Message")
                        .setPositiveButton("Positive", mDialogOnClickListener)
                        .setNegativeButton("Negative", mDialogOnClickListener);
                dialog = builder.create();
                // CODE-END DialogSimpleWithoutTitle
            }
                break;

            case DIALOG_PROGRESS: {
                //CODE-BEGIN DialogProgress
                ProgressDialog progressDialog = new ProgressDialog(this, R.style.AlertDialog_Progress);
                progressDialog.setMessage("progressing...");
                progressDialog.setIndeterminate(true);
                dialog = progressDialog;
                //CODE-END DialogProgress
            }
                break;

            case DIALOG_PROGRESS_HORIZONTAL: {
                //CODE-BEGIN DialogProgressHorizontal
                ProgressDialog progressDialog = new ProgressDialog(this, R.style.AlertDialog_ProgressHorizontal);
                progressDialog.setMessage("progressing...");
                progressDialog.setIndeterminate(true);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog = progressDialog;
                //CODE-END DialogProgressHorizontal
            }
                break;

            case DIALOG_LIST_ITEM: {
                //CODE-BEGIN DialogListItem
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog_ListItem);
                builder.setTitle("List Item")
                        .setItems(R.array.entryvalues_list_preference, mOnSingleChoiceListener);
                dialog = builder.create();
                //CODE-END DialogListItem
            }
                break;
            case DIALOG_SINGLE_CHOICE: {
                //CODE-BEGIN DialogSingleChoice
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AlertDialog_SingleChoice);
                builder.setTitle("Single Choice")
                       .setPositiveButton("Positive", mDialogOnClickListener)
                       .setSingleChoiceItems(R.array.entryvalues_list_preference, 0, mOnSingleChoiceListener);
                dialog = builder.create();
                //CODE-END DialogSingleChoice
            }
                break;

            case DIALOG_MULTI_CHOICE: {
                //CODE-BEGIN DialogMultiChoice
                final boolean[] checkedItems = {true, true, false};
                AlertDialog.Builder builder = new AlertDialog.Builder(this, AlertDialog.THEME_LIGHT_EDIT);
                builder.setTitle("Multi Choice")
                        .setMultiChoiceItems(R.array.entryvalues_list_preference, checkedItems,
                                mOnMultiChoiceClickListener)
                        .setPositiveButton("Positive", mDialogOnClickListener)
                        .setNegativeButton("Negative", mDialogOnClickListener);
                dialog = builder.create();
                //CODE-END DialogMultiChoice
            }
                break;

            case DIALOG_CUSTOM_ALERT_DIALOG: {
                //CODE-BEGIN DialogCustomAlertDialog
                MyAlertDialog custom = new MyAlertDialog(this, R.style.AlertDialog_Custom);

                custom.setTitle("Custom");
                custom.setButton(DialogInterface.BUTTON_POSITIVE, "Positive", mDialogOnClickListener);
                custom.setButton(DialogInterface.BUTTON_NEGATIVE, "Negative", mDialogOnClickListener);
                custom.setMessage("Message");
                custom.setCancelable(true);
                dialog = custom;
                //CODE-END DialogCustomAlertDialog
                break;
            }

            case DIALOG_TIMEPICKER: {
                //CODE-BEGIN DialogTimePicker
                Calendar c = new Calendar();
                TimePickerDialog d = new TimePickerDialog(this, R.style.AlertDialog_TimePicker,
                        null, c.get(Calendar.HOUR),
                        c.get(Calendar.MINUTE), DateFormat.is24HourFormat(this));
                d.show();
                //CODE-END DialogTimePicker
                break;
            }

            case DIALOG_DATEPICKER: {
                //CODE-BEGIN DialogDatePicker
                Calendar c = new Calendar();
                DatePickerDialog d = new DatePickerDialog(this, R.style.AlertDialog_DatePicker,
                        null, c.get(Calendar.YEAR), c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH));
                d.show();
                //CODE-END DialogDatePicker
                break;
            }
            case DIALOG_DATETIMEPICKER: {
                // CODE-BEGIN DialogDateTimePicker
                DateTimePickerDialog d = new DateTimePickerDialog(this,
                        null, 5);
                d.show();
                // CODE-END DialogDateTimePicker
            }
        }

        return dialog;
    }

    private DialogInterface.OnMultiChoiceClickListener mOnMultiChoiceClickListener =
            new DialogInterface.OnMultiChoiceClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                }
            };

    private DialogInterface.OnClickListener mOnSingleChoiceListener =
            new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            };

    private Runnable getShowDialogRunnable(final int dialogId) {
        return new Runnable() {
            @Override
            public void run() {
                showDialog(dialogId);
            }
        };
    }

    private DialogInterface.OnClickListener mDialogOnClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            String message;
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    message = "Positive button click";
                    break;

                case DialogInterface.BUTTON_NEGATIVE:
                    message = "Negative button click";
                    break;

                case DialogInterface.BUTTON_NEUTRAL:
                    message = "Neutral button click";
                    break;

                default:
                    message = "error";
                    break;
            }
            Toast.makeText(AlertDialogDemo.this, message, Toast.LENGTH_SHORT).show();
        }
    };

    private DialogInterface.OnClickListener mOnActionItemClickListener = new DialogInterface.OnClickListener() {

        @Override
        public void onClick(DialogInterface dialog, int which) {
            Toast.makeText(AlertDialogDemo.this, "item " + String.valueOf(which), Toast.LENGTH_SHORT).show();
        }

    };

    private class MyAlertDialog extends android.app.AlertDialog {
        protected MyAlertDialog(Context context, int theme) {
            super(context, theme);
        }
    }

}
