package com.api.tests.booking.assertions;

import io.restassured.response.Response;

import org.assertj.core.api.SoftAssertions;

import com.api.tests.booking.responses.BookingResponse;

public class VerifyRequestResponse {
    private final Response response;
    private final SoftAssertions softly;

    private VerifyRequestResponse(Response response) {
        this.response = response;
        softly = new SoftAssertions();
    }

    public static VerifyRequestResponse verify(Response response) {
        return new VerifyRequestResponse(response);
    }

    /**
     * This method verify the response status code
     * @return this
     */
    public VerifyRequestResponse statusCode(int statusCode) {
        softly.assertThat(response.getStatusCode())
                .describedAs("Verify response status code")
                .isEqualTo(statusCode);
        return this;
    }

    /**
     * This method verify the response body
     * @return this
     * https://www.youtube.com/watch?v=3U_3SLOxnJg
     * 4:56
     */
    public VerifyRequestResponse hasBookingId(String bookingid) {
        BookingResponse bookingResponse = response.as(BookingResponse.class);
        softly.assertThat(response.getBody().asString())
                .describedAs("Verify response body")
                .isEqualTo(bookingid);
        return this;
    }

    public void assertAll() {
        softly.assertAll();
    }
}
