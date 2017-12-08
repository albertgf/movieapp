package com.albertgf.apiclient.exception;

/**
 * Created by albertgf on 5/11/17.
 */

public class AuthApiException extends ApiException {
    public AuthApiException(int httpCode, String description, Throwable cause) {
        super(httpCode, description, cause);

        typeException = Type.AUTH;
    }
}
