package com.api.tests.booking.utility;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import com.api.tests.booking.bodys.BookingBody;

public class CreateBookingRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";

    /**
     * This request will create a booking
     */
    public static Response newBookingRequest(BookingBody bookingBody) {
        return given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .baseUri(BASE_URI)
                .body(bookingBody)
                .log()
                .all()
                .when().post("/booking")
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
