package com.example.jyhu.runoobandroid.Adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by JyHu on 16/8/18.
 */
public abstract class CustomAdapter<T> extends BaseAdapter {

    private ArrayList<T> mDatas;
    private int mLayoutRes; // 布局id

    /**
     * 无参构造方法
     */
    public CustomAdapter() {
    }

    /**
     * 有参构造方法
     * @param datas         数据源
     * @param layoutRes     item布局样式
     */
    public CustomAdapter(ArrayList<T> datas, int layoutRes) {
        mDatas = datas;
        mLayoutRes = layoutRes;
    }

    /**
     * listview中item的个数
     * @return  item个数
     */
    @Override
    public int getCount() {
        return mDatas != null ? mDatas.size() : 0;
    }

    /**
     * 返回索引i位置的数据
     * @param i 索引
     * @return  返回类型是一个泛型，说明这里可以返回任何数据，在调用这个方法的时候需要进行强转
     */
    @Override
    public T getItem(int i) {
        return mDatas.get(i);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    /**
     * 获取每个item
     * @param i         item索引
     * @param view      item所在的视图
     * @param viewGroup 父视图
     * @return  item
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        /**
         * 将当前item跟holder关联起来
         */
        ViewHolder holder = ViewHolder.bind(viewGroup.getContext(), view, viewGroup, mLayoutRes, i);
        bindView(holder, getItem(i));

        return holder.getItemView();
    }

    public abstract void bindView(ViewHolder holder, T obj);

    /**
     * 添加一个元素并刷新ListView
     * @param data
     */
    public void add(T data) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        mDatas.add(data);
        notifyDataSetChanged();
    }

    /**
     * 在指定位置添加一个元素
     * @param position
     * @param data
     */
    public void add(int position, T data) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }

        if (mDatas.size() < position) {
            return;
        }

        mDatas.add(position, data);
    }

    /**
     * 移除一个元素
     * @param data
     */
    public void remove(T data) {
        if (mDatas != null) {
            mDatas.remove(data);
            notifyDataSetChanged();
        }
    }

    /**
     * 移除指定位置的元素
     * @param position
     */
    public void remove(int position) {
        if (mDatas != null && mDatas.size() - 1 >= position) {
            mDatas.remove(position);
            notifyDataSetChanged();
        }
    }

    /**
     * 清空所有数据
     */
    public void clear() {
        if (mDatas != null) {
            mDatas.clear();
            notifyDataSetChanged();
        }
    }

    public static class ViewHolder {
        private SparseArray<View> mViews;       // 存储ListView的item中的view
        private View item;                      // 存放convertView
        private int position;                   // 索引
        private Context context;                // 上下文

        /**
         * 构造方法，完成相关初始化
         * @param context       上下文
         * @param parent        父视图
         * @param layoutRes     item布局样式
         */
        private ViewHolder(Context context, ViewGroup parent, int layoutRes) {
            mViews = new SparseArray<>();
            this.context = context;
            View convertView = LayoutInflater.from(context).inflate(layoutRes, parent, false);
            convertView.setTag(this);
            item = convertView;
        }

        /**
         * 绑定ViewHolder与item
         * @param context       上下文
         * @param convertView   item的视图
         * @param parent        父视图
         * @param layoutRes     布局样式
         * @param position      当前item的索引
         * @return
         */
        public static ViewHolder bind(Context context, View convertView, ViewGroup parent, int layoutRes, int position) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder(context, parent, layoutRes);
            } else {
                holder = (ViewHolder)convertView.getTag();
                holder.item = convertView;
            }

            holder.position = position;
            return holder;
        }

        @SuppressWarnings("unchecked")
        public <T extends View> T getView(int id) {
            T  t = (T)mViews.get(id);
            if (t == null) {
                t = (T)item.findViewById(id);
                mViews.put(id, t);
            }

            return t;
        }

        /**
         * 获取当前条目
         */
        public View getItemView() {
            return item;
        }

        /**
         * 获取当前位置
         */
        public int getItemPosition() {
            return position;
        }

        /**
         * 设置文字内容
         */
        public ViewHolder setText(int id, CharSequence text) {
            View view = getView(id);
            if (view instanceof TextView) {
                ((TextView)view).setText(text);
            }

            return this;
        }

        /**
         * 设置图片内容
         */
        public ViewHolder setImageResource(int id, int drawableRes) {
            View view = getView(id);
            if (view instanceof ImageView) {
                ((ImageView)view).setImageResource(drawableRes);
            } else {
                view.setBackgroundResource(drawableRes);
            }

            return this;
        }

        /**
         * 设置点击监听
         */
        public ViewHolder setOnClickListener(int id, View.OnClickListener listener) {
            getView(id).setOnClickListener(listener);
            return this;
        }

        /**
         * 设置可见
         */
        public ViewHolder setVisibility(int id, int visiable) {
            getView(id).setVisibility(visiable);
            return this;
        }

        /**
         * 设置标签
         */
        public ViewHolder setTag(int id, Object obj) {
            getView(id).setTag(obj);
            return this;
        }

    }
}
























