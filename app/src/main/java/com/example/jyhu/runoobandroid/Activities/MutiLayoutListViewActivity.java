package com.example.jyhu.runoobandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.jyhu.runoobandroid.Activities.TestCustomAdapter.TestApp;
import com.example.jyhu.runoobandroid.Activities.TestCustomAdapter.TestBooks;
import com.example.jyhu.runoobandroid.Adapter.MutiLayoutAdapter;
import com.example.jyhu.runoobandroid.R;

import java.util.ArrayList;

public class MutiLayoutListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muti_layout_list_view);

        ArrayList<Object> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            switch ((int)(Math.random() * 2)) {
                case 0:
                    objects.add(new TestBooks("《第一行代码》", "郭霖"));
                    break;
                case 1:
                    objects.add(new TestApp("朋友网", R.mipmap.sns_icon_9));
                    break;
            }
        }

        System.out.println(objects);
        ListView listView = (ListView)findViewById(R.id.muti_layout_test_list_view);
        listView.setAdapter(new MutiLayoutAdapter(MutiLayoutListViewActivity.this, objects));
    }
}
