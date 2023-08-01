package com.api.tests.booking.requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

public class DeleteBookingRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";
    private static final String TOKEN = "6232db30bdea04e";
    private static final String DELETE_BOOKING_ID = "1200";

    /**
     * This request will delete an existing booking id
     * Parameters: complete body request
     */
    public static Response newDeleteBookingRequest() {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .cookie("token", TOKEN)
                .baseUri(BASE_URI)
                .pathParam("id", DELETE_BOOKING_ID)
                .log()
                .all()
                .when().delete("/booking/{id}")
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
