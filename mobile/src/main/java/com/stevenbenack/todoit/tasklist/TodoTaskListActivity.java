package com.stevenbenack.todoit.tasklist;

import android.support.v4.app.Fragment;

import com.stevenbenack.todoit.TodoTaskFragmentActivity;

public class TodoTaskListActivity extends TodoTaskFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new TodoTaskListFragment();
    }

    @Override
    protected void setActionBar() {

    }
}
