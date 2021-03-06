package com.stevenbenack.todoit.ui.tasklist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.ui.createtask.CreateTaskActivity;
import com.stevenbenack.todoit.storage.ToDoTask;
import com.stevenbenack.todoit.storage.TaskStorage;

import java.util.List;
import java.util.UUID;

public class TaskListFragment extends Fragment implements TaskAdapter.TaskClickListener {
    private static final int REQUEST_TASK = 1;

    private RecyclerView taskListRecyclerView;
    private TaskAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        taskListRecyclerView = view.findViewById(R.id.task_list_recycler_view);
        taskListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUi();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUi();
    }

    private void updateUi() {
        TaskStorage todoTaskStorage = TaskStorage.get(getActivity());
        List<ToDoTask> toDoTasksList = todoTaskStorage.getTasks();

        if(adapter == null){
            adapter = new TaskAdapter(toDoTasksList, this);
            taskListRecyclerView.setAdapter(adapter);
        } else {
            // TODO: 1/22/2018 implement adapter notifyItemChanged(...)
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onTaskClick(UUID taskId, int taskPosition) {
        // change taskChangedPosition key so that only this task is reloaded when onResume() is called
        Intent intent = CreateTaskActivity.newIntent(getActivity(), taskId);
        startActivityForResult(intent, REQUEST_TASK);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_TASK){
            if(resultCode == Activity.RESULT_OK){
                // something
            }
        }
    }
}
