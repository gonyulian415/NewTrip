package com.learn.gyl.newtrip.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.learn.gyl.newtrip.R;
import com.learn.gyl.newtrip.bean.Note;

import java.util.List;

/**
 * Created by admin on 2016/9/22.
 */
public class NoteListAdapter extends BaseAdapter {
    private Context context;
    private List<Note> noteList;
    private LayoutInflater layoutInflater;
    public final class ListItemView{
        public TextView time;
        public TextView content;
    }

    public NoteListAdapter(Context context, List<Note> noteList) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.noteList = noteList;
    }

    @Override
    public int getCount() {
        return noteList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListItemView listItemView = null;
        if (convertView == null){
            listItemView = new ListItemView();
            //获取布局文件
            convertView = layoutInflater.inflate(R.layout.main_listview_item_layout,null);
            //获取控件对象
            listItemView.time = (TextView) convertView.findViewById(R.id.note_time);
            listItemView.content = (TextView) convertView.findViewById(R.id.note_pre);
            //设置控件集到convertView
            convertView.setTag(listItemView);
        }else {
            listItemView = (ListItemView) convertView.getTag();
        }
        //设置控件内容
        listItemView.time.setText(noteList.get(position).getLastEditTime());
        listItemView.content.setText(noteList.get(position).getNoteCotent());
        return convertView;
    }
}
