package com.webservice;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservice.Environments.BaseDomain;

/**
 * This class performs integration tests for the WebService.
 * It performs authenticating, and making an HTTP POST request to the API,
 * and expects a 201 (Created) response status code.
 */
public class WebServiceTest {
    private HttpClient httpClient;
    private String tokenLogin;

    private static final String EMAIL = "user@login.com";
    private static final String PASSWORD = "password123";
    private static final String DOMAIN_ENV_VAR = "domain";
    private static final String DOMAIN_BY_DEFAULT = "https://webservice.com";
    private static final String ENDPOINT = "/rest/service/test";

    /**
     * Initializes the HTTP client and performs user authentication to obtain the
     * token login from Login WebService.
     */
    @BeforeClass
    public void setUp() {
        httpClient = HttpClients.createDefault();
        login();
    }

    /**
     * Performs user authentication from Login WebService by making an HTTP POST request and extracts
     * the secure token from the response.
     */

    private void login() {

        HttpPost authRequest = new HttpPost("https://login.webservice.com/rest/user/");
        String authData = "email=" + EMAIL + "&password=" + PASSWORD;
        authRequest.setEntity(new StringEntity(authData, ContentType.APPLICATION_FORM_URLENCODED));

        try {
            HttpResponse response = httpClient.execute(authRequest);
            // Parse the JSON response to extract the secureToken value
            String jsonResponse = EntityUtils.toString(response.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            tokenLogin = jsonNode.get("secureToken").asText();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Performs a regression test to verify the functionality of the 'WebService' domain
     * by logging in, authenticating, and making an HTTP POST request to the API.
     * It expects the response to have a status code of 201 (Created).
     */
    @Test(description = "Regression Test")
    void verifyWebService() {
        assertNotNull(tokenLogin);
        // Determine the environment based on the base URI
        String baseUri = BaseDomain.getGlobalServiceURL(
                System.getProperty(DOMAIN_ENV_VAR) != null ? System.getProperty(DOMAIN_ENV_VAR) : DOMAIN_BY_DEFAULT);
        String apiBaseUrl = String.format("https://%s", baseUri) + ENDPOINT;

        HttpPost request = new HttpPost(apiBaseUrl);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json;q=0.9;v=1");
        request.setHeader("Secure-Token", tokenLogin);

        try {
            HttpResponse response = httpClient.execute(request);
            assertEquals(201, response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
