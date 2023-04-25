package com.api.tests.booking.requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class GetAllBookingsRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";

    /**
     * This request will get all bookings
     */
    public Response newGetAllBookingsIdRequest() {
        return given()
                .baseUri(BASE_URI)
                .log()
                .all()
                .when().get("/booking")
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
