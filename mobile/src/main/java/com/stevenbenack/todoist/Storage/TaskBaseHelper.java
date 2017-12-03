package com.stevenbenack.todoist.Storage;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.stevenbenack.todoist.Storage.TaskDbSchema.TaskTable;

public class TaskBaseHelper extends SQLiteOpenHelper{
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "taskBase.db";

    public TaskBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TaskDbSchema.TaskTable.NAME +
                                    "(" +
                                    " _id integer primary key autoincrement, " +
                                    TaskTable.Cols.UUID + ", " +
                                    TaskTable.Cols.TITLE + ", " +
                                    TaskTable.Cols.DESCRIPTION + ", " +
                                    TaskTable.Cols.CREATED + ", " +
                                    TaskTable.Cols.DUE + ", " +
                                    TaskTable.Cols.PRIORITY + ", " +
                                    TaskTable.Cols.DONE +
                                    ")"
                                );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int prevVersion, int newVersion) {

    }
}
