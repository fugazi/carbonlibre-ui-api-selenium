package com.api.tests.booking.requests;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import com.api.tests.booking.bodys.BookingPartialBodyUpdate;

public class UpdatePartialBookingRequest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";
    private static final String TOKEN = "62b5f7d516ec735";
    private static final String BOOKING_ID = "814";

    /**
     * This request will update an partial booking id
     * Parameters: firstname, lastname, totalprice, depositpaid
     */
    public static Response newUpdatePartialBookingRequest(BookingPartialBodyUpdate bookingBodyUpdatePartial) {
        return given()
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .cookie("token", TOKEN)
                .baseUri(BASE_URI)
                .pathParam("id", BOOKING_ID)
                .body(bookingBodyUpdatePartial)
                .log()
                .all()
                .when().patch("/booking/{id}")
                .then()
                .and()
                .log()
                .all()
                .extract().response();
    }
}
