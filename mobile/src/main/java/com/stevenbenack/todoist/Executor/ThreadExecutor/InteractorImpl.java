package com.stevenbenack.todoist.Executor.ThreadExecutor;

import com.stevenbenack.todoist.Executor.Executor;
import com.stevenbenack.todoist.Executor.MainThread;

public abstract class InteractorImpl{
    private Executor threadExecutor;
    private MainThread mainThread;

	private volatile boolean isCanceled;
	private volatile boolean isRunning;

	public InteractorImpl(Executor threadExecutor, MainThread mainThread){
		this.threadExecutor = threadExecutor;
		this.mainThread = mainThread;
	}

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
