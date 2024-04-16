package com.example.todolist;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TodoListAdapter extends RecyclerView.Adapter<TodoListAdapter.TodoViewHolder> {
    private List<TodoItem> todoList;

    public TodoListAdapter(List<TodoItem> todoList) {
        this.todoList = todoList;
    }

    static class TodoViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final TextView timeView;
        private final ImageView deleteButton;

        public TodoViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.edit_text_task);
            timeView = itemView.findViewById(R.id.edit_time_task);
            deleteButton = itemView.findViewById(R.id.delete);

            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        ((TodoListActivity) itemView.getContext()).deleteTask(position);
                    }
                }
            });
        }

        public void bind(TodoItem currentItem) {
            textView.setText(currentItem.getTask());
            timeView.setText(currentItem.getTime());
        }
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_todo, parent, false);
        return new TodoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        TodoItem currentItem = todoList.get(position);
        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }
}
