package com.albertgf.domain.usecase;

/**
 * Created by albertgf on 4/11/17.
 */

public class DefaultCallback<T> {
    public void onNext(T t){}

    public void onComplete(){}

    public void onError(Throwable exception) {}
}
