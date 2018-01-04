package com.stevenbenack.todoit.tasklist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.storage.ToDoTask;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder>{
    private List<ToDoTask> toDoTasks;

    public TaskAdapter(List<ToDoTask> toDoTasks) {
        this.toDoTasks = toDoTasks;
    }

    @Override
    public TaskHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_task, parent, false);

        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(TaskHolder taskHolder, int position) {
        ToDoTask task = toDoTasks.get(position);
        taskHolder.bind(task);
    }

    @Override
    public int getItemCount() {
        return toDoTasks.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    // Recycler View ViewHolder
    static class TaskHolder extends RecyclerView.ViewHolder {
        private ToDoTask task;

        public TaskHolder(View view) {
            super(view);
        }

        public void bind(ToDoTask toDoTask) {
            task = toDoTask;
        }
    }
}

