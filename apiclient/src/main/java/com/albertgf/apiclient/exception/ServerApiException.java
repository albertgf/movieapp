package com.albertgf.apiclient.exception;

/**
 * Created by albertgf on 3/11/17.
 */

public class ServerApiException extends ApiException {
    public ServerApiException(int httpCode, String description, Throwable cause) {
        super(httpCode, description, cause);
    }
}
