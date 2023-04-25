package com.api.tests.booking;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.requests.GetAllBookingsRequest;

public class GetAllBookingsTest {

    /**
     * This test will get all bookings and verify the response code
     * GET <a href="https://restful-booker.herokuapp.com/booking">/booking</a>
     */
    @Test(description = "Regression Test")
    void getAllBookingsTest() {
        GetAllBookingsRequest response = new GetAllBookingsRequest();
        response.newGetAllBookingsIdRequest();
        Assert.assertEquals(response.newGetAllBookingsIdRequest().getStatusCode(), 200);
    }
}
