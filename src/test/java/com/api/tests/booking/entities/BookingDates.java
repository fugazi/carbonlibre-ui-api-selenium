package com.api.tests.booking.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Builder(setterPrefix = "set")
@AllArgsConstructor
public class BookingDates {
    private String checkin;
    private String checkout;
}
