package com.stevenbenack.todoit.createtask;

import android.support.v4.app.Fragment;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.TaskFragmentActivity;

public class CreateTaskActivity extends TaskFragmentActivity{

    @Override
    protected Fragment createFragment() {
        return new CreateTaskFragment();
    }

    @Override
    protected void setActionBar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.action_bar_title_create_task);
        }
    }
}
