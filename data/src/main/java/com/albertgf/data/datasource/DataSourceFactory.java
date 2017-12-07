package com.albertgf.data.datasource;

import android.content.Context;

import com.albertgf.apiclient.ApiClient;
import com.albertgf.apiclient.ApiConfig;
import com.albertgf.data.BuildConfig;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */

public class DataSourceFactory {
        private final Context context;
        private final ApiConfig apiConfig;

        @Inject
        public DataSourceFactory(Context context) {
            if (context == null) {
                throw new IllegalArgumentException(("constructor parameters cannot be null!!!"));
            }
            this.context = context.getApplicationContext();


            ApiConfig.Builder apiBuilder = new ApiConfig.Builder(BuildConfig.API_URL);
            if (BuildConfig.DEBUG) {
                apiBuilder.debug();
            }
            apiConfig = apiBuilder.build();
        }

        public CloudDataSource createCloudDataStore() {
            return new CloudDataSourceImpl(new ApiClient(apiConfig));
        }

        public Context getContext() {
            return context;
        }
}
