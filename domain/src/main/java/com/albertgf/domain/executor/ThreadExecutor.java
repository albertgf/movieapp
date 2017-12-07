package com.albertgf.domain.executor;

/**
 * Created by albertgf on 4/11/17.
 */

public interface ThreadExecutor {
    void execute(final Runnable runnable);
}
