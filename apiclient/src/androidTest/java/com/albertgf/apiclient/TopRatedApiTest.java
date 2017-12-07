package com.albertgf.apiclient;

import android.support.test.filters.SmallTest;
import android.support.test.runner.AndroidJUnit4;

import com.albertgf.apiclient.exception.AuthApiException;
import com.albertgf.apiclient.exception.NetworkApiException;
import com.albertgf.apiclient.exception.NotFoundApiException;
import com.albertgf.apiclient.exception.ServerApiException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by albertgf on 7/12/17.
 */

@RunWith (AndroidJUnit4.class)
@SmallTest
public class TopRatedApiTest {
    private ApiClient client;

    @Before
    public void setup() {
        client = ApiClientTest.givenMovieApiClient();
    }

    @Test (expected = AuthApiException.class)
    public void givenPokemonIdShouldGetPokemon()
            throws NetworkApiException, AuthApiException, NotFoundApiException, ServerApiException {
        client.getTopRatedMovies("testt", 1);
    }
}
