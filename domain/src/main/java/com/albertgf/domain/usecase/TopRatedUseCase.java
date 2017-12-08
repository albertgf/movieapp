package com.albertgf.domain.usecase;

import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.domain.model.PaginationModelView;
import com.albertgf.domain.repository.MovieRepository;

import javax.inject.Inject;

/**
 * Created by albertgf on 8/12/17.
 */

public class TopRatedUseCase extends UseCase<PaginationModelView, TopRatedUseCase.Params> {
    private final MovieRepository repository;

    @Inject
    public TopRatedUseCase(MovieRepository repository, ThreadExecutor executor,
                           PostExecutionThread postExecution) {
        super(executor, postExecution);
        this.repository = repository;
    }

    @Override
    public void run() {
        this.repository.getTopRatedMovies(params.page, new RepositoryCallback());
    }

    @Override
    void buildUseCaseCallback(Params params) {
        this.params = params;
    }

    public static final class Params {
        private final int page;

        private Params(int page) {
            this.page = page;
        }

        public static TopRatedUseCase.Params forPage(int id) {
            return new TopRatedUseCase.Params(id);
        }
    }
}
