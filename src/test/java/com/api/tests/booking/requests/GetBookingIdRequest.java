package com.api.tests.booking.requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class GetBookingIdRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";
    private static final String BOOKING_ID = "20";

    /**
     * This request will get a booking by id
     */
    public Response newGetBookingIdRequest() {
        return given()
                .header("Accept", "application/json")
                .baseUri(BASE_URI)
                .pathParam("id", BOOKING_ID)
                .log()
                .all()
                .when().get("/booking/{id}")
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
