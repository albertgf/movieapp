package com.albertgf.movieapp.di.modules;

import android.content.Context;

import com.albertgf.data.executor.JobExecutor;
import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.movieapp.MovieApp;
import com.albertgf.movieapp.UIThread;
import com.albertgf.movieapp.navigator.Navigator;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by albertgf on 4/11/17.
 */
@Module
public class ApplicationModule {
    private final MovieApp application;

    public ApplicationModule(MovieApp application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton Navigator provideNavigator() {
        return new Navigator();
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
