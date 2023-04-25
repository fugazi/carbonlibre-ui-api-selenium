package com.api.tests.booking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.bodys.AuthTokenBody;
import com.api.tests.booking.utility.CreateAuthTokenRequest;

public class CreateAuthorizationTokenTest {

    /**
     * This test will create an authorization token and verify that the token was created successfully.
     */
    @Test(description = "Regression Test")
    void createAuthorizationTokenTest() {
        AuthTokenBody authTokenBody = AuthTokenBody.getInstance();
        Response response = CreateAuthTokenRequest.newAuthTokenRequest(authTokenBody);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
