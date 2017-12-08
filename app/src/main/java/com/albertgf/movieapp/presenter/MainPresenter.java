package com.albertgf.movieapp.presenter;


import com.albertgf.domain.model.MovieModelView;
import com.albertgf.domain.model.PaginationModelView;
import com.albertgf.domain.usecase.DefaultCallback;
import com.albertgf.domain.usecase.TopRatedUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by albertgf on 8/12/17.
 */

public class MainPresenter implements Presenter {
    private final TopRatedUseCase topRatedUseCase;
    private View view;
    private int totalPages;
    private int page;

    @Inject
    public MainPresenter(TopRatedUseCase topRatedUseCase) {
        this.topRatedUseCase = topRatedUseCase;
    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;
    }

    @Override public void onViewDetached() {

    }

    public interface View extends PresenterView {
        void bindMovies(List<MovieModelView> list);
    }

    private class TopRatedCallback extends DefaultCallback<PaginationModelView> {
        @Override
        public void onNext(PaginationModelView pagination) {
            totalPages = pagination.getTotalPages();
            page = pagination.getPage();
            view.bindMovies(pagination.getResults());
        }

        @Override
        public void onComplete() {
            super.onComplete();

        }

        @Override
        public void onError(Throwable exception) {
            //TODO MANAGE ERROR
        }
    }
}
