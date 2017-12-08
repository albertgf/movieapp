package com.albertgf.apiclient.exception;

/**
 * Created by albertgf on 3/11/17.
 */

public class ApiException extends Exception {

    public enum Type {
        AUTH, SERVER, NETWORK, NOTFOUND
    }

    private final int httpCode;
    private boolean networkError = false;
    protected Type typeException;

    public ApiException(boolean networkError, String description, Throwable cause) {
        this(-1, description, cause);

        this.networkError = networkError;
    }

    public ApiException(int httpCode, String description, Throwable cause) {
        super(description, cause);

        this.httpCode = httpCode;
    }

    public ApiException(String message, Throwable cause) {
        this(-1, message, cause);
    }

    public int getHttpCode() {
        return httpCode;
    }

    public boolean isNetworkError() {
        return networkError;
    }

    public Type getTypeException() {
        return typeException;
    }
}
