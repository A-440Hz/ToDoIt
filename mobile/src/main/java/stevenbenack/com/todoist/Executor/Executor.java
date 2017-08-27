package stevenbenack.com.todoist.Executor;

import stevenbenack.com.todoist.Executor.ThreadExecutor.InteractorImpl;

public interface Executor {
	void run(final InteractorImpl interactor);
}
