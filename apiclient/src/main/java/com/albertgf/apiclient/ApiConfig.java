package com.albertgf.apiclient;

import com.albertgf.apiclient.api.RestApi;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by albertgf on 3/11/17.
 */

public class ApiConfig {

    private static ApiConfig singleton;
    private final Retrofit retrofit;
    private final RestApi api;
    private final String apiKey;

    private ApiConfig(Retrofit retrofit, String apiKey) {
        this.retrofit = retrofit;
        this.api = retrofit.create(RestApi.class);
        this.apiKey = apiKey;
    }

    public static ApiConfig with(String hostUrl, String apiKey) {
        if (singleton == null) {
            singleton = new Builder(hostUrl, apiKey).build();
        }

        return singleton;
    }

    public RestApi getApi() {
        return api;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public String getApiKey() {
        return apiKey;
    }

    public static class Builder {

        private final String apiKey;
        private String baseUrl;
        private boolean debug;
        private Retrofit retrofit;

        public Builder(String hostUrl, String apiKey) {
            if (hostUrl == null || apiKey == null) {
                throw new IllegalArgumentException(Constants.ERROR_HOST);
            }

            this.baseUrl = hostUrl;
            this.apiKey = apiKey;
        }

        public Builder debug() {
            this.debug = true;
            return this;
        }

        public Builder baseUrl(String url) {
            this.baseUrl = url;
            return this;
        }

        public ApiConfig build() {
            if (retrofit == null) {
                retrofit = createDefaultRetrofit(baseUrl, debug);
            }

            return new ApiConfig(retrofit, apiKey);
        }

        private Retrofit createDefaultRetrofit(String baseUrl, boolean debug) {

            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();

            if (debug) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                clientBuilder.addNetworkInterceptor(interceptor);
            }
            OkHttpClient okHttpClient = clientBuilder.build();

            return new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient).build();
        }
    }
}
