package com.albertgf.data.mapper;

import com.albertgf.apiclient.model.ApiModelMovie;
import com.albertgf.apiclient.model.ApiResponsePagination;
import com.albertgf.data.BuildConfig;
import com.albertgf.domain.model.MovieModelView;
import com.albertgf.domain.model.PaginationModelView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by albertgf on 7/12/17.
 */

@Singleton
public class MovieDataMapper {

    @Inject
    public MovieDataMapper() {

    }

    public PaginationModelView transform(ApiResponsePagination api) {
        PaginationModelView domain = new PaginationModelView();

        if(api != null) {
            domain.setPage(api.getPage());
            domain.setTotalPages(api.getTotalPages());
            domain.setTotalResults(api.getTotalResults());
            domain.setResults(transform(api.getResults()));
        }

        return domain;
    }

    private List<MovieModelView> transform(List<ApiModelMovie> apiList) {
        List<MovieModelView> domain = new ArrayList<>();

        if(apiList != null) {
            for(ApiModelMovie api : apiList) {
                MovieModelView movie = new MovieModelView();

                movie.setId(api.getId());
                movie.setAdult(api.isAdult());
                movie.setOriginalLanguage(api.getOriginalLanguage());
                movie.setOriginalTitle(api.getOriginalTitle());
                movie.setTitle(api.getTitle());
                movie.setOverview(api.getOverview());
                movie.setPopularity(api.getPopularity());
                movie.setVoteAverage(api.getVoteAverage());
                movie.setVoteCount(api.getVoteCount());
                movie.setPosterPath(String.format("%s%s",BuildConfig.IMAGE_URL, api.getPosterPath()));
                movie.setReleaseDate(api.getReleaseDate());

                domain.add(movie);
            }
        }

        return domain;
    }
}
