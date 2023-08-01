package com.api.tests.booking;

import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.tests.booking.bodys.AuthTokenBody;
import com.api.tests.booking.bodys.BookingBody;
import com.api.tests.booking.bodys.BookingBodyUpdate;
import com.api.tests.booking.bodys.BookingPartialBodyUpdate;
import com.api.tests.booking.requests.CreateAuthTokenRequest;
import com.api.tests.booking.requests.CreateBookingRequest;
import com.api.tests.booking.requests.DeleteBookingRequest;
import com.api.tests.booking.requests.GetAllBookingsRequest;
import com.api.tests.booking.requests.GetBookingIdRequest;
import com.api.tests.booking.requests.UpdateExistingBookingRequest;
import com.api.tests.booking.requests.UpdatePartialBookingRequest;

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

    /**
     * This test will get a booking by id
     * GET <a href="https://restful-booker.herokuapp.com/booking/">/booking/{id}</a>
     */
    @Test(description = "Regression Test")
    void getBookingIdTest() {
        GetBookingIdRequest response = new GetBookingIdRequest();
        response.newGetBookingIdRequest();
        Assert.assertEquals(response.newGetBookingIdRequest().getStatusCode(), 200);
    }

    /**
     * This test will update an existing booking and verify that the booking was updated successfully.
     */
    @Test(description = "Regression Test")
    void updateExistingBookingTest() {
        BookingBodyUpdate bookingBodyUpdate = BookingBodyUpdate.getInstance();
        Response response = UpdateExistingBookingRequest.newUpdateExistingBookingRequest(bookingBodyUpdate);
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("firstname"), "Shakira");
        Assert.assertEquals(response.jsonPath().getString("lastname"), "Colombia");
        Assert.assertTrue(response.jsonPath().getBoolean("depositpaid"), "Deposit paid is true");
    }

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

    /**
     * This test will delete an existing booking id and verify that the booking was deleted successfully.
     */
    @Test(description = "Regression Test")
    void deleteBookingTest() {
        Response response = DeleteBookingRequest.newDeleteBookingRequest();
        Assert.assertEquals(response.getStatusCode(), 201);
    }
}
