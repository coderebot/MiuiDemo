/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.textappearance;

import android.content.Intent;

public class DarkTextAppearanceDemo extends TextAppearanceDemo {

    @Override
    protected void onChangeTheme() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(DarkTextAppearanceDemo.this.getPackageName(),
                LightTextAppearanceDemo.class.getName());
        startActivity(intent);
    }

}
