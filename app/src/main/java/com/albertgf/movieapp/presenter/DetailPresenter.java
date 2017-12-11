package com.albertgf.movieapp.presenter;


import com.albertgf.apiclient.exception.ApiException;
import com.albertgf.domain.model.MovieModelView;
import com.albertgf.domain.model.PaginationModelView;
import com.albertgf.domain.usecase.DefaultCallback;
import com.albertgf.domain.usecase.SimilarUseCase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by albertgf on 8/12/17.
 */

public class DetailPresenter implements Presenter {
    private final SimilarUseCase similarUseCase;
    private View view;

    @Inject
    public DetailPresenter(SimilarUseCase similarUseCase) {
        this.similarUseCase = similarUseCase;
    }

    @Override
    public void onViewAttached(PresenterView view, boolean isNew) {
        this.view = (View) view;
    }

    @Override
    public void onViewDetached() {

    }

    public void setMovie(MovieModelView movie) {
        similarUseCase.execute(new SimilarCallback(), SimilarUseCase.Params.forId(movie.getId()));
    }

    public interface View extends PresenterView {
        void bindMovies(List<MovieModelView> list);
    }

    private class SimilarCallback extends DefaultCallback<PaginationModelView> {
        @Override
        public void onNext(PaginationModelView pagination) {
            view.bindMovies(pagination.getResults());
        }

        @Override
        public void onComplete() {
            super.onComplete();

        }

        @Override
        public void onError(Throwable exception) {
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
