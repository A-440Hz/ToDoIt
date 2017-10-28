package com.stevenbenack.todoist.Executor;

import com.stevenbenack.todoist.Executor.ThreadExecutor.InteractorImpl;

public interface Executor {
	void run(final InteractorImpl interactor);
}
