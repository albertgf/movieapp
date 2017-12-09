package com.albertgf.movieapp.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.albertgf.domain.model.MovieModelView;
import com.albertgf.movieapp.R;
import com.albertgf.movieapp.di.components.BaseComponent;
import com.albertgf.movieapp.di.components.DaggerBaseComponent;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by albertgf on 9/12/17.
 */

public class DetailActivity extends BaseActivity{
    @BindView(R.id.act_detail_iv_poster) ImageView ivMovie;

    private BaseComponent component;

    public static Intent getCallingIntent(Context context, String transitionName, String movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra("movie", movie);
        intent.putExtra("transition", transitionName);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        ButterKnife.bind(this);

        initInjector();
        initData();
    }

    @Override
    public void onStart() {
        super.onStart();
        //presenter.onViewAttached(this, false);
    }

    @Override
    public void onStop() {
        super.onStop();
        //presenter.onViewDetached();
    }

    private void initInjector() {
        this.component = DaggerBaseComponent.builder()
                .applicationComponent(getApplicationComponent())
                .activityModule(getActivityModule())
                .build();
        component.inject(this);
    }

    private void initData() {
        MovieModelView movie = new Gson().fromJson(getIntent().getExtras().getString("movie"), MovieModelView.class);

        initTransition(movie.getPosterPath(), getIntent().getExtras().getString("transition"));
    }

    private void initTransition(String url, String transitionName) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            ivMovie.setTransitionName(transitionName);
        }

        Glide.with(this).load(url).listener(new RequestListener() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target target,
                                        boolean isFirstResource) {
                supportStartPostponedEnterTransition();
                return false;
            }

            @Override
            public boolean onResourceReady(Object resource, Object model, Target target,
                                           DataSource dataSource, boolean isFirstResource) {
                supportStartPostponedEnterTransition();
                return false;
            }
        }).into(ivMovie);

    }
}
