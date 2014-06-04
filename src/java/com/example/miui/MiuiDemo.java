/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui;

import miui.app.AlertDialog;
import miui.app.ListActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiuiDemo extends ListActivity {

    private static final String CATEGORY_SAMPLE_CODE = "android.intent.category.MIUI_SAMPLE_CODE";

    private static final String EXTRA_PATH = "com.example.miui.Path";

    private static final String CODE_URL_PATH="https://github.com/coderebot/peice/tree/master";


    private class OnGotoSource implements View.OnLongClickListener {
        Map<String, Object> mItem;
        OnGotoSource(Map<String, Object> item) {
            mItem = item;
        }
        @Override
        public boolean onLongClick(View view) {
            final String className = (String)mItem.get("summary");
            AlertDialog.Builder builder = new AlertDialog.Builder(MiuiDemo.this);
            final String[] items = {
                "Goto Source Code",
                "Log out Source URL"
            };
            builder.setItems(items,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0) {
                            gotoSource(className);
                        } else if(which == 1) {
                            logoutSourceURL(className);
                        }
                    }
                });
            builder.create().show();
            return true;
        }
    };

    private static String getSourceCodeUrl(String className) {
        String url = CODE_URL_PATH;
        int pos = className.indexOf("$");
        if (pos > 0) {
            className = className.substring(0, pos);
        }
        url = CODE_URL_PATH + '/' + className.replace(".","/") + ".java";
        return url;
    }

    private void gotoSource(String className) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        Uri content_url = Uri.parse(getSourceCodeUrl(className));
        intent.setData(content_url);
        startActivity(intent);
    }

    private void logoutSourceURL(String className) {
        Log.i("DEMO-URL", getSourceCodeUrl(className));
    }

    private class Adapter extends SimpleAdapter {
        Adapter(Context context, List<Map<String,Object>> data, int resource, String[] from, int[] to) {
            super(context, data, resource, from, to);
        }

        @Override
        public View getView(int position, View convertview, ViewGroup parent) {
            View view = super.getView(position, convertview, parent);

            Map<String, Object> item = (Map<String, Object>)getItem(position);
            if (item == null) {
                return view;
            }

            final Intent intent = (Intent)item.get("intent");
            if (intent != null) {
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(intent);
                    }
                });
            }

            String summary = (String)item.get("summary");
            if (summary != null && summary.length() > 0) {
                view.setOnLongClickListener(new OnGotoSource(item));
            }
            return view;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String path = intent.getStringExtra(EXTRA_PATH);

        if (path == null) {
            path = "";
        }

        setListAdapter(new Adapter(this, getData(path),
                R.layout.simple_list_item_3, new String[] { "title", "summary" },
                new int[] { android.R.id.text1, android.R.id.summary }));
        getListView().setTextFilterEnabled(true);
    }

    protected List<Map<String, Object>> getData(String prefix) {
        List<Map<String, Object>> myData = new ArrayList<Map<String, Object>>();

        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(CATEGORY_SAMPLE_CODE);

        PackageManager pm = getPackageManager();
        List<ResolveInfo> list = pm.queryIntentActivities(mainIntent, 0);

        if (null == list)
            return myData;

        String[] prefixPath;
        String prefixWithSlash = prefix;

        if (prefix.equals("")) {
            prefixPath = null;
        } else {
            prefixPath = prefix.split("/");
            prefixWithSlash = prefix + "/";
        }

        Map<String, Boolean> entries = new HashMap<String, Boolean>();

        for (ResolveInfo info : list) {
            CharSequence labelSeq = info.loadLabel(pm);
            String label = labelSeq != null
                    ? labelSeq.toString()
                    : info.activityInfo.name;

            if (prefixWithSlash.length() == 0 || label.startsWith(prefixWithSlash)) {

                String[] labelPath = label.split("/");

                String nextLabel = prefixPath == null ? labelPath[0] : labelPath[prefixPath.length];

                if ((prefixPath != null ? prefixPath.length : 0) == labelPath.length - 1) {
                    addItem(myData, nextLabel, info.activityInfo.name, activityIntent(
                            info.activityInfo.applicationInfo.packageName,
                            info.activityInfo.name));
                } else {
                    if (entries.get(nextLabel) == null) {
                        addItem(myData, nextLabel, null,
                                browseIntent(prefix.equals("") ? nextLabel : prefix + "/" + nextLabel));
                        entries.put(nextLabel, true);
                    }
                }
            }
        }

        Collections.sort(myData, sDisplayNameComparator);

        return myData;
    }

    private final static Comparator<Map<String, Object>> sDisplayNameComparator =
            new Comparator<Map<String, Object>>() {
                private final Collator   collator = Collator.getInstance();

                public int compare(Map<String, Object> map1, Map<String, Object> map2) {
                    return collator.compare(map1.get("title"), map2.get("title"));
                }
            };

    protected Intent activityIntent(String pkg, String componentName) {
        Intent result = new Intent();
        result.setClassName(pkg, componentName);
        return result;
    }

    protected Intent browseIntent(String path) {
        Intent result = new Intent();
        result.setClass(this, MiuiDemo.class);
        result.putExtra(EXTRA_PATH, path);
        return result;
    }

    protected void addItem(List<Map<String, Object>> data, String name, String summary, Intent intent) {
        Map<String, Object> temp = new HashMap<String, Object>();
        if (summary == null) {
            summary = "";
        }

        temp.put("title", name);
        temp.put("intent", intent);
        temp.put("summary", summary);
        data.add(temp);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Map<String, Object> map = (Map<String, Object>)l.getItemAtPosition(position);

        Intent intent = (Intent) map.get("intent");
        startActivity(intent);
    }
}
