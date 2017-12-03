package com.stevenbenack.todoist.Storage;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private static TaskList taskList;

    private List<toDoTask> tasks;
    private Context context;
    private SQLiteDatabase database;

    private TaskList(Context context) {
        context = context.getApplicationContext();
        database = new TaskBaseHelper(context).getWritableDatabase();

        tasks = new ArrayList<>();
    }
}
