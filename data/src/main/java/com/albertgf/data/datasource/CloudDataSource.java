package com.albertgf.data.datasource;

import com.albertgf.apiclient.exception.AuthApiException;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiResponsePagination;

/**
 * Created by albertgf on 4/11/17.
 */

public interface CloudDataSource {
    ApiResponsePagination getTopRatedMovies(int page) throws AuthApiException, NetworkApiException,
            ServerApiException, NotFoundApiException;

    ApiResponsePagination getSimilarMovies(int id) throws AuthApiException, NetworkApiException,
            ServerApiException, NotFoundApiException;
}
