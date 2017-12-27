package com.stevenbenack.todoit.storage;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TodoTaskStorage {
    private static TodoTaskStorage todoTaskStorage;

    private List<ToDoTask> todoTaskList;
    private Context context;
    private SQLiteDatabase database;

    public static TodoTaskStorage get(Context context){
        if(todoTaskStorage == null){
            todoTaskStorage = new TodoTaskStorage(context);
        }
        return todoTaskStorage;
    }

    private TodoTaskStorage(Context context) {
        context = context.getApplicationContext();
        database = new TodoTaskDbHelper(context).getWritableDatabase();

        todoTaskList = new ArrayList<>();
    }

     public List<ToDoTask> getTodoTasks() {
        return todoTaskList;
    }

    public ToDoTask getToDoTask(UUID id){
        for(ToDoTask task : todoTaskList){
            if(task.getId().equals(id)){
                return task;
            }
        }
        return null;
    }
}
