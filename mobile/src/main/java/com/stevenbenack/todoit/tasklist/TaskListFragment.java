package com.stevenbenack.todoit.tasklist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.storage.ToDoTask;
import com.stevenbenack.todoit.storage.TodoTaskStorage;

import java.util.List;

public class TaskListFragment extends Fragment {
    private RecyclerView taskListRecyclerView;
    private TaskAdapter adapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        taskListRecyclerView = view.findViewById(R.id.task_list_recycler_view);
        taskListRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        UpdateUi();

        return view;
    }

    private void UpdateUi() {
        TodoTaskStorage todoTaskStorage = TodoTaskStorage.get(getActivity());
        List<ToDoTask> toDoTasks = todoTaskStorage.getTodoTasks();

        adapter = new TaskAdapter(toDoTasks);
        taskListRecyclerView.setAdapter(adapter);
    }
}
