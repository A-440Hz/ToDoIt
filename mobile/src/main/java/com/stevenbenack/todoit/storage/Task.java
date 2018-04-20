package com.stevenbenack.todoit.storage;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Task {
	private UUID id;
	private String title;
	private String description;
	private Date createdDateTime;
	private Date dueDateTime;
	private int priority = 0;
	private boolean isDone = false;

	public Task() {
		this(UUID.randomUUID());
	}

	public Task(UUID id) {
		this.id = id;
		createdDateTime = new Date();
	}

	public UUID getId() {
		return id;
	}

	public Date getCreatedDateTime() {
		return createdDateTime;
	}

	public void setCreatedDateTime(Date createdDateTime) {
		this.createdDateTime = createdDateTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDateTime() {
		return dueDateTime;
	}

	public void setDueDateTime(Date dueDateTime) {
		this.dueDateTime = dueDateTime;
	}

	public void setDueDateTime(int year, int month, int dayOfMonth, int hrs, int min) {
		this.dueDateTime = new GregorianCalendar(year, month, dayOfMonth, hrs, min).getTime();
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
