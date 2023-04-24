package com.api.tests.carbonlibre;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.testng.annotations.Test;

public class BookingRestApiTest {

    /**
     * Test to create an Authorization token for Booking API
     */
    @Test(description = "Regression Test")
    void testCreateAuthorizationToken() {
        given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .baseUri("https://restful-booker.herokuapp.com")
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
}
