/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.graphics;

import miui.app.Activity;
import miui.graphics.BitmapFactory;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.InputStream;

import com.example.miui.R;

public class CropImageActivity extends Activity {
    private ImageView mSrcImage;
    private ImageView mCropImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crop_image_activity);
        mSrcImage = (ImageView) findViewById(R.id.src_img);
        mCropImage = (ImageView) findViewById(R.id.crop_img);
        InputStream is = getResources().openRawResource(R.raw.imageutils);
        Bitmap srcImage = android.graphics.BitmapFactory.decodeStream(is);
        mSrcImage.setImageBitmap(srcImage);
        BitmapFactory.CropOption option = new BitmapFactory.CropOption(50, 50, 20, 0xff00ff00);
        option.srcBmpDrawingArea = new Rect(150, 150, srcImage.getWidth() - 150, srcImage.getHeight() - 150);
        Bitmap cropImage = BitmapFactory.cropBitmap(srcImage, option);
        mCropImage.setImageBitmap(cropImage);
    }
}