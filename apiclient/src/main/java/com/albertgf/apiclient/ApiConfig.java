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

    private ApiConfig(Retrofit retrofit) {
        this.retrofit = retrofit;
        this.api = retrofit.create(RestApi.class);
    }

    public static ApiConfig with(String hostUrl) {
        if (singleton == null) {
            singleton = new Builder(hostUrl).build();
        }

        return singleton;
    }

    public RestApi getApi() {
        return api;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public static class Builder {

        private String baseUrl;
        private boolean debug;
        private Retrofit retrofit;

        public Builder(String hostUrl) {
            if (hostUrl == null) {
                throw new IllegalArgumentException(Constants.ERROR_HOST);
            }

            this.baseUrl = hostUrl;
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

            return new ApiConfig(retrofit);
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
