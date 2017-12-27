package com.stevenbenack.todoit.threadexecutor;

import com.stevenbenack.todoit.threadexecutor.ThreadExecutor.InteractorImpl;

public interface Executor {
	void run(final InteractorImpl interactor);
}
