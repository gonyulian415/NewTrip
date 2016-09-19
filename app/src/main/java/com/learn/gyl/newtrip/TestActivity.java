package com.learn.gyl.newtrip;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by admin on 2016/9/18.
 */
public class TestActivity extends BaseActivity {
    @BindView(R.id.testbtn)Button button;
    @BindView(R.id.test_textview)TextView textView;
    @BindView(R.id.test_edittext)EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);
    }
}
