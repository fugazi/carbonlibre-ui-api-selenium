package com.api.tests.carbonlibre;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

import org.testng.annotations.Test;

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
                .assertThat().body("site_id", equalTo("MLA"))
                .assertThat().body("query", equalTo("Bicicleta"))
                .assertThat().body("results.id[1]", equalTo("MLA1319801763"))
                .assertThat().body("results.price[0]", equalTo(75093))
                .assertThat().body("paging.primary_results", equalTo(1000));
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
                .assertThat().body("currency_id", equalTo("ARS"))
                .assertThat().body("title", notNullValue())
                .assertThat().body("price", notNullValue())
                .assertThat().body("currency_id", notNullValue())
                .assertThat().body("accepts_mercadopago", notNullValue())
                .assertThat().body("shipping.free_shipping", notNullValue());
    }
}
