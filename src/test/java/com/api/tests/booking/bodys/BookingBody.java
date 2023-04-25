package com.api.tests.booking.bodys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.api.tests.booking.entities.BookingDates;

@Slf4j
@Data
@NoArgsConstructor
@Builder(setterPrefix = "set")
@AllArgsConstructor
public class BookingBody {
    private String firstname;
    private String lastname;
    private long totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public static BookingBody getInstance() {
        BookingDates bookingDate = BookingDates.builder()
                .setCheckin("2023-01-01")
                .setCheckout("2023-04-27")
                .build();
        BookingBody bookingBody = BookingBody.builder()
                .setFirstname("Shakira")
                .setLastname("Colombia")
                .setTotalprice(1985)
                .setDepositpaid(true)
                .setBookingdates(bookingDate)
                .setAdditionalneeds("Dinner")
                .build();

        log.info("bookingBody: {}", bookingBody);
        return bookingBody;
    }
}
