/**
 * Copyright (C) 2013, Xiaomi Inc. All rights reserved.
 */

package com.example.miui.async;

import miui.app.ListActivity;
import miui.net.http.HttpSession;
import miui.util.async.TaskManager;
import miui.util.async.tasks.HttpBitmapTask;
import miui.util.async.tasks.listeners.ImageViewBindingListener;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.miui.R;

public class HttpBitmapTaskActivity extends ListActivity {

    private final String[] mShotUrls = new String[]{
            "http://ww4.sinaimg.cn/mw690/6b2031fdjw1eb5ad63do0j20hs0hs76h.jpg",
            "http://ww2.sinaimg.cn/mw690/6b2031fdjw1eb2neeq73cj20hs0hsmzf.jpg",
            "http://ww2.sinaimg.cn/mw690/6b2031fdjw1eaydy3avv2j20hs0hsgmn.jpg",
            "http://ww2.sinaimg.cn/mw690/6b2031fdjw1eaqkzsjdcoj20hs0hsn43.jpg",
            "http://ww4.sinaimg.cn/mw690/6b2031fdjw1eaog2qlghjj21kw11sn8m.jpg",
            "http://ww4.sinaimg.cn/mw690/6b2031fdjw1eanbqk8epyj21jk10x7gj.jpg",
            "http://ww4.sinaimg.cn/mw690/6b2031fdjw1eanbr2ovyzj21jk10xe81.jpg",
            "http://ww3.sinaimg.cn/mw690/6b2031fdjw1eanbqcyrxdj210w1jktij.jpg",
            "http://ww1.sinaimg.cn/mw690/6b2031fdjw1eanbqel1unj21jk10wqcf.jpg",
            "http://ww1.sinaimg.cn/mw690/6b2031fdjw1eanbqhtkyaj210x1jke26.jpg",
            "http://ww1.sinaimg.cn/mw690/6b2031fdjw1eam3ass7jhj21kw11s18d.jpg",
            "http://ww3.sinaimg.cn/mw690/6b2031fdjw1eajtaqzfmgj21kw11sgq0.jpg",
            "http://ww4.sinaimg.cn/mw690/415a843atw1e36l05hlvlj.jpg",
            "http://ww2.sinaimg.cn/mw690/415a843atw1e2jtvyp75mj.jpg",
            "http://ww2.sinaimg.cn/mw690/415a843ajw8e24jmzu13ij.jpg",
            "http://ww1.sinaimg.cn/mw690/415a843atw1e0oslzti5qj.jpg",
            "http://ww2.sinaimg.cn/mw690/415a843atw1e0osbugz89j.jpg",
            "http://ww3.sinaimg.cn/mw690/415a843ajw8e0m087kgfuj.jpg",
            "http://ww4.sinaimg.cn/mw690/415a843ajw8dxeuzep1tvj.jpg",
            "http://ww2.sinaimg.cn/mw690/415a843atw1drq7q9y74gj.jpg",
            "http://ww1.sinaimg.cn/mw690/415a843ajw8e7vtasvvwoj20e60e8dgx.jpg",
            "http://ww3.sinaimg.cn/mw690/415a843ajw8e606yps0u3j20hs0hajuc.jpg",
            "http://ww1.sinaimg.cn/mw690/415a843atw1e5560pv989j20ij0rsjvz.jpg",
            "http://ww3.sinaimg.cn/mw690/415a843ajw8e4qd4zwtrxj20hs0h6acf.jpg",
            "http://ww2.sinaimg.cn/mw690/415a843ajw8e4gxhmxyidj20hs0hsjtr.jpg",
            "http://ww3.sinaimg.cn/mw690/415a843ajw8e4gxhaeo4pj20hs0hsq7d.jpg",
            "http://ww3.sinaimg.cn/mw690/415a843ajw8e4gxgkgbqzj20hq0bs0ue.jpg",
            "http://ww3.sinaimg.cn/mw690/6b2031fdjw1ebn3ml0adnj20hs0hsmyq.jpg",
            "http://ww1.sinaimg.cn/mw690/6b2031fdjw1ebkdmqcdtmj21kw2dcnp5.jpg",
            "http://ww2.sinaimg.cn/mw690/6b2031fdjw1ebg5wuelkyj20hs0hs3zi.jpg",
            "http://ww2.sinaimg.cn/mw690/6b2031fdjw1ebekjjho2hj21kw2dl198.jpg",
            "http://ww4.sinaimg.cn/mw690/6b2031fdjw1eba02tj9xvj219c1w8tds.jpg",
            "http://ww1.sinaimg.cn/mw690/6b2031fdjw1eb7u1095g5j21jk15ok41.jpg",
            "http://ww3.sinaimg.cn/mw690/6b2031fdjw1eb5ajsv95cj20hs0hs40m.jpg",
            "http://ww1.sinaimg.cn/mw690/6b2031fdjw1eb5afoapgrj20hs0hsac6.jpg",
            "http://ww4.sinaimg.cn/mw690/6b2031fdjw1eb5aeousavj20hs0hsmyp.jpg"
    };

    private Drawable mPlaceholder = new ColorDrawable(Color.argb(255, 201, 201, 201));

    private Drawable mErrorImage = new ColorDrawable(Color.RED);

    private HttpSession mSession = new HttpSession();

    private TaskManager mTaskManager = new TaskManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();
        ListAdapter adapter = new ListAdapter();
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        mTaskManager.resume();
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                    case SCROLL_STATE_FLING:
                        mTaskManager.pause();
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mTaskManager.shutdown();
    }

    private class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mShotUrls.length;
        }

        @Override
        public String getItem(int position) {
            return mShotUrls[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.listitem_shot, null);
            }
            Holder holder;
            Object holderO = convertView.getTag();
            if (holderO != null) {
                holder = (Holder) holderO;
            } else {
                holder = new Holder(convertView);
                convertView.setTag(holder);
            }

            mTaskManager.add(new HttpBitmapTask(getItem(position))
                    .addListener(new ImageViewBindingListener(holder.mImageView).setErrorDrawable(
                            mErrorImage).setPlaceHolderDrawable(mPlaceholder)));

            return convertView;
        }
    }

    private class Holder {

        private ImageView mImageView;

        private Holder(View convertView) {
            mImageView = (ImageView) convertView.findViewById(R.id.imageView);
        }
    }
}
