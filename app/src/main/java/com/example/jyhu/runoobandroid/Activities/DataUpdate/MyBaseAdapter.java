package com.example.jyhu.runoobandroid.Activities.DataUpdate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jyhu.runoobandroid.R;

import java.util.LinkedList;

/**
 * Created by JyHu on 16/8/17.
 */
public class MyBaseAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<TestData> mTestDatas;

    public MyBaseAdapter() {
    }

    public MyBaseAdapter(Context context, LinkedList<TestData> testDatas) {
        this.mContext = context;
        this.mTestDatas = testDatas;
    }

    @Override
    public int getCount() {
        return mTestDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item_data_update_item, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.mImageView = (ImageView)view.findViewById(R.id.list_item_data_update_item_icon);
            viewHolder.mTextView = (TextView) view.findViewById(R.id.list_item_data_update_item_content);

            view.setTag(viewHolder);
        }

        viewHolder.mImageView.setImageResource(mTestDatas.get(i).getImageId());
        viewHolder.mTextView.setText(mTestDatas.get(i).getContent());

        return view;
    }

    private class ViewHolder {
        ImageView mImageView;
        TextView mTextView;
    }

    public void add(TestData testData) {
        if (mTestDatas == null) {
            mTestDatas = new LinkedList<>();
        }
        mTestDatas.add(testData);
        notifyDataSetChanged();
    }

}
