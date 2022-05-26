package com.api.tests.carbonlibre;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class RestfulApiTest extends BaseSetup {

    private static final String SEARCH_PRODUCT = "Bicicleta";
    private static final String PRODUCT_ID = "MLA607188579";

    /**
     * Test to get the product by name
     * Get Search Product to verify API response
     */
    @Test(description = "Regression Test")
    public void testGetSearchProduct() {
        given().get("/sites/MLA/search?q=" + SEARCH_PRODUCT)
                .then().statusCode(200)
                .and()
                .assertThat().body("query", equalTo(SEARCH_PRODUCT))
                .assertThat().body("site_id", equalTo("MLA"))
                .assertThat().body("paging.primary_results", equalTo(1000))
                .assertThat().body("paging.limit", equalTo(50));
    }

    /**
     * Test to get the product by id
     * Get Product by id to verify API response
     */
    @Test(description = "Regression Test")
    public void testGetProductPage() {
        given().get("/items/" + PRODUCT_ID)
                .then().statusCode(200)
                .and()
                .assertThat().body("id", equalTo(PRODUCT_ID))
                .assertThat().body("site_id", equalTo("MLA"))
                .assertThat().body("title", notNullValue())
                .assertThat().body("price", notNullValue())
                .assertThat().body("currency_id", notNullValue())
                .assertThat().body("accepts_mercadopago", notNullValue())
                .assertThat().body("shipping.free_methods", notNullValue());
    }
}
