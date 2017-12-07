package com.albertgf.data.datasource;

import com.albertgf.apiclient.ApiClient;
import com.albertgf.apiclient.exception.AuthApiException;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiResponsePagination;

/**
 * Created by albertgf on 4/11/17.
 */

public class CloudDataSourceImpl implements CloudDataSource {
    private final ApiClient apiClient;

    public CloudDataSourceImpl(ApiClient apiClient) {
        this.apiClient = apiClient;
    }


    @Override public ApiResponsePagination getTopRatedMovies(
            int page) throws AuthApiException, NetworkApiException, ServerApiException, NotFoundApiException {
        return apiClient.getTopRatedMovies(page);
    }

    @Override public ApiResponsePagination getSimilarMovies(
            int id) throws AuthApiException, NetworkApiException, ServerApiException, NotFoundApiException {
        return apiClient.getSimilarMovies(id);
    }
}
