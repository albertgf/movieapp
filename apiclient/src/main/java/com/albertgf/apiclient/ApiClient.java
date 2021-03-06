package com.albertgf.apiclient;

import com.albertgf.apiclient.api.MovieApi;
import com.albertgf.apiclient.api.RestApi;
import com.albertgf.apiclient.exception.AuthApiException;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiResponsePagination;

import java.io.IOException;

import retrofit2.Response;

import static com.albertgf.apiclient.Constants.CODE_AUTH;
import static com.albertgf.apiclient.Constants.CODE_NOT_FOUND;
import static com.albertgf.apiclient.Constants.CODE_SERVER;
import static com.albertgf.apiclient.Constants.CODE_SUCCESS;
import static com.albertgf.apiclient.exception.GenerateException.manageAuthError;
import static com.albertgf.apiclient.exception.GenerateException.manageError;
import static com.albertgf.apiclient.exception.GenerateException.manageNotFoundError;
import static com.albertgf.apiclient.exception.GenerateException.manageServerError;

/**
 * Created by albertgf on 3/11/17.
 */

public class ApiClient implements MovieApi {
    private final ApiConfig apiConfig;
    private final String apiKey;

    public ApiClient(ApiConfig config) {
        if (config == null)
            throw new IllegalArgumentException("ApiConfig cannot be null");
        this.apiConfig = config;
        this.apiKey = apiConfig.getApiKey();
    }

    private RestApi call() {
        return apiConfig.getApi();
    }

    @Override public ApiResponsePagination getTopRatedMovies(int page) throws NetworkApiException,
            NotFoundApiException, AuthApiException, ServerApiException {
        try {
            Response<ApiResponsePagination> response = call().getTopRatedMovies(apiKey, page).execute();
            return responseApiPagination(response);
        } catch (IOException error) {
            manageError(error);
            return null;
        }
    }

    @Override public ApiResponsePagination getSimilarMovies(
            int id) throws NetworkApiException, NotFoundApiException, AuthApiException, ServerApiException {
        try {
            Response<ApiResponsePagination> response = call().getSimilarMovies(id, apiKey).execute();
            return responseApiPagination(response);
        } catch (IOException error) {
            manageError(error);
            return null;
        }
    }

    private ApiResponsePagination responseApiPagination(
            Response<ApiResponsePagination> response) throws NetworkApiException, NotFoundApiException, AuthApiException, ServerApiException {
        switch (response.code()) {
            case CODE_SUCCESS:
                return response.body();
            case CODE_NOT_FOUND:
                manageNotFoundError(CODE_NOT_FOUND);
            case CODE_AUTH:
                manageAuthError(CODE_AUTH);
            default:
                manageServerError(CODE_SERVER);
                return null;
        }
    }
}

