package com.learn.gyl.newtrip.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

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
        if (!("".equals(content) || "".equals(content.trim()))){    //内容为空或者全为空格时不保存便签
            NoteDao noteDao = new NoteDao(context);
            Note note = new Note();
            note.setNoteCotent(content);
            note.setLastEditTime(new SimpleDateFormat("yyyy-MM-dd    HH:mm:ss").format(new java.util.Date()));
            noteDao.saveNote(note);
        }else {
            Log.d("xyz","content is empty");
        }
    }

    public void initNoteContent(String s){
        if (s != null){
            NoteDao noteDao = new NoteDao(context);
            String content = noteDao.getNoteContent(s);
            iNoteCotentView.setCotent(content);
        }
    }
}
