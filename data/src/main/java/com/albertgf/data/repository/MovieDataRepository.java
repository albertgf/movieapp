package com.albertgf.data.repository;

import com.albertgf.apiclient.exception.AuthApiException;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiResponsePagination;
import com.albertgf.data.datasource.CloudDataSource;
import com.albertgf.data.datasource.DataSourceFactory;
import com.albertgf.data.mapper.MovieDataMapper;
import com.albertgf.domain.model.PaginationModelView;
import com.albertgf.domain.repository.MovieRepository;
import com.albertgf.domain.usecase.DefaultCallback;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by albertgf on 7/12/17.
 */

@Singleton
public class MovieDataRepository implements MovieRepository{

    private final DataSourceFactory dataSource;
    private final MovieDataMapper dataMapper;

    @Inject
    protected MovieDataRepository(DataSourceFactory dataStore, MovieDataMapper dataMapper) {
        if (dataStore == null || dataMapper == null) {
            throw new IllegalArgumentException("Invalid null parameters in constructor!!!");
        }

        this.dataSource = dataStore;
        this.dataMapper = dataMapper;
    }


    @Override public void getTopRatedMovies(int page, DefaultCallback<PaginationModelView> callback) {
        final CloudDataSource cloudDataSource = this.dataSource.createCloudDataStore();

        try {
            ApiResponsePagination pagination = cloudDataSource.getTopRatedMovies(page);
            callback.onNext(dataMapper.transform(pagination));
        } catch (ServerApiException | NetworkApiException | NotFoundApiException | AuthApiException e) {
            callback.onError(e);
        }
    }

    @Override public void getSimilarMovies(int id, DefaultCallback<PaginationModelView> callback) {

    }
}
