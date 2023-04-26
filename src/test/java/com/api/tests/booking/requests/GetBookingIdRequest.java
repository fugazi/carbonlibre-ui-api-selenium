package com.api.tests.booking.requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class GetBookingIdRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";
    private static final String BOOKING_ID = "1233";

    /**
     * This request will get a booking by id
     */
    public Response newGetBookingIdRequest() {
        return given()
                .baseUri(BASE_URI)
                .log()
                .all()
                .when().get("/booking/" + BOOKING_ID)
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
