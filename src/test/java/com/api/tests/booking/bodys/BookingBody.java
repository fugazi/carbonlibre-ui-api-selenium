package com.api.tests.booking.bodys;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import com.api.tests.booking.entities.BookingDates;

@Slf4j
@Data
public class BookingBody {
    private String firstname;
    private String lastname;
    private long totalprice;
    private boolean depositpaid;
    private BookingDates bookingdates;
    private String additionalneeds;

    public static BookingBody getInstance() {
        BookingBody bookingBody = new BookingBody();
        bookingBody.setFirstname("Shakira");
        bookingBody.setLastname("Colombia");
        bookingBody.setTotalprice(1985);
        bookingBody.setDepositpaid(true);

        BookingDates bookingDate = new BookingDates();
        bookingDate.setCheckin("2023-01-01");
        bookingDate.setCheckout("2023-04-27");
        bookingBody.setBookingdates(bookingDate);
        bookingBody.setAdditionalneeds("Dinner");

        log.info("bookingBody: {}", bookingBody );
        return bookingBody;
    }
}
