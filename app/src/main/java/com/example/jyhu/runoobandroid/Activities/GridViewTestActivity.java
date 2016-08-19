package com.example.jyhu.runoobandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.jyhu.runoobandroid.Activities.TestCustomAdapter.TestApp;
import com.example.jyhu.runoobandroid.Adapter.CustomAdapter;
import com.example.jyhu.runoobandroid.R;

import java.util.ArrayList;
import java.util.List;

public class GridViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view_test);

        List<TestApp> apps = new ArrayList<TestApp>();
        apps.add(new TestApp("微博", R.mipmap.sns_icon_1));
        apps.add(new TestApp("支付宝", R.mipmap.sns_icon_4));
        apps.add(new TestApp("豆瓣", R.mipmap.sns_icon_5));
        apps.add(new TestApp("Qzone", R.mipmap.sns_icon_6));
        apps.add(new TestApp("人人", R.mipmap.sns_icon_7));
        apps.add(new TestApp("开心网", R.mipmap.sns_icon_8));
        apps.add(new TestApp("朋友网", R.mipmap.sns_icon_9));
        apps.add(new TestApp("Facebook", R.mipmap.sns_icon_10));
        apps.add(new TestApp("Twitter", R.mipmap.sns_icon_11));
        apps.add(new TestApp("Evernote", R.mipmap.sns_icon_12));
        apps.add(new TestApp("Google+", R.mipmap.sns_icon_14));
        apps.add(new TestApp("Instagram", R.mipmap.sns_icon_15));
        apps.add(new TestApp("Linkedin", R.mipmap.sns_icon_16));
        apps.add(new TestApp("Email", R.mipmap.sns_icon_18));
        apps.add(new TestApp("Message", R.mipmap.sns_icon_19));
        apps.add(new TestApp("微信", R.mipmap.sns_icon_22));

        CustomAdapter<TestApp> adapter = new CustomAdapter<TestApp>((ArrayList<TestApp>) apps, R.layout.grid_item_test_01_item) {
            @Override
            public void bindView(ViewHolder holder, TestApp obj) {
                holder.setImageResource(R.id.grid_item_test_01_item_icon, obj.getAppIcon());
                holder.setText(R.id.grid_item_test_01_item_name, obj.getAppName());
            }
        };

        GridView gridView = (GridView)findViewById(R.id.grid_view_test_01);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "你点击了第~" + i + "~项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
