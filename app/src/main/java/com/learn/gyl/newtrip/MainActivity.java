package com.learn.gyl.newtrip;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.learn.gyl.newtrip.adapter.FullyLinearLayoutManager;
import com.learn.gyl.newtrip.adapter.NoteListAdapter;
import com.learn.gyl.newtrip.adapter.NoteListR_Adapter;
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
    private Intent intent;
    private NoteListAdapter noteListAdapter;
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
        intent = getIntent();
        mainPresenter.updateNoteList();
        noteListAdapter = new NoteListAdapter(this,noteList);
        listView.setAdapter(noteListAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                noteListAdapter.notifyDataSetChanged();
                Intent intent = new Intent(MainActivity.this, NoteContentActivity.class);
                //LinearLayout layout = (LinearLayout) listView.getChildAt(position);
                LinearLayout layout = (LinearLayout) listView.getAdapter().getView(position,null,null);
                Log.d("xyz",position+"");
                TextView textView_noteId = (TextView) layout.findViewById(R.id.note_list_id);
                intent.putExtra("noteId", textView_noteId.getText().toString());
                startActivity(intent);
                //Toast.makeText(MainActivity.this,textView_noteId.getText(),Toast.LENGTH_SHORT).show();
            }
        });
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
    public void loadNoteList(List<Note> list) {
        noteList = list;
        if (intent.getStringExtra("noeInit") != null)
        noteListAdapter.notifyDataSetChanged();//problems
    }

}
