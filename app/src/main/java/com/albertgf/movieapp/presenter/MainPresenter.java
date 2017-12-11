package com.albertgf.movieapp.presenter;


import com.albertgf.apiclient.exception.ApiException;
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
    private int page = 1;

    private boolean isLoading = false;

    @Inject
    public MainPresenter(TopRatedUseCase topRatedUseCase) {
        this.topRatedUseCase = topRatedUseCase;
    }

    @Override public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;

        topRatedUseCase.execute(new TopRatedCallback(), TopRatedUseCase.Params.forPage(page));
    }

    @Override public void onViewDetached() {

    }

    public void paginateMovies() {
        if(page < totalPages && !isLoading) {
            isLoading = true;
            topRatedUseCase.execute(new TopRatedCallback(), TopRatedUseCase.Params.forPage(++page));
        }
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
            isLoading = false;
        }

        @Override
        public void onComplete() {
            super.onComplete();
            isLoading = false;

        }

        @Override
        public void onError(Throwable exception) {
            isLoading = false;
            ApiException apiException = (ApiException) exception;

            switch (apiException.getTypeException()) {
                case AUTH:

                    break;
                case SERVER:

                    break;
                case NETWORK:

                    break;
                case NOTFOUND:

                    break;
            }
        }
    }
}
