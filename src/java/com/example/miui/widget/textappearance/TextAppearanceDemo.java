/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.textappearance;

import android.app.ListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.miui.R;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;

public abstract class TextAppearanceDemo extends ListActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView list = getListView();

        final LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, R.layout.text_appearance_list_item) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = inflater.inflate(R.layout.text_appearance_list_item, parent, false);
                }

                final int resId = getItem(position);
                TextView name = (TextView) convertView.findViewById(R.id.text_name);
                TextView color = (TextView) convertView.findViewById(R.id.text_color);
                TextView size = (TextView) convertView.findViewById(R.id.text_size);
                name.setTextAppearance(TextAppearanceDemo.this, resId);
                color.setTextAppearance(TextAppearanceDemo.this, resId);
                size.setTextAppearance(TextAppearanceDemo.this, resId);

                name.setText("小米公司字体演示 " + getResources().getResourceName(resId));
                int c = color.getCurrentTextColor();
                color.setText(String.format("#%02X%02X%02X%02X", Color.alpha(c), Color.red(c), Color.green(c), Color.blue(c)));
                float s = size.getTextSize();
                size.setText(String.format("%.1fpx", s));

                return convertView;
            }
        };

        for (Field field : miui.R.style.class.getDeclaredFields()) {
            if ((field.getModifiers() & Modifier.STATIC) != 0 &&
                    (field.getModifiers() & Modifier.PUBLIC) != 0 &&
                    field.getType() == int.class) {
                try {
                    int resid = field.getInt(null);
                    String name = getResources().getResourceName(resid);
                    if (name.startsWith("miui:style/TextAppearance")) {
                        adapter.add(resid);
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        adapter.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer lhs, Integer rhs) {
                return lhs - rhs;
            }
        });

        Button button = new Button(this);
        button.setText("Change Theme");
        button.setClickable(true);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onChangeTheme();
                TextAppearanceDemo.this.finish();
            }
        });
        list.addHeaderView(button);

        list.setAdapter(adapter);
    }

    protected abstract void onChangeTheme();
}
