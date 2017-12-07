package com.albertgf.apiclient.exception;

/**
 * Created by albertgf on 3/11/17.
 */

public class NetworkApiException extends ApiException {
    public NetworkApiException(int httpCode, String description, Throwable cause) {
        super(httpCode, description, cause);
    }
}
