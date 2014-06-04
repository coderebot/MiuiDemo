/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.graphics;

import miui.app.Activity;
import miui.graphics.BitmapFactory;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import com.example.miui.R;

public class FastBlurActivity extends Activity {
    private ImageView mSrcImage;
    private ImageView mBlureImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fast_blur_activity);
        mSrcImage = (ImageView) findViewById(R.id.src_img);
        mBlureImage = (ImageView) findViewById(R.id.blur_img);
        InputStream is = getResources().openRawResource(R.raw.blur);
        Bitmap srcImage = android.graphics.BitmapFactory.decodeStream(is);
        mSrcImage.setImageBitmap(srcImage);
        Bitmap blureImage = BitmapFactory.fastBlur(srcImage, 10);
        mBlureImage.setImageBitmap(blureImage);
    }
}
