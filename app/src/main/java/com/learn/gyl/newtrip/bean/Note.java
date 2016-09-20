package com.learn.gyl.newtrip.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by admin on 2016/9/20.
 */
@DatabaseTable
public class Note {
    @DatabaseField(generatedId = true)
    private int noteId;
    @DatabaseField
    private String lastEditTime;   //最后编辑时间
    @DatabaseField
    private String noteCotent;  //笔记内容

    public Note() {

    }

    public String getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(String lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    public String getNoteCotent() {
        return noteCotent;
    }

    public void setNoteCotent(String noteCotent) {
        this.noteCotent = noteCotent;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
}
