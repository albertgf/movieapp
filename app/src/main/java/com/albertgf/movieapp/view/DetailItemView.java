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
    @BindView(R.id.item_detail_tv_title) TextView tvTitle;
    @BindView(R.id.item_detail_iv_poster) ImageView ivPoster;
    @BindView(R.id.item_detail_tv_overview) TextView tvOverview;

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

    public View getTransitionView() {
        return ivPoster;
    }

    public void bindData(MovieModelView movie) {

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());

        Glide.with(ivPoster).load(movie.getPosterPath()).into(ivPoster);
    }

    public void bindData(MovieModelView movie, RequestListener listener, String transitionName) {

        tvTitle.setText(movie.getTitle());
        tvOverview.setText(movie.getOverview());
        ViewCompat.setTransitionName(ivPoster, transitionName);

        Glide.with(ivPoster).load(movie.getPosterPath()).listener(listener).into(ivPoster);
    }
}
