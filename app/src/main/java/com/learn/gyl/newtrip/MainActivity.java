package com.learn.gyl.newtrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.learn.gyl.newtrip.bean.Person;
import com.learn.gyl.newtrip.dao.PersonDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/9/13.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.writeNote})
    void clickEvent(View view){
        switch (view.getId()){
            case R.id.writeNote:
                Intent intent = new Intent(MainActivity.this,NoteContentActivity.class);
                startActivity(intent);
                break;
        }
    }

}
