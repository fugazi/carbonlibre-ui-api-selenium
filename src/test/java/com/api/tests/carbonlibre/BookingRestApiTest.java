package com.api.tests.carbonlibre;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.testng.annotations.Test;

public class BookingRestApiTest {
    private static final String BASE_URI = "https://restful-booker.herokuapp.com";
    private static final String AUTH_TOKEN = "832ba230a683cf3";
    private static final String BOOKING_ID = "1605";

    /**
     * Test to create an Authorization token for Booking API
     */
    @Test(description = "Regression Test")
    void testCreateAuthorizationToken() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .baseUri(BASE_URI)
                .body("{\n"
                        + "  \"username\": \"admin\",\n"
                        + "  \"password\": \"password123\"\n"
                        + "}")
                .when().post("/auth")
                .then().statusCode(200)
                .and()
                .assertThat().body("token", notNullValue())
                .extract().response().prettyPrint();
    }

    /**
     * Test to Get all Bookings by IDs
     */
    @Test(description = "Regression Test")
    void testGetAllBookings() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .baseUri(BASE_URI)
                .when().get("/booking")
                .then().statusCode(200)
                .and()
                .assertThat().body("bookingid[0]", notNullValue())
                .extract().response().prettyPrint();
    }

    /**
     * Test to Get a Booking by ID
     */
    @Test(description = "Regression Test")
    void testGetBookingById() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .baseUri(BASE_URI)
                .when().get("/booking/" + BOOKING_ID)
                .then().statusCode(200)
                .and()
                .assertThat().body("firstname", notNullValue())
                .assertThat().body("lastname", notNullValue())
                .assertThat().body("totalprice", notNullValue())
                .assertThat().body("depositpaid", notNullValue())
                .assertThat().body("bookingdates.checkin", notNullValue())
                .assertThat().body("bookingdates.checkout", notNullValue())
                .assertThat().body("additionalneeds", notNullValue())
                .extract().response().prettyPrint();
    }

    /**
     * Test to Create a Booking
     */
    @Test(description = "Regression Test")
    void testCreateBooking() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .baseUri(BASE_URI)
                .body("{\n"
                        + "    \"firstname\" : \"Shakira\",\n"
                        + "    \"lastname\" : \"Colombia\",\n"
                        + "    \"totalprice\" : 111,\n"
                        + "    \"depositpaid\" : true,\n"
                        + "    \"bookingdates\" : {\n"
                        + "        \"checkin\" : \"2023-01-01\",\n"
                        + "        \"checkout\" : \"2023-04-27\"\n"
                        + "    },\n"
                        + "    \"additionalneeds\" : \"Breakfast\"\n"
                        + "}")
                .when().post("/booking")
                .then().statusCode(200)
                .and()
                .assertThat().body("bookingid", notNullValue())
                .extract().response().prettyPrint();
    }

    /**
     * Test to Update a Booking
     */
    @Test(description = "Regression Test")
    void testUpdateBooking() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + AUTH_TOKEN)
                .baseUri(BASE_URI)
                .body("{\n"
                        + "    \"firstname\" : \"Shakira\",\n"
                        + "    \"lastname\" : \"Medellin\",\n"
                        + "    \"totalprice\" : 1985,\n"
                        + "    \"depositpaid\" : true,\n"
                        + "    \"bookingdates\" : {\n"
                        + "        \"checkin\" : \"2023-01-01\",\n"
                        + "        \"checkout\" : \"2023-04-27\"\n"
                        + "    },\n"
                        + "    \"additionalneeds\" : \"Breakfast\"\n"
                        + "}")
                .when().put("/booking/" + BOOKING_ID)
                .then().statusCode(200)
                .and()
                .assertThat().body("firstname", notNullValue())
                .assertThat().body("lastname", notNullValue())
                .assertThat().body("totalprice", notNullValue())
                .assertThat().body("depositpaid", notNullValue())
                .assertThat().body("bookingdates.checkin", notNullValue())
                .assertThat().body("bookingdates.checkout", notNullValue())
                .assertThat().body("additionalneeds", notNullValue())
                .extract().response().prettyPrint();
    }

    /**
     * Test to Update a partial Booking
     */
    @Test(description = "Regression Test")
    void testUpdatePartialBooking() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + AUTH_TOKEN)
                .baseUri(BASE_URI)
                .body("{\n"
                        + "  \"firstname\": \"Shakira\",\n"
                        + "  \"lastname\": \"Petrosky\"\n"
                        + "}")
                .when().patch("/booking/" + BOOKING_ID)
                .then().statusCode(200)
                .and()
                .assertThat().body("firstname", notNullValue())
                .assertThat().body("lastname", notNullValue())
                .assertThat().body("totalprice", notNullValue())
                .assertThat().body("depositpaid", notNullValue())
                .assertThat().body("bookingdates.checkin", notNullValue())
                .assertThat().body("bookingdates.checkout", notNullValue())
                .assertThat().body("additionalneeds", notNullValue())
                .extract().response().prettyPrint();
    }

    /**
     * Test to Delete a Booking
     */
    @Test(description = "Regression Test")
    void testDeleteBooking() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Cookie", "token=" + AUTH_TOKEN)
                .baseUri(BASE_URI)
                .when().delete("/booking/" + BOOKING_ID)
                .then().statusCode(201)
                .and()
                .assertThat().header("Content-Type", "text/plain; charset=utf-8")
                .extract().response().prettyPrint();
    }
}
