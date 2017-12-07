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
public class TopRatedApiTest {
    private ApiClient client;
    private ApiClient clientWrongKey;

    @Before
    public void setup() {
        client = ApiClientTest.givenMovieApiClient();
        clientWrongKey = ApiClientTest.givenMovieApiClientWrongApiKey();
    }

    @Test
    public void givenCorrectApiKeyShouldGetTopRatedMovies()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        ApiResponsePagination pagination = client.getTopRatedMovies(1);

        Assert.assertNotNull(pagination);
    }

    @Test
    public void givenCorrectApiKeyShouldPaginate()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        int page = 1;
        ApiResponsePagination pagination = client.getTopRatedMovies(page);

        if(pagination.getTotalPages() >= 2) {
            pagination = client.getTopRatedMovies(++page);
            page = pagination.getPage();
        }

        Assert.assertEquals(page, 2);
    }

    @Test (expected = AuthApiException.class)
    public void givenWrongApiKeyShouldThrowAuthApiException()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        clientWrongKey.getTopRatedMovies( 1);
    }

    @Test (expected = ServerApiException.class)
    public void givenInvalidPageNumberShouldThrowServerException()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        client.getTopRatedMovies(-1);
    }

    @Test
    public void givenPageOverTotalShouldReturnEmptyArrayOfResults()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        ApiResponsePagination pagination = client.getTopRatedMovies( 1);
        pagination = client.getTopRatedMovies(pagination.getTotalPages() + 1);

        Assert.assertEquals(pagination.getResults().size(), 0);
    }
}
