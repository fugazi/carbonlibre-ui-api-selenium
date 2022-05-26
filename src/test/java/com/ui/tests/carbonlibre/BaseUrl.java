package com.ui.tests.carbonlibre;

import org.openqa.selenium.WebDriver;

public interface BaseUrl {
    String DOMAIN_ENV_VAR = "domain";
    String DOMAIN_BY_DEFAULT = "www.mercadolibre.com";
    String DOMAIN = System.getenv(DOMAIN_ENV_VAR) != null ? System.getenv(DOMAIN_ENV_VAR) : DOMAIN_BY_DEFAULT;
    String BASE_URL = DOMAIN + ".co";
    String BASE_URL_WITH_PROTOCOL = "https://" + BASE_URL;

    /**
     * Initialize the WebDriver instance.
     * Get the current URL and set it as the base URL.
     */
    static void getBaseUrl(WebDriver driver) {
        driver.get(BASE_URL_WITH_PROTOCOL);
        driver.getCurrentUrl();
    }
}
