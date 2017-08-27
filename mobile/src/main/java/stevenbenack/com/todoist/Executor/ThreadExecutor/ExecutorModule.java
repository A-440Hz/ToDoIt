package stevenbenack.com.todoist.Executor.ThreadExecutor;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import stevenbenack.com.todoist.Executor.Executor;
import stevenbenack.com.todoist.Executor.MainThread;

/**
 * Dagger module created to provide every dependency related with our execution service.
 * Dependencies provided by this module are: ThreadExecutor and MainThreadImpl.
 */
@Module
public final class ExecutorModule {
	@Provides @Singleton
	Executor provideExecutor(ThreadExecutor threadExecutor){
		return threadExecutor;
	}

	@Provides @Singleton
	MainThread provideMainThread(MainThreadImpl mainThread){
		return mainThread;
	}
}
