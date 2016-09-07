package com.learn.gyl.newtrip;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.learn.gyl.newtrip.bean.Person;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class WelcomeActivity extends AppCompatActivity {
    @BindView(R.id.testbtn)Button button;
    @BindView(R.id.test_textview)TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        Bmob.initialize(this, "d418c1a9f8573ebe4668ba51cd541ac3");
        ButterKnife.bind(this);
        Person person = new Person();
        person.setAge(18);
        person.setName("ray");
        person.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if (e == null){
                    Snackbar.make(textView,s,Snackbar.LENGTH_SHORT).show();
                }else {
                    Snackbar.make(textView,e.toString(),Snackbar.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.testbtn)void testButterknife(View view){
        Snackbar.make(view,"is ok",Snackbar.LENGTH_SHORT).show();
    }
}
