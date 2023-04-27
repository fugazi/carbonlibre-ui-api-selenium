package com.api.tests.booking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.bodys.BookingBodyUpdate;
import com.api.tests.booking.requests.UpdateExistingBookingRequest;

public class UpdateExistingBookingTest {

    /**
     * This test will update an existing booking and verify that the booking was updated successfully.
     */
    @Test(description = "Regression Test")
    void updateExistingBookingTest() {
        BookingBodyUpdate bookingBodyUpdate = BookingBodyUpdate.getInstance();
        Response response = UpdateExistingBookingRequest.newUpdateExistingBookingRequest(bookingBodyUpdate);
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
