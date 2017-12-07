package com.albertgf.apiclient.exception;

/**
 * Created by albertgf on 5/11/17.
 */

public class NotFoundApiException extends ApiException {
    public NotFoundApiException(int httpCode, String description, Throwable cause) {
        super(httpCode, description, cause);
    }
}
