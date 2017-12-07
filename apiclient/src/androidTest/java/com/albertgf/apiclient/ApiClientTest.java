package com.albertgf.apiclient;

/**
 * Created by albertgf on 4/11/17.
 */

public class ApiClientTest {
    private static final String ANY_HOST_URL = "https://api.themoviedb.org/3/";
    public static final String API_KEY = "1574adc6473edaa4fbcdab55828f8887";
    public static final String WRONG_API_KEY = "WRONG_API_KEY";

    public static ApiClient givenMovieApiClient() {
        ApiConfig apiConfig = new ApiConfig.Builder(ANY_HOST_URL, API_KEY).debug().build();
        return new ApiClient(apiConfig);
    }

    public static ApiClient givenMovieApiClientWrongApiKey() {
        ApiConfig apiConfig = new ApiConfig.Builder(ANY_HOST_URL, WRONG_API_KEY).debug().build();
        return new ApiClient(apiConfig);
    }
}
