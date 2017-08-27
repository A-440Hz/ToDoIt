package stevenbenack.com.todoist.Executor.ThreadExecutor;

import javax.inject.Inject;

import stevenbenack.com.todoist.Executor.Executor;
import stevenbenack.com.todoist.Executor.Interactor;
import stevenbenack.com.todoist.Executor.MainThread;

public abstract class InteractorImpl implements Interactor{
	private Executor threadExecutor;
	private MainThread mainThread;

	private volatile boolean isCanceled;
	private volatile boolean isRunning;

	@Inject InteractorImpl(Executor threadExecutor, MainThread mainThread){
		this.threadExecutor = threadExecutor;
		this.mainThread = mainThread;
	}

	/**
	 * This method contains the actual business logic of the interactor. It should not be used directly but, instead, a
	 * developer should call the execute() method of an interactor to make sure the operation is done on a background thread.
	 */
	public abstract void run();

	public void cancelThread(){
		isCanceled = true;
		isRunning = false;
	}

	public boolean isRunning(){
		return isRunning;
	}

	void onFinished(){
		isRunning = false;
		isCanceled = false;
	}

	public void execute(){
		this.isRunning = true;

		threadExecutor.run(this);
	}
}
