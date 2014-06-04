/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.widget.textappearance;

import android.content.Intent;

public class LightTextAppearanceDemo extends TextAppearanceDemo {

    @Override
    protected void onChangeTheme() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(LightTextAppearanceDemo.this.getPackageName(),
                DarkTextAppearanceDemo.class.getName());
        startActivity(intent);
    }

}
