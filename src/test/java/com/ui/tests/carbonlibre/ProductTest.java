package com.ui.tests.carbonlibre;

import com.ui.tests.carbonlibre.Pages.ProductPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.ui.tests.carbonlibre.BaseUrl.getBaseUrl;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

public class ProductTest {

    public WebDriver driver;
    public ProductPage productPage;

    /**
     * Initialize the WebDriverManager and EdgeDriver.
     * Go to the website and maximize the browser window.
     */

    @BeforeClass
    void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    /**
     * Get the Base URL from the BaseSetup interface
     */

    @BeforeMethod
    void beforeTest() {
        getBaseUrl(driver);
    }

    @Test(description = "Smoke Test")
    void testHomePage() {
        productPage = new ProductPage(driver);
        assertSoftly(softly -> {
            softly.assertThat(productPage.isLogoDisplayed())
                    .describedAs("Logo is displayed")
                    .isTrue();
        });
    }

    /**
     * Test to verify the Product Page is displayed
     */
    @Test(description = "Regression Test")
    void getProductPage() {
        productPage = new ProductPage(driver);
        productPage.getProductPage();
        assertSoftly(softly -> {
            softly.assertThat(productPage.getProductTitlePage())
                    .describedAs("The final Product title is displayed")
                    .contains("Bicicleta");
            softly.assertThat(productPage.getProductPricePage())
                    .describedAs("The final price of the product is displayed")
                    .isTrue();
        });
    }

    @AfterTest
    void tearDown() {
        driver.quit();
    }
}
