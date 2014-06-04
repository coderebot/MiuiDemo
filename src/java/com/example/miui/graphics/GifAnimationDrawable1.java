/*
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.graphics;

import com.example.miui.R;

import android.widget.ImageView;
import android.content.res.AssetManager;
import android.os.Bundle;

import miui.app.Activity;
import miui.graphics.drawable.GifAnimationDrawable;

public class GifAnimationDrawable1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.gif_animation_drawable_1);

        final GifAnimationDrawable d = new GifAnimationDrawable();
        d.load(this, getAssets(), "gif/gif_test.gif");

        ImageView imageView = (ImageView)findViewById(R.id.gif_animation);
        imageView.setImageDrawable(d);
        d.start();
    }
}
