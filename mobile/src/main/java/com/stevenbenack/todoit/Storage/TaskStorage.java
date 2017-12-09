package com.stevenbenack.todoit.Storage;


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

    private TaskStorage(Context context) {
        context = context.getApplicationContext();
        database = new TaskDbHelper(context).getWritableDatabase();

        taskList = new ArrayList<>();
    }

    public static TaskStorage get(Context context){
        if(taskStorage == null){
            taskStorage = new TaskStorage(context);
        }
        return taskStorage;
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
