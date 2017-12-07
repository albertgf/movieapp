package com.albertgf.movieapp;

import android.app.Application;

import com.albertgf.movieapp.di.components.ApplicationComponent;
import com.albertgf.movieapp.di.components.DaggerApplicationComponent;
import com.albertgf.movieapp.di.modules.ApplicationModule;

/**
 * Created by albertgf on 4/11/17.
 */

public class MovieApp extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        // DI
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(
                        new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
