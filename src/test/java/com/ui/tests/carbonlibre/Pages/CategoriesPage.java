package com.ui.tests.carbonlibre.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage {
    WebDriver driver;

    // Elements to "Climatización" category
    @FindBy(xpath = "//a[@class='nav-logo']")
    WebElement logoPrincipal;

    @FindBy(css = ".nav-menu-categories-link")
    WebElement menuCategories;

    @FindBy(xpath = "//a[normalize-space()='Electrodomésticos']")
    WebElement homeAppliances;

    @FindBy(xpath = "//div[@class='label']/h3[contains(.,'Climatización')]")
    WebElement clickAirConditioning;

    @FindBy(xpath = "//h1[@class='ui-search-breadcrumb__title']")
    WebElement getAirConditioningTitle;

    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']")
    WebElement getResults;

    // Elements to "Smartphones" category
    @FindBy(xpath = "//a[normalize-space()='Tecnología']")
    WebElement mouseOverTechnology;

    @FindBy(xpath = "//ul[@class='nav-categs-detail__categ-list']//a[normalize-space()='Celulares y Smartphones']")
    WebElement clickSmartphones;

    @FindBy(xpath = "//h1[@class='ui-search-breadcrumb__title']")
    WebElement getSmartphonesTitle;

    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']")
    WebElement getSmartphonesResults;

    // Elements to "Fragrances" category
    @FindBy(xpath = "//a[normalize-space()='Belleza y Cuidado Personal']")
    WebElement clickBeauty;

    @FindBy(xpath = "//h3[normalize-space()='Perfumes y Fragancias']")
    WebElement clickFragrances;

    @FindBy(xpath = "//h1[@class='ui-search-breadcrumb__title']")
    WebElement getFragrancesTitle;

    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']")
    WebElement getFragrancesResults;

    // Elements to "Tools" category
    @FindBy(xpath = "//a[normalize-space()='Herramientas']")
    WebElement clickTools;

    @FindBy(xpath = "//h3[normalize-space()='Herramientas Industriales']")
    WebElement clickIndustrialTools;

    @FindBy(xpath = "//h1[@class='ui-search-breadcrumb__title']")
    WebElement getToolsTitle;

    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']")
    WebElement getToolsResults;

    // Elements to "Baby" category
    @FindBy(xpath = "//a[normalize-space()='Bebés']")
    WebElement clickBaby;

    @FindBy(xpath = "//div[@class='label']/h3[contains(.,'CUARTO DEL BEBÉ')]")
    WebElement clickBabyProducts;

    @FindBy(xpath = "//h1[@class='ui-search-breadcrumb__title']")
    WebElement getBabyTitle;

    @FindBy(xpath = "//span[@class='ui-search-search-result__quantity-results']")
    WebElement getBabyResults;

    private static final Integer PAUSE_TIME = 3000;

    /**
     * Constructor for CategoriesPage
     * PageFactory is used to initialize the WebElements
     */
    public CategoriesPage(WebDriver driver) {
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
     * Method to check "Air Conditioning" category
     */
    public void airConditionCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        homeAppliances.click();
        setPause();
        clickAirConditioning.click();
    }

    /**
     * Method to get the Air Conditioning title of the page
     */
    public String getAirTitle() {
        return getAirConditioningTitle.getText();
    }

    /**
     * Method to get the total number of results of Air Conditioning
     */
    public boolean getTotalResults() {
        return getResults.isDisplayed();
    }

    /**
     * Method to check "Smartphones" category
     */
    public void smartphonesCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        action.moveToElement(mouseOverTechnology).build().perform();
        setPause();
        clickSmartphones.click();
    }

    /**
     * Method to get the Smartphones title of the page
     */
    public String getSmartphonesTitle() {
        return getSmartphonesTitle.getText();
    }

    /**
     * Method to get the total number of results of Smartphones
     */
    public boolean getSmartphonesResults() {
        return getSmartphonesResults.isDisplayed();
    }

    /**
     * Method to check "Fragrances" category
     */
    public void fragrancesCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickBeauty.click();
        setPause();
        clickFragrances.click();
    }

    /**
     * Method to get the Fragrances title of the page
     */
    public String getFragrancesTitle() {
        return getFragrancesTitle.getText();
    }

    /**
     * Method to get the total number of results of Fragrances
     */
    public boolean getFragrancesResults() {
        return getFragrancesResults.isDisplayed();
    }

    /**
     * Method to check "Tools" category
     */
    public void toolsCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickTools.click();
        setPause();
        clickIndustrialTools.click();
    }

    /**
     * Method to get the Tools title of the page
     */
    public String getToolsTitle() {
        return getToolsTitle.getText();
    }

    /**
     * Method to get the total number of results of Tools
     */
    public boolean getToolsResults() {
        return getToolsResults.isDisplayed();
    }

    /**
     * Method to check "Baby" category
     */
    public void babyCategory() {
        Actions action = new Actions(driver);
        action.moveToElement(menuCategories).build().perform();
        setPause();
        clickBaby.click();
        setPause();
        clickBabyProducts.click();
    }

    /**
     * Method to get the Baby title of the page
     */
    public String getBabyTitle() {
        return getBabyTitle.getText();
    }

    /**
     * Method to get the total number of results of Baby
     */
    public boolean getBabyResults() {
        return getBabyResults.isDisplayed();
    }


    /**
     * Sets a pause on the page
     */
    private void setPause() {
        Actions actions = new Actions(driver);
        actions.pause(PAUSE_TIME).perform();
    }
}
