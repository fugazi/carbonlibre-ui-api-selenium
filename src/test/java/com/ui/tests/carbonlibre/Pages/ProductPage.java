package com.ui.tests.carbonlibre.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='nav-logo']")
    WebElement logoPrincipal;

    @FindBy(css = ".nav-menu-categories-link")
    WebElement menuCategories;

    @FindBy(xpath = "//a[normalize-space()='Deportes y Fitness']")
    WebElement clickFitness;

    @FindBy(xpath = "//div[@class='category-list__permanlink']/h3[normalize-space()='Ciclismo']")
    WebElement clickBikes;

    @FindBy(xpath = "//span[normalize-space()='Antioquia']")
    WebElement clickPrincipalLocation;

    @FindBy(xpath = "//h2[@class='ui-search-item__title']")
    WebElement clickFirstAttributeDisplayed;

    @FindBy(xpath = "//h1[@class='ui-pdp-title']")
    WebElement getProductTitle;

    @FindBy(xpath = "//span[@class='andes-money-amount__fraction']")
    WebElement getProductPrice;

    private static final Integer PAUSE_TIME = 5000;

    /**
     * Constructor for ProductPage
     * PageFactory is used to initialize the WebElements
     */

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Method to check if the logo is displayed
     *
     * @return true if the logo is displayed, false otherwise
     */
    public boolean isLogoDisplayed() {
        return logoPrincipal.isDisplayed();
    }

    /**
     * Method to check the Product Page
     */
    public void getProductPage() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickFitness.click();
        setPause();
        clickBikes.click();
        setPause();
        clickPrincipalLocation.click();
        setPause();
        clickFirstAttributeDisplayed.click();
        setPause();
    }

    /**
     * Method to get the final Product title on the page
     */
    public String getProductTitlePage() {
        return getProductTitle.getText();
    }

    /**
     * Method to get the final price of the product on the page
     */
    public boolean getProductPricePage() {
        return getProductPrice.isDisplayed();
    }

    /**
     * Sets a pause on the page
     */
    private void setPause() {
        Actions actions = new Actions(driver);
        actions.pause(PAUSE_TIME).perform();
    }
}
