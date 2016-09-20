package com.learn.gyl.newtrip.presenter;

import android.content.Context;

import com.learn.gyl.newtrip.bean.Note;
import com.learn.gyl.newtrip.dao.NoteDao;
import com.learn.gyl.newtrip.view.INoteCotentView;

import java.text.SimpleDateFormat;

/**
 * Created by admin on 2016/9/20.
 */
public class NoteContentPrensenter {
    private INoteCotentView iNoteCotentView;
    private Context context;

    public NoteContentPrensenter(INoteCotentView iNoteCotentView,Context context) {
        this.iNoteCotentView = iNoteCotentView;
        this.context = context;
    }

    public void saveNote(){
        String content = iNoteCotentView.getContent();
        NoteDao noteDao = new NoteDao(context);
        Note note = new Note();
        note.setNoteCotent(content);
        note.setLastEditTime(new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss").format(new java.util.Date()));
        noteDao.saveNote(note);
    }
}
