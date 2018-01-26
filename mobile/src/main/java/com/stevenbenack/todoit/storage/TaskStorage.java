package com.stevenbenack.todoit.storage;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskStorage {
    private static TaskStorage taskStorage;

    private List<ToDoTask> taskList;
    private Context context;
    private SQLiteDatabase database;

    public static TaskStorage get(Context context){
        if(taskStorage == null){
            taskStorage = new TaskStorage(context);
        }
        return taskStorage;
    }

    private TaskStorage(Context context) {
        context = context.getApplicationContext();
        database = new TaskDbHelper(context).getWritableDatabase();

        taskList = new ArrayList<>();

        for(int i = 0; i < 100; i++){
            ToDoTask task = new ToDoTask();
            task.setTitle("task #" + i);
            task.setDescription("test");
            taskList.add(task);
        }
    }

     public List<ToDoTask> getTodoTasks() {
        return taskList;
    }

    public ToDoTask getToDoTask(UUID id){
        for(ToDoTask task : taskList){
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }
}
