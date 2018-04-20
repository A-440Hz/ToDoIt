package com.stevenbenack.todoit.ui.createtask;


import android.app.Activity;
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
import com.stevenbenack.todoit.storage.Task;
import com.stevenbenack.todoit.storage.TaskStorage;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

public class CreateTaskFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private static final String ARGS_TODOTASK_ID = "todotask_id";
    // TODO: 12/24/2017 change time format to 12-hour time format
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormat.forPattern("EEE, MM dd, yyyy");
    private static final DateTimeFormatter TIME_FORMAT = DateTimeFormat.forPattern("HH:mm");
    private static final DateTimeFormatter CURRENT_DATE_TIME = DateTimeFormat.forPattern("EEE, MM/dd/yyyy, HH:mm");

    Unbinder unbinder;
    private Task task;
    private Date createdDateTime;
    private Date dueDateTime;

    @BindView(R.id.create_task_title) EditText titleEditText;
    @BindView(R.id.create_task_created_date_time) TextView createdDateTimeTextView;
    @BindView(R.id.create_task_due_date) EditText dueDateEditText;
    @BindView(R.id.create_task_due_time) EditText dueTimeEditText;
    @BindView(R.id.create_task_all_day) CheckBox isAllDayCheckbox;
    @BindView(R.id.create_task_priority_seekbar) SeekBar prioritySeekbar;
    @BindView(R.id.create_task_description) EditText descriptionEditText;

    public static CreateTaskFragment newInstance(UUID todoTaskId){
        Bundle args = new Bundle();
        args.putSerializable(ARGS_TODOTASK_ID, todoTaskId);

        CreateTaskFragment fragment = new CreateTaskFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
	    // TODO: 4/19/2018 utilize Task builder
	    createdDateTime = new Date();

        UUID taskId = (UUID) getArguments().getSerializable(ARGS_TODOTASK_ID);
        task = TaskStorage.get(getActivity()).getTask(taskId);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        unbinder = ButterKnife.bind(this, view);

	    // TODO: 4/19/2018 format date because we are using Java.Util instead now
//        currentDateTimeTextView.setText(createdDateTime.toString(CURRENT_DATE_TIME));
        titleEditText.setText(task.getTitle());

        prioritySeekbar.setOnSeekBarChangeListener(this);

        return view;
    }

	@Override
	public void onPause() {
		super.onPause();

		TaskStorage.get(getActivity()).updateTask(task);
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}

    // Task title text changed
    @OnTextChanged(value = R.id.create_task_title, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTitleChanged(Editable editable) {
        task.setTitle(editable.toString());
        onTaskChanged();
    }

    // TODO: 12/24/2017 add date and time picker for task due datetime

    // Task priority seekbar changed
    @Override
    public void onProgressChanged(SeekBar seekBar, int priority, boolean wasChangedByUser) {
        task.setPriority(priority);
        onTaskChanged();
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
        onTaskChanged();
    }

    private void onTaskChanged(){
        getActivity().setResult(Activity.RESULT_OK);
    }
}
