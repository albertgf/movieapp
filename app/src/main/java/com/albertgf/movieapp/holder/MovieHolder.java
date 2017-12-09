package com.albertgf.movieapp.holder;

import android.support.annotation.NonNull;

import com.albertgf.domain.model.MovieModelView;
import com.albertgf.movieapp.adapter.DefaultViewHolder;
import com.albertgf.movieapp.view.MovieItemView;

/**
 * Created by albertgf on 9/12/17.
 */

public class MovieHolder extends DefaultViewHolder<MovieModelView> {
    public final MovieItemView view;

    public MovieHolder(MovieItemView view) {
        super(view);

        this.view = view;
    }

    @Override
    public void bindData(@NonNull MovieModelView movie) {
        view.bindData(movie);
    }
}
