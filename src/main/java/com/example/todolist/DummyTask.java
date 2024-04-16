package com.example.todolist;

import java.util.ArrayList;
import java.util.List;

public class DummyTask {
    public static List<TaskWithTime> getDummyTasks() {
        List<TaskWithTime> tasks = new ArrayList<>();
        tasks.add(new TaskWithTime("Pray", "04:10 AM"));
        tasks.add(new TaskWithTime("Breakfast", "06:10 AM"));
        tasks.add(new TaskWithTime("Study", "08:40 AM"));
        tasks.add(new TaskWithTime("Lunch", "11:59 PM"));
        tasks.add(new TaskWithTime("Play", "13:25 PM"));
        tasks.add(new TaskWithTime("Poo", "18:00 PM"));
        tasks.add(new TaskWithTime("Sleep", "21:10 PM"));
        return tasks;
    }

    public static class TaskWithTime {
        private String task;
        private String time;

        public TaskWithTime(String task, String time) {
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
}
