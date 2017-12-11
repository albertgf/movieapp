package com.albertgf.movieapp.navigator;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewCompat;
import android.view.View;

import com.albertgf.movieapp.activity.DetailActivity;

/**
 * Created by albertgf on 4/11/17.
 */

public class Navigator {
    public void navigateToDetail(Activity context, View imageView, View voteView, String model) {
        if (context != null) {
            Intent intentToLaunch = DetailActivity.getCallingIntent(context, ViewCompat.getTransitionName(imageView),
                    model);
            Pair<View, String> pairImage =  Pair.create(imageView,
                    ViewCompat.getTransitionName(imageView));
            Pair<View, String> pairVote =  Pair.create(voteView,
                    "tv_vote");
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                    context,
                    pairImage, pairVote);

            context.startActivity(intentToLaunch, options.toBundle());
        }
    }
}
