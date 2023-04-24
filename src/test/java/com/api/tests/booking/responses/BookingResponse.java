package com.api.tests.booking.responses;

import lombok.Data;

import com.api.tests.booking.entities.Booking;

@Data
public class BookingResponse {
    private long bookingid;
    private Booking booking;
}
