package com.stevenbenack.todoit.CreateTask;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.TaskFragmentActivity;

public class CreateTaskActivity extends TaskFragmentActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.action_bar_title_create_task);
        }
    }

    @Override
    protected Fragment createFragment() {
        return new CreateTaskFragment();
    }
}
