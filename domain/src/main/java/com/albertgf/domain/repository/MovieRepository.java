package com.albertgf.domain.repository;

import com.albertgf.domain.model.PaginationModelView;
import com.albertgf.domain.usecase.DefaultCallback;

/**
 * Created by albertgf on 7/12/17.
 */

public interface MovieRepository {
    void getTopRatedMovies(int page, DefaultCallback<PaginationModelView> callback);
    void getSimilarMovies(int id, DefaultCallback<PaginationModelView> callback);
}
