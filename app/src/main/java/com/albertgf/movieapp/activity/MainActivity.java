package com.albertgf.movieapp.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.albertgf.domain.model.MovieModelView;
import com.albertgf.movieapp.R;
import com.albertgf.movieapp.di.components.BaseComponent;
import com.albertgf.movieapp.di.components.DaggerBaseComponent;
import com.albertgf.movieapp.presenter.MainPresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by albertgf on 8/12/17.
 */

public class MainActivity extends BaseActivity implements MainPresenter.View{
    @BindView (R.id.act_main_rv) RecyclerView rvMovies;

    @Inject MainPresenter presenter;
    private BaseComponent component;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        initInjector();
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onViewAttached(this, false);
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onViewDetached();
    }

    private void initInjector() {
        this.component = DaggerBaseComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        component.inject(this);
    }

    @Override public void onError(String text) {

    }

    @Override public void bindMovies(List<MovieModelView> list) {

    }
}
