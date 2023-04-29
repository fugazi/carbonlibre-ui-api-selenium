package com.api.tests.booking.requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import com.api.tests.booking.bodys.BookingBodyUpdate;

public class UpdateExistingBookingRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";
    private static final String TOKEN = "2d171bc7532ea09";
    private static final String BOOKING_ID = "1068";

    /**
     * This request will update an existing booking id
     * Parameters: firstname, lastname
     */
    public static Response newUpdateExistingBookingRequest(BookingBodyUpdate bookingBodyUpdate) {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .cookie("token", TOKEN)
                .baseUri(BASE_URI)
                .pathParam("id", BOOKING_ID)
                .body(bookingBodyUpdate)
                .log()
                .all()
                .when().put("/booking/{id}")
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
