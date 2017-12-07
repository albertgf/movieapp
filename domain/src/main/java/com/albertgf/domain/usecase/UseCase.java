package com.albertgf.domain.usecase;

import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;

/**
 * Created by albertgf on 4/11/17.
 */

public abstract class UseCase<T, Params> implements Runnable {
    private final ThreadExecutor threadExecutor;
    private final PostExecutionThread postExecutionThread;
    public DefaultCallback<T> callback;
    public Params params;

    public UseCase(ThreadExecutor threadExecutor, PostExecutionThread postExecutionThread) {
        this.threadExecutor = threadExecutor;
        this.postExecutionThread = postExecutionThread;
    }

    public final class RepositoryCallback extends DefaultCallback<T> {
        @Override
        public void onComplete() {
            notifyComplete();
        }

        @Override
        public void onNext(T t) {
            notifyNext(t);
        }

        @Override
        public void onError(Throwable throwable) {
            notifyError(throwable);
        }
    }

    private void notifyComplete() {
        this.postExecutionThread.post(new Runnable() {
            @Override public void run() {
                callback.onComplete();
            }
        });
    }

    private void notifyNext(final T t) {
        this.postExecutionThread.post(new Runnable() {
            @Override public void run() {
                callback.onNext(t);
            }
        });
    }

    private void notifyError(final Throwable exception) {
        this.postExecutionThread.post(new Runnable() {
            @Override public void run() {
                callback.onError(exception);
            }
        });
    }

    abstract void buildUseCaseCallback(Params params);

    public void execute(DefaultCallback<T> callback, Params params) {
        this.callback = callback;
        this.buildUseCaseCallback(params);
        threadExecutor.execute(this);
    }
}