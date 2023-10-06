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

import com.webservice.Environments.BaseDomain;

public class WebServiceTest {
    private HttpClient httpClient;
    private String secureToken;

    private static final String EMAIL = "user@login.com";
    private static final String PASSWORD = "password123";
    private static final String DOMAIN_ENV_VAR = "domain";
    private static final String DOMAIN_BY_DEFAULT = "https://webservice.com";
    private static final String ENDPOINT = "/rest/user/login";

    @BeforeClass
    public void setUp() {
        httpClient = HttpClients.createDefault();
        login();
    }

    /**
     * WebService Login
     */

    private void login() {

        HttpPost authRequest = new HttpPost(DOMAIN_BY_DEFAULT + ENDPOINT);
        String authData = "email=" + EMAIL + "&password=" + PASSWORD;
        authRequest.setEntity(new StringEntity(authData, ContentType.APPLICATION_FORM_URLENCODED));

        // Determine the environment based on the base URI
        String baseUri = BaseDomain.getGlobalServiceURL(
                System.getProperty(DOMAIN_ENV_VAR) != null ? System.getProperty(DOMAIN_ENV_VAR) : DOMAIN_BY_DEFAULT);
        String apiBaseUrl = String.format("https://%s", baseUri) + ENDPOINT;

        try {
            HttpResponse response = httpClient.execute(authRequest);
            assertEquals(200, response.getStatusLine().getStatusCode());
            secureToken = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * WebService SignOut
     */
    @Test(description = "Regression Test")
    void verifySignOut() {
        assertNotNull(secureToken);

        HttpPost request = new HttpPost("https://webservice.com/rest/user/logout");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Accept", "application/json;q=0.9;v=1");
        request.setHeader("Identity-Token", secureToken);

        try {
            HttpResponse response = httpClient.execute(request);
            assertEquals(201, response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
