package com.stevenbenack.todoit.executor;

import com.stevenbenack.todoit.executor.ThreadExecutor.InteractorImpl;

public interface Executor {
	void run(final InteractorImpl interactor);
}
