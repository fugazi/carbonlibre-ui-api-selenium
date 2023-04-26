package com.api.tests.booking;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.requests.GetBookingIdRequest;

public class GetBookingIdTest {

    /**
     * This test will get a booking by id
     * GET <a href="https://restful-booker.herokuapp.com/booking/{id}">/booking/{id}</a>
     */
    @Test(description = "Regression Test")
    void getBookingIdTest() {
        GetBookingIdRequest response = new GetBookingIdRequest();
        response.newGetBookingIdRequest();
        Assert.assertEquals(response.newGetBookingIdRequest().getStatusCode(), 200);
    }
}
