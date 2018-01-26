package com.stevenbenack.todoit.ui.viewtask;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.storage.TaskStorage;
import com.stevenbenack.todoit.storage.ToDoTask;
import com.stevenbenack.todoit.ui.createtask.CreateTaskFragment;

import java.util.List;

// using ViewPager
public class ViewTaskActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private List<ToDoTask> taskList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view_pager);

        viewPager = findViewById(R.id.task_view_pager);

        taskList = TaskStorage.get(this).getTodoTasks();
        FragmentManager fragmentManager = getSupportFragmentManager();

        viewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                ToDoTask task = taskList.get(position);
                return CreateTaskFragment.newInstance(task.getId());
            }

            @Override
            public int getCount() {
                return taskList.size();
            }
        });
    }
}
