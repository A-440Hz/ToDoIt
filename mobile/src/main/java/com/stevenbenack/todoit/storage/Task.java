package com.stevenbenack.todoit.storage;

import java.util.Date;
import java.util.UUID;

public class Task {
	private UUID id;
	private String title;
	private String description;
	private Date createdDateTime;
	private Date dueDateTime;
	private int priority;
	private boolean isDone;

	public static class TaskBuilder {
		// test
		// auto generated parameter
		private UUID id;
		private Date createdDateTime;
		// required parameter
		private String title;
		// optional parameters
		private String description;
		private Date dueDateTime;
		private int priority = 0;
		private boolean isDone = false;

		public TaskBuilder (String title) {
			id = UUID.randomUUID();
			this.title = title;
			this.createdDateTime = new Date();
		}

		public TaskBuilder title(String title) {
			this.title = title;
			return this;
		}
		public TaskBuilder description(String description) {
			this.description = description;
			return this;
		}
		public TaskBuilder dueDateTime(Date dueDateTime) {
			this.dueDateTime = dueDateTime;
			return this;
		}
		public TaskBuilder priority(int priority) {
			this.priority = priority;
			return this;
		}
		public TaskBuilder isDone(boolean isDone) {
			this.isDone = isDone;
			return this;
		}

		public Task build() {
			return new Task(this);
		}
	}

	private Task(TaskBuilder builder) {

		id = builder.id;
		title = builder.title;
		description = builder.description;
		dueDateTime = builder.dueDateTime;
		priority = builder.priority;
		isDone = builder.isDone;
	}
}
