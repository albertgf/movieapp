package com.albertgf.apiclient.api;

import com.albertgf.apiclient.model.ApiResponsePagination;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by albertgf on 3/11/17.
 */

public interface RestApi {

    @GET (RestPath.TOP_RATED_PATH) Call<ApiResponsePagination> getTopRatedMovies(
            @Query("api_key") String apiKey,
            @Query("page") int page
    );

    @GET (RestPath.SIMILAR_MOVIE_PATH) Call<ApiResponsePagination> getSimilarMovies(
            @Query("api_key") String apiKey,
            @Path("id") int id
    );
}
