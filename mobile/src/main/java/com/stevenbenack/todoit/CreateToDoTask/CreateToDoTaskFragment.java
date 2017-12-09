package com.stevenbenack.todoit.CreateToDoTask;


import android.os.Bundle;
import android.support.annotation.NonNull;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

import static junit.framework.Assert.assertNotNull;

public class CreateToDoTaskFragment extends Fragment implements CreateToDoTaskContract.View {
    private CreateToDoTaskContract.Presenter presenter;
    Unbinder unbinder;

    @BindView(R.id.create_task_title)
    EditText titleEditText;
    @BindView(R.id.create_task_current_date_time)
    TextView currentDateTimeTextView;
    @BindView(R.id.create_task_due_date_time)
    EditText dueDateTimeEditText;
    @BindView(R.id.create_task_all_day)
    CheckBox isAllDayCheckbox;
    @BindView(R.id.create_task_priority_text)
    TextView createTaskPriorityText;
    @BindView(R.id.create_task_priority_seekbar)
    SeekBar createTaskPrioritySeekbar;
    @BindView(R.id.create_task_description)
    EditText descriptionEditText;


    public CreateToDoTaskFragment() {
        // constructor
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(@NonNull CreateToDoTaskContract.Presenter presenter) {
        assertNotNull(presenter);
        this.presenter = presenter;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_task, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    // task title text changed
    @OnTextChanged(value = R.id.create_task_title, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTitleChanged(Editable editable) {
        presenter.afterTitleChanged(editable);
    }

    @Override
    public void setCurrentDateTimeText(String currentDateTime) {
        currentDateTimeTextView.setText(currentDateTime);
    }

    // TODO: 12/8/2017 implement date-time picker
    // task due date changed
    @OnTextChanged(value = R.id.create_task_due_date_time, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterDueDateTimeChanged(Editable editable) {
        presenter.afterDueDateTimeChanged(editable);
    }

    @OnCheckedChanged(R.id.create_task_all_day)
    void onAllDayChecked(CompoundButton button, boolean isAllDayChecked){
        presenter.onAllDayTaskChecked(isAllDayChecked);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
