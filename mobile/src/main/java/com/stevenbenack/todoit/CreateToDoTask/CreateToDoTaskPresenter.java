package com.stevenbenack.todoit.CreateToDoTask;

import android.support.annotation.NonNull;
import android.text.Editable;

import com.stevenbenack.todoit.Storage.ToDoTask;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import static junit.framework.Assert.assertNotNull;

public class CreateToDoTaskPresenter implements CreateToDoTaskContract.Presenter{
    private CreateToDoTaskContract.View view;

    private ToDoTask task;
    private DateTime dateTime;
    private DateTimeFormatter dateTimeFormatter;

    public CreateToDoTaskPresenter(@NonNull CreateToDoTaskContract.View createTaskView){
        assertNotNull(createTaskView);
        createTaskView.setPresenter(this);
    }

    @Override
    public void start() {
        dateTime = new DateTime();
        dateTimeFormatter = DateTimeFormat.forPattern("EEE, MM dd, YYYY");
        task = new ToDoTask();

        setCurrentDateTime();
    }

    private void setCurrentDateTime(){
        String currentDateTime = dateTime.toString(dateTimeFormatter);
        view.setCurrentDateTimeText(currentDateTime);
    }

    @Override
    public void afterTitleChanged(Editable editable) {
        // TODO: 12/9/2017 Do something when title changed
    }

    @Override
    public void afterDueDateTimeChanged(Editable editable) {
        // TODO: 12/9/2017 Do something when date changed
    }

    @Override
    public void onAllDayTaskChecked(boolean isAllDayChecked) {
        // TODO: 12/9/2017
    }
}
