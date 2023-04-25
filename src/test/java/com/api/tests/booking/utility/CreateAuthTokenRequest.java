package com.api.tests.booking.utility;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import com.api.tests.booking.bodys.AuthTokenBody;

public class CreateAuthTokenRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";

    /**
     * This request will create Authorization Token
     */
    public static Response newAuthTokenRequest(AuthTokenBody authTokenBody) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .baseUri(BASE_URI)
                .body(authTokenBody)
                .log()
                .all()
                .when().post("/auth")
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
