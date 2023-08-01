package com.api.tests.booking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.requests.DeleteBookingRequest;

public class DeleteBookingTest {

    /**
     * This test will delete an existing booking id
     */
    @Test(description = "Regression Test")
    void deleteBookingTest() {
        Response response = DeleteBookingRequest.newDeleteBookingRequest();
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
