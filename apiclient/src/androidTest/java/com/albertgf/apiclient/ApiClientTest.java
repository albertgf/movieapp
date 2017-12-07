package com.albertgf.apiclient;

/**
 * Created by albertgf on 4/11/17.
 */

public class ApiClientTest {
    private static final String ANY_HOST_URL = "https://developers.themoviedb.org/3/movie/";

    public static ApiClient givenMovieApiClient() {
        ApiConfig apiConfig = new ApiConfig.Builder(ANY_HOST_URL).debug().build();
        return new ApiClient(apiConfig);
    }
}
