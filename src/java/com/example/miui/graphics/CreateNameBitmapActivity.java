package com.example.miui.graphics;

import miui.app.Activity;
import miui.graphics.BitmapFactory;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.miui.R;

public class CreateNameBitmapActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_name_bitmap_activity);
        Bitmap bmp = BitmapFactory.createNameBitmap(this, "王二牛", 143);
        ImageView v = (ImageView) findViewById(R.id.img_v_1);
        v.setBackgroundColor(0xff000000);
        v.setImageBitmap(bmp);
        bmp = BitmapFactory.createNameBitmap(this, "Jack Jones", 143);
        v = (ImageView) findViewById(R.id.img_v_2);
        v.setBackgroundColor(0xff000000);
        v.setImageBitmap(bmp);
    }
}
