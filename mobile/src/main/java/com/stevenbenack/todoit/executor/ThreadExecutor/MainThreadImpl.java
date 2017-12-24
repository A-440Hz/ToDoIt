package com.stevenbenack.todoit.executor.ThreadExecutor;

import android.os.Handler;
import android.os.Looper;

import com.stevenbenack.todoit.executor.MainThread;

public class MainThreadImpl implements MainThread{
	private Handler handler;

	MainThreadImpl() {
		this.handler = new Handler(Looper.getMainLooper());
	}

	public void post(Runnable runnable) {
		handler.post(runnable);
	}
}
