package com.albertgf.movieapp.holder;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertgf.domain.model.MovieModelView;
import com.albertgf.movieapp.R;
import com.albertgf.movieapp.adapter.DefaultViewHolder;
import com.bumptech.glide.Glide;

/**
 * Created by albertgf on 9/12/17.
 */

public class MovieHolder extends DefaultViewHolder<MovieModelView> {
    private TextView tvName;
    public ImageView ivMovie;

    public MovieHolder(View view) {
        super(view);

        this.tvName = view.findViewById(R.id.view_movie_tv_title);
        ivMovie = view.findViewById(R.id.view_movie_iv);
    }

    @Override
    public void bindData(@NonNull MovieModelView movie) {
        tvName.setText(movie.getTitle());
        //ViewCompat.setTransitionName(ivMovie, data.getName());

        //Glide.with(ivMovie).load(movie.getPosterPath()).into(ivMovie);
    }
}
