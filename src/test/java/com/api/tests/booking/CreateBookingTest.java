package com.api.tests.booking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.bodys.BookingBody;
import com.api.tests.booking.requests.CreateBookingRequest;

public class CreateBookingTest {

    /**
     * This test will create a booking and verify that the booking was created successfully.
     */
    @Test(description = "Regression Test")
    void createBookingTest() {
        BookingBody bookingBody = BookingBody.getInstance();
        Response response = CreateBookingRequest.newBookingRequest(bookingBody);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
