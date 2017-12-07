package com.albertgf.apiclient;

import com.albertgf.apiclient.api.RestApi;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;

import java.io.IOException;

import retrofit2.Response;

import static com.albertgf.apiclient.Constants.CODE_NOT_FOUND;
import static com.albertgf.apiclient.Constants.CODE_SUCCESS;
import static com.albertgf.apiclient.exception.GenerateException.manageError;
import static com.albertgf.apiclient.exception.GenerateException.manageNotFoundError;

/**
 * Created by albertgf on 3/11/17.
 */

public class ApiClient{
    private final ApiConfig apiConfig;

    public ApiClient(ApiConfig config) {
        if (config == null)
            throw new IllegalArgumentException("ApiConfig cannot be null");
        this.apiConfig = config;
    }

    private RestApi call() {
        return apiConfig.getApi();
    }

}
