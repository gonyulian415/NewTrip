package com.learn.gyl.newtrip.presenter;

import android.content.Context;

import com.learn.gyl.newtrip.bean.Note;
import com.learn.gyl.newtrip.dao.NoteDao;
import com.learn.gyl.newtrip.view.IMainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/21.
 */
public class MainPresenter {
    private IMainView iMainView;
    private Context context;

    public MainPresenter(IMainView iMainView,Context context) {
        this.iMainView = iMainView;
        this.context = context;
    }

    public void updateNoteList(){
        NoteDao noteDao = new NoteDao(context);
        List<Note> noteList = noteDao.loadNote();
        if (noteList.isEmpty()){
            //第一个便签
        }
        List<String> contentList = new ArrayList<String>();
        for (Note note : noteList){
            contentList.add(note.getNoteCotent());
        }
        iMainView.loadNoteList(noteList);
    }
}
