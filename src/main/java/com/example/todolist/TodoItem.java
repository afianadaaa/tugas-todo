package com.example.todolist;

public class TodoItem {
    private String task;
    private String time;

    public TodoItem(String task, String time) {
        this.task = task;
        this.time = time;
    }

    public String getTask() {
        return task;
    }

    public String getTime() {
        return time;
    }
}
