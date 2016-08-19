package com.example.jyhu.runoobandroid.Activities.TestCustomAdapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.jyhu.runoobandroid.Adapter.CustomAdapter;
import com.example.jyhu.runoobandroid.R;

import java.util.ArrayList;
import java.util.List;

public class TestCustomAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_custom_adapter);

        List<TestApp> apps = new ArrayList<TestApp>();
        apps.add(new TestApp("微博", R.mipmap.sns_icon_1));
        apps.add(new TestApp("支付宝", R.mipmap.sns_icon_4));
        apps.add(new TestApp("豆瓣", R.mipmap.sns_icon_5));
        apps.add(new TestApp("Qzone", R.mipmap.sns_icon_6));
        apps.add(new TestApp("人人", R.mipmap.sns_icon_7));
        apps.add(new TestApp("开心网", R.mipmap.sns_icon_8));
        apps.add(new TestApp("朋友网", R.mipmap.sns_icon_9));

        List<TestBooks> bookses = new ArrayList<TestBooks>();
        bookses.add(new TestBooks("《第一行代码》", "郭霖"));
        bookses.add(new TestBooks("《Android群英传》", "徐宜生"));
        bookses.add(new TestBooks("《Android开发艺术探索》", "任玉刚"));
        bookses.add(new TestBooks("《宽容》", "房龙"));
        bookses.add(new TestBooks("《小王子》", "艾克泽"));
        bookses.add(new TestBooks("《情人》", "王道乾"));
        bookses.add(new TestBooks("《今生的五百次回眸》", "毕淑敏"));
        bookses.add(new TestBooks("《真话能走多远》", "季羡林"));
        bookses.add(new TestBooks("《偷时光的女人》", "阿黛拉 海尔帕"));

        CustomAdapter<TestApp> appsAdapter = new CustomAdapter<TestApp>((ArrayList)apps, R.layout.list_item_test_custom_adapter_apps_item) {
            @Override
            public void bindView(ViewHolder holder, TestApp obj) {
                holder.setImageResource(R.id.list_item_test_custom_adapter_apps_item_icon, obj.getAppIcon());
                holder.setText(R.id.list_item_test_custom_adapter_apps_item_name, obj.getAppName());
            }
        };

        CustomAdapter<TestBooks> booksAdapter = new CustomAdapter<TestBooks>((ArrayList)bookses, R.layout.list_item_test_custom_adapter_books_item) {
            @Override
            public void bindView(ViewHolder holder, TestBooks obj) {
                holder.setText(R.id.list_item_test_custom_adapter_book_item_name, obj.getBookName());
                holder.setText(R.id.list_item_test_custom_adapter_book_item_author, obj.getBookAuthor());
            }

        };

        ListView appListView = (ListView)findViewById(R.id.test_custom_adapter_apps_list_view);
        appListView.setAdapter(appsAdapter);

        ListView bookListView = (ListView)findViewById(R.id.test_custom_adapter_books_list_view);
        bookListView.setAdapter(booksAdapter);
    }
}
