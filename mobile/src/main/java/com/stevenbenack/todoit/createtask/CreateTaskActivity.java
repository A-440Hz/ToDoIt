package com.stevenbenack.todoit.createtask;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.stevenbenack.todoit.R;
import com.stevenbenack.todoit.TaskFragmentActivity;

import java.util.UUID;

public class CreateTaskActivity extends TaskFragmentActivity {

    private static final String EXTRA_TODOTASK_ID = "com.stevenbenack.todoit.todotask_id";

    public static Intent newIntent(Context packageContext, UUID taskId){
        Intent intent = new Intent(packageContext, CreateTaskActivity.class);
        intent.putExtra(EXTRA_TODOTASK_ID, taskId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        UUID taskId = (UUID) getIntent().getSerializableExtra(EXTRA_TODOTASK_ID);

        return CreateTaskFragment.newInstance(taskId);
    }

    @Override
    protected void setActionBar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.create_task_action_bar_title);
        }
    }
}
