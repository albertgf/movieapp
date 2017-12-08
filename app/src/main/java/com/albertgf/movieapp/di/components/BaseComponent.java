package com.albertgf.movieapp.di.components;

import com.albertgf.movieapp.activity.MainActivity;
import com.albertgf.movieapp.di.PerActivity;
import com.albertgf.movieapp.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by albertgf on 4/11/17.
 */

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = {ActivityModule.class})
public interface BaseComponent {
    void inject(MainActivity activity);
}
