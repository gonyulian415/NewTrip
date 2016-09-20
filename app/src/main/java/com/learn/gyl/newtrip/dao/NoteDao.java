package com.learn.gyl.newtrip.dao;

import android.content.Context;
import android.util.Log;

import com.j256.ormlite.dao.Dao;
import com.learn.gyl.newtrip.bean.Note;
import com.learn.gyl.newtrip.utils.DatabaseHelper;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/9/20.
 */
public class NoteDao {
    private Context context;
    private Dao<Note,Integer> dao;
    private DatabaseHelper databaseHelper;

    public NoteDao(Context context) {
        this.context = context;
        databaseHelper = DatabaseHelper.getDatabaseHelper(context);
        dao = databaseHelper.getDao(Note.class);
    }

    public void saveNote(Note note){
        try {
            dao.create(note);       //保存便签
            Log.d("xyz", "save note succeed");
        } catch (SQLException e) {
            e.printStackTrace();
            Log.d("xyz", "save note fail");
        }
    }

    public List<Note> loadNote(){
        List<Note> list = null;
        try {
            list = dao.queryBuilder().query();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (list == null){
            list = new ArrayList<Note>();
        }
        return list;
    }
}
