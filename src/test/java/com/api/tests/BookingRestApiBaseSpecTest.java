package com.api.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.testng.annotations.Test;

import com.api.tests.booking.baseSpec.BaseSpec;

public class BookingRestApiBaseSpecTest {
    private static final String AUTH_TOKEN = "54df3d147ac531c";
    private static final String BOOKING_ID = "461";
    private static final String DELETE_BOOKING_ID = "515";

    /**
     * Test to create an Authorization token for Booking API
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     * Verify the response against the JSON schema
     */
    @Test(description = "Regression Test")
    void testCreateAuthorizationToken() {
        given()
                .spec(BaseSpec.get().build())
                .body("{\n"
                        + "  \"username\": \"admin\",\n"
                        + "  \"password\": \"password123\"\n"
                        + "}")
                .when().post("/auth")
                .then().statusCode(200)
                .and()
                .assertThat().body("token", notNullValue())
                .body(matchesJsonSchemaInClasspath("PostCreateAuthToken.json"))
                .extract().response().prettyPrint();
    }

    /**
     * Test to Get all Bookings by IDs
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     * Verify the response against the JSON schema
     */
    @Test(description = "Regression Test")
    void testGetAllBookings() {
        given()
                .spec(BaseSpec.get().build())
                .when().get("/booking")
                .then().statusCode(200)
                .and()
                .assertThat().body("bookingid[0]", notNullValue())
                .body(matchesJsonSchemaInClasspath("GetAllBookings.json"))
                .extract().response().prettyPrint();
    }

    /**
     * Test to Get a Booking by ID
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     * Verify the response against the JSON schema
     */
    @Test(description = "Regression Test")
    void testGetBookingById() {
        given()
                .spec(BaseSpec.get().build())
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
                .body(matchesJsonSchemaInClasspath("GetBookingById.json"))
                .extract().response().prettyPrint();
    }

    /**
     * Test to Create a Booking
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     * Verify the response against the JSON schema
     */
    @Test(description = "Regression Test")
    void testCreateBooking() {
        given()
                .spec(BaseSpec.get().build())
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
                .body(matchesJsonSchemaInClasspath("PostCreateBooking.json"))
                .extract().response().prettyPrint();
    }

    /**
     * Test to Update a Booking
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     * Verify the response against the JSON schema
     */
    @Test(description = "Regression Test")
    void testUpdateBooking() {
        given()
                .spec(BaseSpec.get(AUTH_TOKEN).build())
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
                .body(matchesJsonSchemaInClasspath("PutUpdateBooking.json"))
                .extract().response().prettyPrint();
    }

    /**
     * Test to Update a Booking with Partial Data
     * Call the VerifyRequestResponse class to verify the response
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     * Verify the response against the JSON schema
     */
    @Test(description = "Regression Test")
    void testUpdateBookingPartialData() {
        given()
                .spec(BaseSpec.get(AUTH_TOKEN).build())
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
                .when().patch("/booking/" + BOOKING_ID)
                .then().statusCode(200)
                .body(matchesJsonSchemaInClasspath("PutUpdateBooking.json"))
                .and()
                .extract().response().prettyPrint();
    }

    /**
     * Test to Delete a Booking
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     */
    @Test(description = "Regression Test")
    void testDeleteBooking() {
        given()
                .spec(BaseSpec.get(AUTH_TOKEN).build())
                .when().delete("/booking/" + DELETE_BOOKING_ID)
                .then().statusCode(201)
                .and()
                .assertThat().header("Content-Type", "text/plain; charset=utf-8")
                .extract().response().prettyPrint();
    }
}
