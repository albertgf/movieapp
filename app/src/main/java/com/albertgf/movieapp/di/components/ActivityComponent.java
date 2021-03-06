package com.albertgf.movieapp.di.components;

import android.app.Activity;

import com.albertgf.movieapp.di.PerActivity;
import com.albertgf.movieapp.di.modules.ActivityModule;

import dagger.Component;

/**
 * Created by albertgf on 4/11/17.
 */

@PerActivity
@Component (dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
