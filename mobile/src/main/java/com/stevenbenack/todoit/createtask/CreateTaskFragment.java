package com.stevenbenack.todoit.createtask;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.storage.ToDoTask;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

public class CreateTaskFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    Unbinder unbinder;
    private ToDoTask task;
    private DateTime createdDateTime;
    private DateTime dueDateTime;

    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("EEE, MM dd, yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormat.forPattern("HH:mm");
    private static final DateTimeFormatter CURRENT_DATE_TIME = DateTimeFormat.forPattern("EEE, MM/dd/yyyy, HH:mm");

    @BindView(R.id.create_task_title)
    EditText titleEditText;
    @BindView(R.id.create_task_created_date_time)
    TextView currentDateTimeTextView;
    @BindView(R.id.create_task_due_date)
    EditText dueDateEditText;
    @BindView(R.id.create_task_due_time)
    EditText dueTimeEditText;
    @BindView(R.id.create_task_all_day)
    CheckBox isAllDayCheckbox;
    @BindView(R.id.create_task_priority_seekbar)
    SeekBar prioritySeekbar;
    @BindView(R.id.create_task_description)
    EditText descriptionEditText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        task = new ToDoTask();
        createdDateTime = new DateTime();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        unbinder = ButterKnife.bind(this, view);
        // TODO: 12/24/2017 change time format to 12-hour time format
        currentDateTimeTextView.setText(createdDateTime.toString(CURRENT_DATE_TIME));

        prioritySeekbar.setOnSeekBarChangeListener(this);

        return view;
    }

    // Task title text changed
    @OnTextChanged(value = R.id.create_task_title, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTitleChanged(Editable editable) {
        task.setTitle(editable.toString());
    }

    // TODO: 12/24/2017 add date and time picker for task due datetime

    // Task priority seekbar changed
    @Override
    public void onProgressChanged(SeekBar seekBar, int priority, boolean wasChangedByUser) {
        task.setPriority(priority);
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    // Task description changed
    @OnTextChanged(value = R.id.create_task_description, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterDescriptionChanged(Editable editable){
        task.setDescription(editable.toString());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
