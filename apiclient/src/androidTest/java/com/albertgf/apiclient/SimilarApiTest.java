package com.albertgf.apiclient;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albertgf.apiclient.exception.AuthApiException;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;
import com.albertgf.apiclient.model.ApiResponsePagination;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.albertgf.apiclient.ApiClientTest.API_KEY;

/**
 * Created by albertgf on 7/12/17.
 */

@RunWith (AndroidJUnit4.class)
@SmallTest
public class SimilarApiTest {
    private ApiClient client;
    private ApiClient clientWrongKey;

    @Before
    public void setup() {
        client = ApiClientTest.givenMovieApiClient();
        clientWrongKey = ApiClientTest.givenMovieApiClientWrongApiKey();
    }

    @Test
    public void givenCorrectApiKeyShouldGetSimilarMovies()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        ApiResponsePagination pagination = client.getTopRatedMovies(1);
        ApiResponsePagination similarMovies = client.getSimilarMovies(pagination.getResults().get(0).getId());

        Assert.assertNotNull(similarMovies);
    }

    @Test (expected = AuthApiException.class)
    public void givenWrongApiKeyShouldThrowAuthApiException()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        clientWrongKey.getSimilarMovies(1);
    }

    @Test (expected = NotFoundApiException.class)
    public void givenInvalidMovieIdShouldThrowNotFoundException()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        client.getSimilarMovies(-1);
    }
}
