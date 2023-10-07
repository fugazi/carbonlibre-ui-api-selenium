package com.api.tests;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.notNullValue;

import io.restassured.response.Response;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.api.tests.booking.baseSpec.BaseSpec;

public class BookingRestApiRefactorizedTest {
    private static String AUTH_TOKEN;
    private static String BOOKING_ID;

    @BeforeClass
    public static void setUp() {
        AUTH_TOKEN = obtainAuthorizationToken();
        BOOKING_ID = obtainBookingIdFromGetAllBookings();
    }

    /**
     * Test to create an Authorization token for Booking API
     *
     * @return AUTH_TOKEN
     */
    private static String obtainAuthorizationToken() {
        Response response = given()
                .spec(BaseSpec.get().build())
                .body("""
                        {
                          "username": "admin",
                          "password": "password123"
                        }""")
                .when().post("/auth")
                .then().statusCode(200)
                .and()
                .assertThat().body("token", notNullValue())
                .extract().response();

        return response.path("token");
    }

    /**
     * Test to obtain all Bookings by IDs
     * This test is tied to BaseSpec
     *
     * @return BOOKING_ID
     * @see BaseSpec
     */
    private static String obtainBookingIdFromGetAllBookings() {
        Response response = given()
                .spec(BaseSpec.get().build())
                .when().get("/booking")
                .then().statusCode(200)
                .and()
                .assertThat().body("bookingid[0]", notNullValue())
                .extract().response();

        int bookingIdInt = response.path("bookingid[0]");
        BOOKING_ID = String.valueOf(bookingIdInt);

        return BOOKING_ID;
    }

    /**
     * Test to Get all Bookings by IDs
     * This test is tied to BaseSpec
     *
     * @see BaseSpec
     * Verify the response against the JSON schema
     */
    @Test(description = "Regression Test", priority = 1)
    void testGetAllBookings() {
        // This test get the bookingId to obtainBookingIdFromGetAllBookings
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
    @Test(description = "Regression Test", priority = 2)
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
    @Test(description = "Regression Test", priority = 3)
    void testCreateBooking() {
        given()
                .spec(BaseSpec.get().build())
                .body("""
                        {
                            "firstname" : "Shakira",
                            "lastname" : "Colombia",
                            "totalprice" : 111,
                            "depositpaid" : true,
                            "bookingdates" : {
                                "checkin" : "2023-01-01",
                                "checkout" : "2023-04-27"
                            },
                            "additionalneeds" : "Breakfast"
                        }""")
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
    @Test(description = "Regression Test", priority = 4)
    void testUpdateBooking() {
        given()
                .spec(BaseSpec.get(AUTH_TOKEN).build())
                .body("""
                        {
                            "firstname" : "Shakira",
                            "lastname" : "Medellin",
                            "totalprice" : 1985,
                            "depositpaid" : true,
                            "bookingdates" : {
                                "checkin" : "2023-01-01",
                                "checkout" : "2023-04-27"
                            },
                            "additionalneeds" : "Breakfast"
                        }""")
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
    @Test(description = "Regression Test", priority = 5)
    void testUpdateBookingPartialData() {
        given()
                .spec(BaseSpec.get(AUTH_TOKEN).build())
                .body("""
                        {
                            "firstname" : "Shakira",
                            "lastname" : "Medellin",
                            "totalprice" : 1985,
                            "depositpaid" : true,
                            "bookingdates" : {
                                "checkin" : "2023-01-01",
                                "checkout" : "2023-04-27"
                            },
                            "additionalneeds" : "Breakfast"
                        }""")
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
    @Test(description = "Regression Test", priority = 6)
    void testDeleteBooking() {
        given()
                .spec(BaseSpec.get(AUTH_TOKEN).build())
                .when().delete("/booking/" + BOOKING_ID)
                .then().statusCode(201)
                .and()
                .assertThat().header("Content-Type", "text/plain; charset=utf-8")
                .extract().response().prettyPrint();
    }
}
