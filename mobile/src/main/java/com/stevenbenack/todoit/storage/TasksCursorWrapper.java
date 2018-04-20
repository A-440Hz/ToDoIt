package com.stevenbenack.todoit.storage;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.Date;
import java.util.UUID;

public class TasksCursorWrapper extends CursorWrapper{

	public TasksCursorWrapper(Cursor cursor) {
		super(cursor);
	}

	public Task getTask() {
		String uuidString = getString(getColumnIndex(TaskDbSchema.TaskTable.Cols.UUID));
		String title = getString(getColumnIndex(TaskDbSchema.TaskTable.Cols.TITLE));
		String description = getString(getColumnIndex(TaskDbSchema.TaskTable.Cols.DESCRIPTION));
		long createdDate = getLong(getColumnIndex(TaskDbSchema.TaskTable.Cols.CREATED));
		long dueDate = getLong(getColumnIndex(TaskDbSchema.TaskTable.Cols.DUE));
		int priority = getInt(getColumnIndex(TaskDbSchema.TaskTable.Cols.PRIORITY));
		int isDone = getInt(getColumnIndex(TaskDbSchema.TaskTable.Cols.DONE));

		Task task = new Task(UUID.fromString(uuidString));
		task.setTitle(title);
		task.setDescription(description);
		task.setCreatedDateTime(new Date(createdDate));
		task.setDueDateTime(new Date(dueDate));
		task.setPriority(priority);
		task.setDone(isDone != 0);

		return task;
	}
}
