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
import com.bumptech.glide.request.RequestListener;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by albertgf on 9/12/17.
 */

public class DetailItemView extends ConstraintLayout {
    @BindView (R.id.item_detail_tv_title) TextView tvTitle;
    @BindView (R.id.item_detail_tv_vote) TextView tvVote;
    @BindView (R.id.item_detail_iv_poster) ImageView ivPoster;
    @BindView (R.id.item_detail_tv_overview) TextView tvOverview;

    public DetailItemView(Context context) {
        this(context, null);
    }

    public DetailItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DetailItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = View.inflate(getContext(), R.layout.item_detail_view, this);
        ButterKnife.bind(this);

        LayoutParams params = new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
        view.setLayoutParams(params);
    }

    public void bindData(MovieModelView movie) {

        bindMovieText(movie);

        Glide.with(ivPoster).load(movie.getPosterPath()).into(ivPoster);
    }

    public void bindData(MovieModelView movie, RequestListener listener, String transitionName) {

        bindMovieText(movie);
        ViewCompat.setTransitionName(ivPoster, transitionName);

        Glide.with(ivPoster).load(movie.getPosterPath()).listener(listener).into(ivPoster);
    }

    private void bindMovieText(MovieModelView movie) {
        tvTitle.setText(movie.getTitle());
        tvVote.setText(String.format("%.1f", movie.getVoteAverage()));
        tvVote.setBackgroundResource(getResourceBackground((int) movie.getVoteAverage()));
        tvOverview.setText(movie.getOverview());
    }

    public int getResourceBackground(int valueInt) {
        switch (valueInt) {
            case 9:
                return R.drawable.shape_circle_9;
            case 8:
                return R.drawable.shape_circle_8;
            case 7:
                return R.drawable.shape_circle_7;
            case 6:
                return R.drawable.shape_circle_6;
            case 5:
                return R.drawable.shape_circle_5;
            default:
                return R.drawable.shape_circle_4;
        }
    }
}
