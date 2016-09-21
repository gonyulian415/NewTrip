package com.learn.gyl.newtrip;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.learn.gyl.newtrip.bean.Note;
import com.learn.gyl.newtrip.bean.Person;
import com.learn.gyl.newtrip.dao.PersonDao;
import com.learn.gyl.newtrip.presenter.MainPresenter;
import com.learn.gyl.newtrip.view.IMainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/9/13.
 */
public class MainActivity extends BaseActivity implements IMainView{
    @BindView(R.id.note_list)ListView listView;
    private MainPresenter mainPresenter = new MainPresenter(this,this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
        mainPresenter.updateNoteList();
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

    @Override
    public void updateNoteList(List<String> list) {
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));
    }
}
