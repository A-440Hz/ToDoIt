package com.stevenbenack.todoit.CreateToDoTask;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.Storage.ToDoTask;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

public class CreateToDoTaskFragment extends Fragment {
    Unbinder unbinder;
    private ToDoTask task;
    private DateTime createdDateTime;
    private DateTime dueDateTime;

    private static final DateTimeFormatter DUE_DATE_FORMAT = DateTimeFormat.forPattern("EEE, MM dd, YYYY");
    private static final DateTimeFormatter DUE_TIME_FORMAT = DateTimeFormat.forPattern("HH:mm");
    private static final DateTimeFormatter CURRENT_DATE_TIME =
            DateTimeFormat.forPattern(DUE_DATE_FORMAT + " " + DUE_TIME_FORMAT);

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
    @BindView(R.id.create_task_priority_text)
    TextView createTaskPriorityText;
    @BindView(R.id.create_task_priority_seekbar)
    SeekBar createTaskPrioritySeekbar;
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
        currentDateTimeTextView.setText(createdDateTime.toString(CURRENT_DATE_TIME));

        return view;
    }

    // task title text changed
    @OnTextChanged(value = R.id.create_task_title, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTitleChanged(Editable editable) {
        task.setTitle(editable.toString());
    }

    // TODO: 12/8/2017 implement date-time pickers
    @OnCheckedChanged(R.id.create_task_all_day)
    void onAllDayCheckChanged(CompoundButton button, boolean isAllDayChecked) {
        // use Joda period for all-day tasks
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
