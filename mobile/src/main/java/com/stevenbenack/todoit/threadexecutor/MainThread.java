package com.stevenbenack.todoit.threadexecutor;

/**
 * UI thread abstraction created to change the execution context from any thread to the UI thread.
 */
public interface MainThread {
	void post(final Runnable runnable);
}
