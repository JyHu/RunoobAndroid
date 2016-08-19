package com.example.jyhu.runoobandroid.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jyhu.runoobandroid.Activities.TestCustomAdapter.TestApp;
import com.example.jyhu.runoobandroid.Activities.TestCustomAdapter.TestBooks;
import com.example.jyhu.runoobandroid.R;

import java.util.ArrayList;

/**
 * Created by JyHu on 16/8/19.
 */
public class MutiLayoutAdapter extends BaseAdapter {

    private static final int TYPE_BOOK = 0;
    private static final int TYPE_APP = 1;

    private Context mContext;
    private ArrayList<Object> mObjects = null;


    public MutiLayoutAdapter() {
    }

    public MutiLayoutAdapter(Context context, ArrayList<Object> objects) {
        mContext = context;
        mObjects = objects;
    }

    @Override
    public int getCount() {
        return mObjects.size();
    }

    @Override
    public Object getItem(int i) {
        return mObjects.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (mObjects.get(position) instanceof TestApp)
            return TYPE_APP;
        else if (mObjects.get(position) instanceof TestBooks)
            return TYPE_BOOK;
        else
            return super.getItemViewType(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int type = getItemViewType(i);
        ViewHolderApps appsHolder = null;
        ViewHolderBooks booksHolder = null;
        if (view == null) {
            switch (type) {
                case TYPE_APP:
                    appsHolder = new ViewHolderApps();
                    view = LayoutInflater.from(mContext).inflate(R.layout.list_item_test_custom_adapter_apps_item, viewGroup,false);
                    appsHolder.appIcon = (ImageView)view.findViewById(R.id.list_item_test_custom_adapter_apps_item_icon);
                    appsHolder.appName = (TextView)view.findViewById(R.id.list_item_test_custom_adapter_apps_item_name);
                    view.setTag(R.id.muti_adapter_item_tag_app, appsHolder);
                    break;

                case TYPE_BOOK:
                    booksHolder = new ViewHolderBooks();
                    view = LayoutInflater.from(mContext).inflate(R.layout.list_item_test_custom_adapter_books_item, viewGroup, false);
                    booksHolder.bookName = (TextView)view.findViewById(R.id.list_item_test_custom_adapter_book_item_name);
                    booksHolder.bookAuthor = (TextView)view.findViewById(R.id.list_item_test_custom_adapter_book_item_author);
                    view.setTag(R.id.muti_adapter_item_tag_book, booksHolder);
                    break;
            }
        } else {
            switch (type) {
                case TYPE_APP:
                    appsHolder = (ViewHolderApps) view.getTag(R.id.muti_adapter_item_tag_app);
                    break;
                case TYPE_BOOK:
                    booksHolder = (ViewHolderBooks)view.getTag(R.id.muti_adapter_item_tag_book);
                    break;
            }
        }

        Object object = mObjects.get(i);
        switch (type) {
            case TYPE_APP:
                TestApp app = (TestApp)object;
                if (app != null && appsHolder != null && appsHolder.validate()){
                    appsHolder.appIcon.setImageResource(app.getAppIcon());
                    appsHolder.appName.setText(app.getAppName());
                }
                break;
            case TYPE_BOOK:
                TestBooks books = (TestBooks) object;
                if (books != null && booksHolder != null && booksHolder.validate()) {
                    booksHolder.bookName.setText(books.getBookName());
                    booksHolder.bookAuthor.setText(books.getBookAuthor());
                }
                break;
        }

        return view;
    }

    private static class ViewHolderApps {
        ImageView appIcon;
        TextView appName;

        public boolean validate() {
            return appIcon != null && appName != null;
        }
    }

    private static class ViewHolderBooks {
        TextView bookName;
        TextView bookAuthor;

        public boolean validate() {
            return bookName != null && bookAuthor != null;
        }
    }
}
