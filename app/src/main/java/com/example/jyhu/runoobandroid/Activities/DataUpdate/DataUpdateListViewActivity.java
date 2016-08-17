package com.example.jyhu.runoobandroid.Activities.DataUpdate;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jyhu.runoobandroid.R;

import org.w3c.dom.Text;

import java.util.LinkedList;
import java.util.List;


public class DataUpdateListViewActivity extends AppCompatActivity implements View.OnClickListener {


    private ListView mListView;
    private MyBaseAdapter mMyBaseAdapter = null;
    private List<TestData> mTestDatas = null;
    private Context mContext = null;
    private TextView mTipTextView =null;
    private int flag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_update_list_view);

        bindViews();

        mContext = DataUpdateListViewActivity.this;
        mTestDatas = new LinkedList<>();
        mMyBaseAdapter = new MyBaseAdapter(mContext, (LinkedList<TestData>)mTestDatas);
        mListView.setAdapter(mMyBaseAdapter);
        mListView.setEmptyView(mTipTextView);

        Button insetOneDataButton = (Button)findViewById(R.id.data_update_list_view_add_1_data_button);
        insetOneDataButton.setOnClickListener(this);
    }

    private void bindViews() {
        mListView = (ListView)findViewById(R.id.data_update_list_view);
        mTipTextView = (TextView)findViewById(R.id.data_update_list_view_empty_tip_view);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.data_update_list_view_add_1_data_button:
            {
                mMyBaseAdapter.add(new TestData(R.mipmap.sns_icon_1, "hello 你好" + flag));
                flag ++;
            }
                break;
        }
    }
}
