package com.example.jyhu.runoobandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import com.example.jyhu.runoobandroid.Adapter.RATestingListViewAdapter;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final List<RATesting> testings = new LinkedList<RATesting>();

        testings.add(new RATesting("ListView数据更新", "com.example.jyhu.runoobandroid.Activities.DataUpdate.DataUpdateListViewActivity", "测试ListView的数据更新"));
        testings.add(new RATesting("反射", "com.example.jyhu.runoobandroid.Activities.Reflection.ReflectionTestActivity", "测试Android中的反射机制"));
        testings.add(new RATesting("可复用的Adapter", "com.example.jyhu.runoobandroid.Activities.ReusefulAdapter.ReusefulAdapterActivity", "构建一个可复用的基础Adapter"));
        testings.add(new RATesting("测试可复用的Adapter", "com.example.jyhu.runoobandroid.Activities.TestCustomAdapter.TestCustomAdapterActivity", "测试使用自定义的可复用的Adapter"));

        mainFunctionList(testings);
    }

    private void mainFunctionList(final List<RATesting> testings) {
        ListView listView = (ListView)findViewById(R.id.main_function_list_view);

        RATestingListViewAdapter testingListViewAdapter = new RATestingListViewAdapter((LinkedList<RATesting>) testings, MainActivity.this);
        listView.setAdapter(testingListViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "clicked " + testings.get(i).getActivityName(), Toast.LENGTH_SHORT).show();

                try {
                    Class cls = Class.forName(testings.get(i).getActivityName());

                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, cls);
                    startActivity(intent);

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
