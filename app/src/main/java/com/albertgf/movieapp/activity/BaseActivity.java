package com.albertgf.movieapp.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.albertgf.movieapp.MovieApp;
import com.albertgf.movieapp.di.components.ApplicationComponent;
import com.albertgf.movieapp.di.modules.ActivityModule;
import com.albertgf.movieapp.navigator.Navigator;

import javax.inject.Inject;

/**
 * Created by albertgf on 4/11/17.
 */

public class BaseActivity extends AppCompatActivity {

    @Inject Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MovieApp) getApplication()).getApplicationComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
