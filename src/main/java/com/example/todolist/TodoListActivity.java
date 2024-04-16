package com.example.todolist;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TodoListActivity extends AppCompatActivity {
    private List<TodoItem> todoList;
    private TodoListAdapter adapter;
    private EditText editTextTask;
    private EditText editTimeTask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        todoList = new ArrayList<>();
        adapter = new TodoListAdapter(todoList);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        editTextTask = findViewById(R.id.edit_text_task);
        editTimeTask = findViewById(R.id.edit_time_task);
        findViewById(R.id.add_button_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTask();
            }
        });

        List<DummyTask.TaskWithTime> dummyTasks = DummyTask.getDummyTasks();
        for (DummyTask.TaskWithTime taskWithTime : dummyTasks) {
            todoList.add(new TodoItem(taskWithTime.getTask(), taskWithTime.getTime()));
        }

        adapter.notifyDataSetChanged();
    }

    private void addTask() {
        String task = editTextTask.getText().toString().trim();
        String time = editTimeTask.getText().toString().trim();

        if (!task.isEmpty() && !time.isEmpty()) {
            todoList.add(new TodoItem(task, time));
            adapter.notifyItemInserted(todoList.size() - 1);
            editTextTask.getText().clear();
            editTextTask.getText().clear();
        }
    }

    public void deleteTask(int position) {
        todoList.remove(position);
        adapter.notifyItemRemoved(position);
    }
}
