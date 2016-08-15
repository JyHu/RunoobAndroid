package com.example.jyhu.runoobandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jyhu.runoobandroid.R;
import com.example.jyhu.runoobandroid.RATesting;

import java.util.LinkedList;

/**
 * Created by JyHu on 16/8/15.
 */
public class RATestingListViewAdapter extends BaseAdapter {

    private LinkedList<RATesting> testings;
    private Context context;

    public RATestingListViewAdapter(LinkedList<RATesting> testings, Context context) {
        this.testings = testings;
        this.context = context;
    }

    @Override
    public int getCount() {
        return testings.size();
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
            view = LayoutInflater.from(context).inflate(R.layout.list_item_main_function_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.textViewFunctionName = (TextView)view.findViewById(R.id.list_item_main_function_item_function_name);
            viewHolder.textViewFunctionDetail = (TextView)view.findViewById(R.id.list_item_main_function_item_function_detail);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.testing = testings.get(i);
        viewHolder.textViewFunctionName.setText(viewHolder.testing.getTestName());
        viewHolder.textViewFunctionDetail.setText(viewHolder.testing.getTestDetail());

        return view;
    }

    static class ViewHolder {
        TextView textViewFunctionName;
        TextView textViewFunctionDetail;
        RATesting testing;
    }
}
