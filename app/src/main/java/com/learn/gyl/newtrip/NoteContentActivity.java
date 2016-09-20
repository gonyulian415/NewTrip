package com.learn.gyl.newtrip;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.learn.gyl.newtrip.bean.Note;
import com.learn.gyl.newtrip.presenter.NoteContentPrensenter;
import com.learn.gyl.newtrip.view.INoteCotentView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by admin on 2016/9/19.
 */
public class NoteContentActivity extends BaseActivity implements INoteCotentView{
    NoteContentPrensenter noteContentPrensenter = new NoteContentPrensenter(this,this);
    @BindView(R.id.note_content_edittext)EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_content_layout);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.returnAndSave})
    void onClickEvent(View v){
        switch (v.getId()){
            case R.id.returnAndSave:
                noteContentPrensenter.saveNote();
                Intent intent = new Intent(NoteContentActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
    }

    @Override
    public String getContent() {
        String content = null;
        content = editText.getText().toString();
        if (content == null){
            content = "";
        }
        return content;
    }
}
