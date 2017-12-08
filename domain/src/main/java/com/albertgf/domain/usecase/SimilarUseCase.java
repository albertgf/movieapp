package com.albertgf.domain.usecase;

import com.albertgf.domain.executor.PostExecutionThread;
import com.albertgf.domain.executor.ThreadExecutor;
import com.albertgf.domain.model.PaginationModelView;
import com.albertgf.domain.repository.MovieRepository;

import javax.inject.Inject;

/**
 * Created by albertgf on 8/12/17.
 */

public class SimilarUseCase extends UseCase<PaginationModelView, SimilarUseCase.Params> {
    private final MovieRepository repository;

    @Inject
    public SimilarUseCase(MovieRepository repository, ThreadExecutor executor,
                          PostExecutionThread postExecution) {
        super(executor, postExecution);
        this.repository = repository;
    }

    @Override
    public void run() {
        this.repository.getSimilarMovies(params.id, new RepositoryCallback());
    }

    @Override
    void buildUseCaseCallback(Params params) {
        this.params = params;
    }

    public static final class Params {
        private final int id;

        private Params(int id) {
            this.id = id;
        }

        public static SimilarUseCase.Params forId(int id) {
            return new SimilarUseCase.Params(id);
        }
    }
}
