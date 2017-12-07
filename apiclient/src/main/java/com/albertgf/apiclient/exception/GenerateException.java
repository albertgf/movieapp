package com.albertgf.apiclient.exception;

import java.io.IOException;

/**
 * Created by albertgf on 3/11/17.
 */

public class GenerateException {
    public static void manageError(IOException exception) throws NetworkApiException {
        throw new NetworkApiException(-1, "Network error", exception);
    }

    public static void manageError(Exception exception) throws ApiException {
        throw new ApiException("Gson error", exception);
    }

    public static void manageNotFoundError(int code) throws NotFoundApiException {
        throw new NotFoundApiException(code, "", new Exception
                ());
    }
}
