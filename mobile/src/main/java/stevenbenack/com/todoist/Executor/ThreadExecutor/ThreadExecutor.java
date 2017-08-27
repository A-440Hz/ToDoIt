package stevenbenack.com.todoist.Executor.ThreadExecutor;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import stevenbenack.com.todoist.Executor.Executor;
import stevenbenack.com.todoist.Executor.Interactor;

 class ThreadExecutor implements Executor{

	private static final int CORE_POOL_SIZE = 3;
	private static final int MAX_POOL_SIZE = 5;
	private static final int KEEP_ALIVE_TIME = 120;
	private static final TimeUnit TIME_UNIT = TimeUnit.SECONDS;
	private static final BlockingDeque<Runnable> WORK_QUEUE = new LinkedBlockingDeque<>();

	private ThreadPoolExecutor threadPoolExecutor;

	@Inject ThreadExecutor(){
		threadPoolExecutor =
				new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TIME_UNIT, WORK_QUEUE);
	}

	@Override
	public void run(final Interactor interactor) {
		if(interactor == null){
			throw new IllegalArgumentException("Null interactor error");
		}
		threadPoolExecutor.submit(new Runnable() {
			@Override
			public void run() {
				interactor.run();
			}
		});
	}
}
