/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.graphics;

import miui.app.Activity;
import miui.graphics.BitmapFactory;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

import com.example.miui.R;

public class ComposeBitmapActivity extends Activity {
    private ImageView mDestImageView;
    private ImageView mSrcImageView;
    private ImageView mPhotoImgView;
    private ImageView mPhotoImgWidthView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bitmap bitmap = Bitmap.createBitmap(200, 200, Bitmap.Config.ARGB_8888);
        InputStream is = getResources().openRawResource(R.raw.imageutils);
        Bitmap srcImage = android.graphics.BitmapFactory.decodeStream(is);
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Canvas canvas = new Canvas(bitmap);
        setContentView(R.layout.create_photo_activity);

        mDestImageView = (ImageView) findViewById(R.id.dst_img);
        mSrcImageView = (ImageView) findViewById(R.id.src_img);
        mPhotoImgView = (ImageView) findViewById(R.id.photo_img);
        mPhotoImgWidthView = (ImageView) findViewById(R.id.photo_img_width);
        mSrcImageView.setImageBitmap(srcImage);
        BitmapFactory.maskOutBitmap(srcImage, getResources().getDrawable(R.drawable.photo_mask), bitmap, null, null);
        BitmapFactory.composeBitmap(srcImage, bitmap, getResources().getDrawable(R.drawable.photo_mask),
                getResources().getDrawable(R.drawable.photo_fg), getResources().getDrawable(R.drawable.photo_bg), null,
                null);
        mDestImageView.setImageBitmap(bitmap);
        mPhotoImgView.setImageBitmap(BitmapFactory.createPhoto(this, srcImage));
        mPhotoImgWidthView.setImageBitmap(BitmapFactory.createPhoto(this, srcImage, 200));
    }
}
