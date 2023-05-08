package com.api.tests.booking.entities;

import lombok.Data;

@Data
public class BookingPartial {
    private String firstname;
    private String lastname;
    private long totalprice;
    private boolean depositpaid;
}
