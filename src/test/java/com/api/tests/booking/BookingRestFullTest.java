package com.api.tests.booking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.bodys.AuthTokenBody;
import com.api.tests.booking.bodys.BookingBody;
import com.api.tests.booking.utility.CreateAuthTokenRequest;
import com.api.tests.booking.utility.CreateBookingRequest;
import com.api.tests.booking.utility.GetAllBookingsRequest;

public class BookingRestFullTest {

    /**
     * This test will create an authorization token and verify that the token was created successfully.
     * POST <a href="https://restful-booker.herokuapp.com/auth">/auth</a>
     */
    @Test(description = "Regression Test")
    void createAuthorizationTokenTest() {
        AuthTokenBody authTokenBody = AuthTokenBody.getInstance();
        Response response = CreateAuthTokenRequest.newAuthTokenRequest(authTokenBody);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    /**
     * This test will create a booking and verify that the booking was created successfully.
     * POST <a href="https://restful-booker.herokuapp.com/booking">/booking</a>
     */
    @Test(description = "Regression Test")
    void createBookingTest() {
        BookingBody bookingBody = BookingBody.getInstance();
        Response response = CreateBookingRequest.newBookingRequest(bookingBody);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

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
