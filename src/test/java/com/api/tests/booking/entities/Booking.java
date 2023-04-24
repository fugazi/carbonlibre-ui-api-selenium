package com.api.tests.booking.entities;

import lombok.Data;

@Data
public class Booking {
    private String firstname;
    private String lastname;
    private long totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;
}
