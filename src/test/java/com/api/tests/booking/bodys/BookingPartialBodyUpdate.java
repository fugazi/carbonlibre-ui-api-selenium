package com.api.tests.booking.bodys;

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
public class BookingPartialBodyUpdate {
    private String firstname;
    private String lastname;
    private long totalprice;
    private boolean depositpaid;

    public static BookingPartialBodyUpdate getInstance() {
        BookingPartialBodyUpdate bookingPartialBodyUpdate = BookingPartialBodyUpdate.builder()
                .setFirstname("Douglas")
                .setLastname("Medellin")
                .setTotalprice(1988)
                .setDepositpaid(true)
                .build();

        log.info("bookingPartialBodyUpdate: {}", bookingPartialBodyUpdate);
        return bookingPartialBodyUpdate;
    }
}
