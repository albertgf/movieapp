package com.albertgf.movieapp.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albertgf.domain.model.MovieModelView;
import com.albertgf.movieapp.R;
import com.albertgf.movieapp.adapter.DefaultAdapter;
import com.albertgf.movieapp.adapter.DefaultViewHolder;
import com.albertgf.movieapp.adapter.ItemClickListener;
import com.albertgf.movieapp.di.components.BaseComponent;
import com.albertgf.movieapp.di.components.DaggerBaseComponent;
import com.albertgf.movieapp.holder.MovieHolder;
import com.albertgf.movieapp.presenter.MainPresenter;
import com.albertgf.movieapp.view.MovieItemView;
import com.google.gson.Gson;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by albertgf on 8/12/17.
 */

public class MainActivity extends BaseActivity implements MainPresenter.View, ItemClickListener<MovieModelView> {
    @BindView (R.id.act_main_rv) RecyclerView rvMovies;

    @Inject MainPresenter presenter;
    private BaseComponent component;
    private DefaultAdapter<MovieModelView> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        ButterKnife.bind(this);

        initInjector();
        initViews();
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

    private void initViews() {
        adapter = new DefaultAdapter<MovieModelView>(this,
                new DefaultAdapter.CreateViewHolder<MovieModelView>() {
                    @NonNull
                    @Override
                    protected DefaultViewHolder<MovieModelView> onCreateViewHolder(
                            ViewGroup parent,
                            int viewType) {
                        return new MovieHolder(new MovieItemView(MainActivity.this));
                    }
                });
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvMovies.setLayoutManager(layoutManager);
        rvMovies.setAdapter(adapter);
    }

    @Override public void onError(String text) {

    }

    @Override public void bindMovies(List<MovieModelView> list) {
        adapter.addItems(list);
        adapter.notifyDataSetChanged();
    }

    @Override public void onItemClick(@NonNull MovieModelView item,
                                      @NonNull DefaultViewHolder<MovieModelView> viewHolder, @NonNull View view) {
        navigator.navigateToDetail(this, ((MovieHolder) viewHolder).view.getTransitionView(), new Gson().toJson(item));
    }
}
