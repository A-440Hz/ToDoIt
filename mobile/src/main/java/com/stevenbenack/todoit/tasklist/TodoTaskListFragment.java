package com.stevenbenack.todoit.tasklist;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
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

public class TodoTaskListFragment extends Fragment {
    private RecyclerView todoTaskRecyclerView;
    private TodoTaskAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task_list, container, false);

        todoTaskRecyclerView = (RecyclerView) view.findViewById(R.id.task_list_recycler_view);
        todoTaskRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        UpdateUi();

        return view;
    }

    private void UpdateUi(){
        TodoTaskStorage todoTaskStorage = TodoTaskStorage.get(getActivity());
        List<ToDoTask> toDoTasks = todoTaskStorage.getTodoTasks();

        adapter = new TodoTaskAdapter(toDoTasks);
        todoTaskRecyclerView.setAdapter(adapter);
    }

    // Recycler View ViewHolder
    private class TodoTaskHolder extends RecyclerView.ViewHolder {

        public TodoTaskHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_task, parent, false));
        }
    }

    // Recycler View Adapter
    private class TodoTaskAdapter extends RecyclerView.Adapter<TodoTaskHolder> {
        private List<ToDoTask> toDoTasks;

        public TodoTaskAdapter(List<ToDoTask> toDoTasks){
            this.toDoTasks = toDoTasks;
        }

        @Override
        public TodoTaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new TodoTaskHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(TodoTaskHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return toDoTasks.size();
        }
    }
}
