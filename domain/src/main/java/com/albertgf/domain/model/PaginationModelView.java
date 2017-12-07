package com.albertgf.domain.model;

import java.util.List;

/**
 * Created by albertgf on 7/12/17.
 */

public class PaginationModelView {
    private int page;
    private List<MovieModelView> results;
    private int totalResults;
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieModelView> getResults() {
        return results;
    }

    public void setResults(List<MovieModelView> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
