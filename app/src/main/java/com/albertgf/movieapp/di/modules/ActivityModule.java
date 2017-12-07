package com.albertgf.movieapp.di.modules;

import android.app.Activity;

import com.albertgf.movieapp.di.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertgf on 4/11/17.
 */

@Module
public class ActivityModule {
    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @PerActivity
    Activity activity() {
        return this.activity;
    }
}
