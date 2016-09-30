package com.learn.gyl.newtrip.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.learn.gyl.newtrip.R;
import com.learn.gyl.newtrip.bean.Note;

import java.util.List;

/**
 * Created by admin on 2016/9/26.
 */
public class NoteListR_Adapter extends RecyclerView.Adapter<NoteListR_Adapter.MyViewHolder> {
    private List<Note> noteList;
    private Context context;
    private LayoutInflater layoutInflater;

    public NoteListR_Adapter(Context context,List<Note> noteList) {
        this.noteList = noteList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.main_recycleview_item_layout,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.time.setText(noteList.get(position).getLastEditTime());
        holder.content.setText(noteList.get(position).getNoteCotent());
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView time;
        TextView content;
        public MyViewHolder(View itemView) {
            super(itemView);
            time = (TextView) itemView.findViewById(R.id.note_edittime1);
            content = (TextView) itemView.findViewById(R.id.note_content1);
        }
    }
}
