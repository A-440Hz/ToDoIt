package com.stevenbenack.todoit.Executor;

import com.stevenbenack.todoit.Executor.ThreadExecutor.InteractorImpl;

public interface Executor {
	void run(final InteractorImpl interactor);
}
