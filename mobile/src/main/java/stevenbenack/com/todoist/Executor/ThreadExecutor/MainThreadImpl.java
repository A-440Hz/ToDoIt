package stevenbenack.com.todoist.Executor.ThreadExecutor;


import android.os.Handler;
import android.os.Looper;

import javax.inject.Inject;

import stevenbenack.com.todoist.Executor.MainThread;

 class MainThreadImpl implements MainThread {
	private Handler handler;

	@Inject
	MainThreadImpl() {
		this.handler = new Handler(Looper.getMainLooper());
	}

	public void post(Runnable runnable) {
		handler.post(runnable);
	}

}
