package com.stevenbenack.todoit.tasklist;

import android.support.v4.app.Fragment;

import com.stevenbenack.todoit.TaskFragmentActivity;

public class TaskListActivity extends TaskFragmentActivity{
    @Override
    protected Fragment createFragment() {
        return new TaskListFragment();
    }

    @Override
    protected void setActionBar() {

    }
}
