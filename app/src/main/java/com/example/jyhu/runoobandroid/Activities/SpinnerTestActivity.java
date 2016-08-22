package com.example.jyhu.runoobandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jyhu.runoobandroid.Activities.TestCustomAdapter.TestApp;
import com.example.jyhu.runoobandroid.Adapter.CustomAdapter;
import com.example.jyhu.runoobandroid.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerTestActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_test);

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

        Spinner spinnerLOL = (Spinner)findViewById(R.id.spinner_test_lol_level);
        Spinner spinnerApps = (Spinner)findViewById(R.id.spinner_test_app_icon);

        CustomAdapter adapter = new CustomAdapter<TestApp>((ArrayList<TestApp>) apps, R.layout.list_item_test_custom_adapter_apps_item) {
            @Override
            public void bindView(ViewHolder holder, TestApp app) {
                holder.setImageResource(R.id.list_item_test_custom_adapter_apps_item_icon, app.getAppIcon());
                holder.setText(R.id.list_item_test_custom_adapter_apps_item_name, app.getAppName());
            }
        };

        spinnerApps.setAdapter(adapter);

        spinnerLOL.setOnItemSelectedListener(this);
        spinnerApps.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.spinner_test_lol_level:
                Toast.makeText(getApplicationContext(), "lol " + i, Toast.LENGTH_SHORT).show();
                break;

            case R.id.spinner_test_app_icon:
                TextView textView = (TextView)view.findViewById(R.id.list_item_test_custom_adapter_apps_item_name);
                Toast.makeText(getApplicationContext(), "您选择的书是" + textView.getText(), Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
