package com.stevenbenack.todoit.createtask;

import android.support.v4.app.Fragment;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.TodoTaskFragmentActivity;

public class CreateTodoTaskActivity extends TodoTaskFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CreateTodoTaskFragment();
    }

    @Override
    protected void setActionBar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.create_task_action_bar_title);
        }
    }
}
