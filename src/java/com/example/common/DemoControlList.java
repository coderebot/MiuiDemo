/**
 *
 */

package com.example.common;

import miui.reflect.Method;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.example.miui.R;

public class DemoControlList extends ListView {

    private static class MethodInvoker implements Runnable {
        Object object;
        Method method;
        Object[] args;

        @Override
        public void run() {
            method.invoke(object.getClass(), object, args);
        }

        MethodInvoker(Object object, Method method, Object ...args) {
            this.object = object;
            this.method = method;
            this.args = args;
        }
    }

    /**
     * create a runable for Item
     * @param obj
     * @param method the method must no param and not result
     * @return
     */
    public static Runnable createRunnable(Object obj, String method, String signature, Object ...args) {
        Class<?> clazz = obj.getClass();
        Method m = Method.of(clazz, method, signature);
        return new MethodInvoker(obj, m, args);
    }

    public static Runnable createRunnable(Object obj, Method method, Object ...args) {
        return new MethodInvoker(obj, method, args);
    }

    public static interface ItemFilter {
        public int getItemPosition(int pos);
        public int getItemCount();
    }

    private ItemFilter mItemFilter;


    public static class Item {
        public String title;
        public String summary;
        public String codes;
        public String styles;
        public Runnable command;
    }

    static class ItemHolder implements OnClickListener{
        Item mItem;
        TextView mTitle;
        TextView mSummary;
        TextView mCodes;
        TextView mStyles;
        ViewGroup mSourceContainer;
        Button mExpandSource;
        Button mCommand;
        ItemHolder(ViewGroup vg) {
            mTitle = (TextView)vg.findViewById(android.R.id.text1);
            mSummary = (TextView)vg.findViewById(android.R.id.summary);
            mCodes = (TextView)vg.findViewById(R.id.codes);
            mStyles = (TextView)vg.findViewById(R.id.styles);
            Button btn = (Button)vg.findViewById(R.id.expand_source);
            btn.setBackgroundResource(R.drawable.btn_inline_expand_light);
            btn.setOnClickListener(this);
            mExpandSource = btn;
            mCommand = ((Button)vg.findViewById(R.id.do_command));
            mCommand.setOnClickListener(this);
            mSourceContainer = (ViewGroup)vg.findViewById(R.id.source_container);
            vg.setTag(this);
        }

        static ItemHolder from(View vg) {
            return (ItemHolder)vg.getTag();
        }

        private void setOptionText(TextView view, String text) {
            if (text != null) {
                view.setText(text);
                view.setVisibility(View.VISIBLE);
            } else {
                view.setVisibility(View.GONE);
            }
        }

        void attach(Item item) {
            if (mItem == item) {
                return ;
            }

            mItem = item;
            mTitle.setText(mItem.title);
            setOptionText(mSummary, mItem.summary);
            setOptionText(mCodes, mItem.codes);
            setOptionText(mStyles, mItem.styles);
            mCommand.setVisibility(mItem.command != null ? View.VISIBLE : View.GONE);
            mSourceContainer.setVisibility(View.GONE);
            mExpandSource.setBackgroundResource(R.drawable.btn_inline_expand_light);
        }

        @Override
        public void onClick(View view) {
            if (mItem == null) {
                return ;
            }

            if (view.getId() == R.id.expand_source) {
                if (mSourceContainer.getVisibility() == View.GONE) {
                    mSourceContainer.setVisibility(View.VISIBLE);
                    mExpandSource.setBackgroundResource(R.drawable.btn_inline_shrink_light);
                    //show code and style
                    if (mItem.codes != null) {
                        Log.i("DEMO-STYLE", mItem.codes);
                    }
                    if (mItem.styles != null) {
                        Log.i("DEMO-STYLE", mItem.styles);
                    }
                } else {
                    mSourceContainer.setVisibility(View.GONE);
                    mExpandSource.setBackgroundResource(R.drawable.btn_inline_expand_light);
                }
            } else if (view.getId() == R.id.do_command) {
                if (mItem.command != null) {
                    mItem.command.run();
                }
            }
        }
    }

    List<Item> mItems = new ArrayList<Item>();

    class Adapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mItemFilter != null ? mItemFilter.getItemCount() : mItems.size();
        }

        @Override
        public Object getItem(int i) {
            return mItems.get(mItemFilter != null ? mItemFilter.getItemPosition(i) : i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int pos, View view, ViewGroup viewGroup) {
            ItemHolder holder;
            Item item = mItems.get(pos);
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.demo_control_item, null);
                holder = new ItemHolder((ViewGroup)view);
            } else {
                holder = ItemHolder.from(view);
            }
            holder.attach(item);
            return view;
        }
    }

    Adapter mAdapter;

    private void init() {
        mAdapter = new Adapter();
        setAdapter(mAdapter);
    }

    public DemoControlList(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DemoControlList(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public void addItem(String title, String summary, String codes, String styles, Runnable command) {
        Item item = new Item();
        item.title = title;
        item.summary = summary;
        item.command = command;
        item.codes = codes;
        item.styles = styles;
        mItems.add(item);
    }

    public List<Item> getItems() {
        return mItems;
    }

    public void setItems(List<Item> items) {
        mItems.clear();
        for (int i = 0; i < items.size(); i ++) {
            mItems.add(items.get(i));
            update();
        }
    }

    public void setItemFilter(ItemFilter filter) {
        mItemFilter = filter;
    }

    public void update() {
        mAdapter.notifyDataSetChanged();
    }

}