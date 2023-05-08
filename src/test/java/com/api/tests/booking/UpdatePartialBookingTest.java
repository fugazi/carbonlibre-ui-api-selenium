package com.api.tests.booking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.bodys.BookingPartialBodyUpdate;
import com.api.tests.booking.requests.UpdatePartialBookingRequest;

public class UpdatePartialBookingTest {

    /**
     * This test will update a partial booking and verify that the booking was updated successfully.
     */
    @Test(description = "Regression Test")
    void updatePartialBookingTest() {
        BookingPartialBodyUpdate bookingBodyUpdatePartial = BookingPartialBodyUpdate.getInstance();
        Response response = UpdatePartialBookingRequest.newUpdatePartialBookingRequest(bookingBodyUpdatePartial);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("firstname"), "Douglas");
        Assert.assertEquals(response.jsonPath().get("lastname"), "Medellin");
        Assert.assertEquals(response.jsonPath().getLong("totalprice"), 1988);
        Assert.assertTrue(response.jsonPath().getBoolean("depositpaid"), "Deposit paid is true");
    }
}
