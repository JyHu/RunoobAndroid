package com.example.jyhu.runoobandroid.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

import com.example.jyhu.runoobandroid.MainActivity;
import com.example.jyhu.runoobandroid.R;

public class AutoCompleteTextViewTestActivity extends AppCompatActivity {

    private static final String[] data = new String[]{
            "x小猪猪", "x小狗狗", "x小鸡鸡", "x小猫猫", "x小咪咪"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_text_view_test);

        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.auto_complete_text_view_01);
        MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView)findViewById(R.id.muti_auto_complete_text_view_01);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AutoCompleteTextViewTestActivity.this, android.R.layout.simple_dropdown_item_1line, data);
        autoCompleteTextView.setAdapter(arrayAdapter);

        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_dropdown_item_1line, data);
        multiAutoCompleteTextView.setAdapter(arrayAdapter1);
        multiAutoCompleteTextView.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
