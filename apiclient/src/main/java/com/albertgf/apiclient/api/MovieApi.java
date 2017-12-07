package com.albertgf.apiclient.api;

import com.albertgf.apiclient.exception.AuthApiException;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiResponsePagination;

/**
 * Created by albertgf on 7/12/17.
 */

public interface MovieApi {
    ApiResponsePagination getTopRatedMovies(String apiKey, int page) throws NetworkApiException,
            NotFoundApiException, AuthApiException, ServerApiException;


    ApiResponsePagination getSimilarMovies(String apiKey, int id) throws NetworkApiException,
            NotFoundApiException, AuthApiException, ServerApiException;
}
