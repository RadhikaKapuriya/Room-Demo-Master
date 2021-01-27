package com.example.pavneet_singh.roomdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pavneet_singh.roomdemo.R;
import com.example.pavneet_singh.roomdemo.notedb.model.Note;

import java.util.List;


public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.BeanHolder> {

    private List<Note> list;
    private Context context;
    private LayoutInflater layoutInflater;
    private OnNoteItemClick onNoteItemClick;

    public NotesAdapter(List<Note> list, Context context) {
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
        this.context = context;
        this.onNoteItemClick = (OnNoteItemClick) context;
    }


    @Override
    public BeanHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.note_list_item, parent, false);
        return new BeanHolder(view);
    }

    @Override
    public void onBindViewHolder(BeanHolder holder, int position) {
        Log.e("bind", "onBindViewHolder: " + list.get(position));
        Log.d("MMM!23","list.get(position).getTitle() = " + list.get(position).getTitle());
        Log.d("MMM!23","list.get(position).getContent() = " + list.get(position).getContent());
        Log.d("MMM!23","list.get(position).getAge() = " + list.get(position).getAge());


        holder.textViewTitle.setText("Employee Name : " + list.get(position).getTitle());
        holder.textViewContent.setText("Manager Name : " + list.get(position).getContent());
        holder.textViewDAte.setText("Employee Joining Date :" + list.get(position).getDate().toString());
        holder.age.setText("Employee Age :" + list.get(position).getAge());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class BeanHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textViewContent,textViewDAte;
        TextView textViewTitle,age;

        public BeanHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textViewContent = itemView.findViewById(R.id.item_text);
            textViewTitle = itemView.findViewById(R.id.tv_title);
            textViewDAte= itemView.findViewById(R.id.date);
            age= itemView.findViewById(R.id.age);
        }

        @Override
        public void onClick(View view) {
            onNoteItemClick.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteItemClick {
        void onNoteClick(int pos);
    }
}