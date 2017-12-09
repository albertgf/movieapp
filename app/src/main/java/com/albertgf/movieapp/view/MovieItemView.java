package com.albertgf.movieapp.view;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.albertgf.domain.model.MovieModelView;
import com.albertgf.movieapp.R;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by albertgf on 9/12/17.
 */

public class MovieItemView extends ConstraintLayout {
    @BindView(R.id.view_movie_tv_title) TextView tvTitle;
    @BindView(R.id.view_movie_iv) ImageView ivPoster;

    public MovieItemView(Context context) {
        this(context, null);
    }

    public MovieItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(getContext(), R.layout.item_movie_view, this);
        ButterKnife.bind(this);

        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);
    }

    public View getTransitionView() {
        return ivPoster;
    }

    public void bindData(MovieModelView movie) {

        tvTitle.setText(movie.getTitle());
        ViewCompat.setTransitionName(ivPoster, String.valueOf(movie.getId()));

        Glide.with(ivPoster).load(movie.getPosterPath()).into(ivPoster);
    }
}
