package com.stevenbenack.todoit.Storage;

import org.joda.time.DateTime;

import java.util.UUID;

public class ToDoTask {
    private UUID id;
    private String title;
    private String description;
    private DateTime createdDateTime;
    private DateTime dueDateTime;
    private int priority;
    private boolean isDone;

    public ToDoTask(){
        id = UUID.randomUUID();
        createdDateTime = new DateTime();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public DateTime getCreatedDateTime() {
        return createdDateTime;
    }

    // TODO: 12/2/2017 Add support for different time zones
    public DateTime getDueDateTime() {
        return dueDateTime;
    }

    public void setDueDateTime(DateTime dueDateTime) {
        this.dueDateTime = dueDateTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
