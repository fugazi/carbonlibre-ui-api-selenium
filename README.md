
# Carbon Libre - UI Tests - API Tests Project

This is an Automation project using Java with Selenium Webdriver for UI Tests and REST Assured for API Tests.
This project has been developed by Douglas Urrea Ocampo to improve learning on advanced Automation testing.

The main features of this project has the following:

* Page Object Model (POM) as a design pattern for creating an Object directory for web UI elements.
* Page Factory is a class provided by Selenium WebDriver to support Page Object Design patterns. In Page Factory, tester used @FindBy annotation. The initElements method is used to initialize web elements.
* Interface to bind static constants and abstract methods to achieve Data Abstraction and multiple Inheritance.
* The re-usability of code to avoid unnecessary data exposure to the user by using the abstraction.
* TestNG is a framework for writing test automation tests.
* REST Assured is a framework for writing RESTful API tests.
* Selenium Webdriver is a webdriver that supports UI Tests.

## 🏠 Tester details
* Name: `Douglas Urrea Ocampo`
* Country: `Colombia`
* City: `Medellin`
* E-mail: `itmteleco@gmail.com`
* LinkedIn: [https://www.linkedin.com/in/douglasfugazi](https://www.linkedin.com/in/douglasfugazi)
* Contact: [https://douglasfugazi.co](https://douglasfugazi.co)

### ⚡️Automation Test Strategy
This is an end-to-end UI tests using Selenium Webdriver and API tests using REST Assured.
The website under test was MercadoLibre e-commerce website [here](https://www.mercadolibre.com) with a BaseUrl to test different domain access according to the desired location. I must say it was fun learning and automating this website because it was challenging in some respects.

1. Browser is Microsoft Edge in order to have a different approach to test.
2. User will navigate to the website and select a category on the navigation menu and verify the total results on the page.
3. User will select a product and verify the product details.
4. End-to-end UI tests has the following scenarios:
    * Scenario 1:
        * Test to verify the "Air Condition" category workflow
    * Scenario 2:
        * Test to verify the "Smartphones" category workflow
    * Scenario 3:
        * Test to verify the "Fragrances" category workflow
    * Scenario 4:
        * Test to verify the "Tools" category workflow
    * Scenario 5:
        * Test to verify the "Baby" category workflow
    * Scenario 6:
        * Test to verify the Logo Page is displayed
    * Scenario 7:
        * Test to verify the Product Page with the product details
5. REST API tests has the following scenarios:
    * Scenario 1:
        * Test to get the product by name
        * Method GET to Search Product to verify API response
    * Scenario 2:
        * Test to get the product by id
        * Method GET to Product by id to verify API response
6. After the test, assertions will be validated to each test, user will check for the logo and select a product and verify the product details.
7. Annotation @Test will be used to group the tests by Smoke and Regression tests.
8. Each tests will finish automatically and the browser will be closed.

## 🤿 Pre-requisites:
1. Download the latest Java JDK from [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133155.html)
2. Install git from [here](https://git-scm.com)
3. Selenium Webdriver from [here](https://www.selenium.dev)
4. Get WebDriverManager from [here](https://bonigarcia.dev/webdrivermanager/)
5. Install Apache Maven from [here](https://maven.apache.org)
6. Test Runner is TestNG 7 from [here](https://www.testng.org/downloads.html)
7. API REST Assured from [here](https://rest-assured.io/)
8. Build Tool is Maven the latest version
9. Note: ChromeDriver.exe is not necessary, you should use the WebDriverManager capabilities.
10. Note: POM.xml has all configuration installed, you should use the Maven build tool only.

## 🛠️ Running the project:
1. Download the project from GitHub
    * Option 1: `git clone https://github.com/fugazi/carbonlibre-ui-api-selenium.git`
    * Option 2: Download it as a Zip file and extract it
2. CD into the `Carbon Libre > carbonlibre-ui-api-selenium` folder
3. Set up Maven
   1. Run the following command in the terminal:
       * Option 1: `mvn clean`
       * Option 2: `mvn clean package`
4. Running Tests in the project
    * Option 1: run `mvn clean install` in the path of the project 
    * Option 2: Open the project baseline and run each Selenium Test and REST API tests
5. Enjoy the project! 😎

### ✏️Step by Step tutorial

TBA

### 🚴 Project configuration
* Selenium project Baseline: `Carbon Libre`
  * Base Interface `BaseUrl.java` into folder `src\test\java\com\ui\tests`
  * Selenium UI Tests `CategoriesTest.java` into folder `src\test\java\com\ui\tests`
  * Selenium UI Tests `ProductTest.java` (Tests with Login Credentials) into folder `src\test\java\com\ui\tests`
  * Page Factory Objects `CategoriesPage.java` into folder `src\test\java\com\ui\tests\carbonlibre\Pages`
  * Page Factory Objects `ProductPage.java` into folder `src\test\java\com\ui\tests\carbonlibre\Pages`
* testName: `ui.tests.carbonlibre.CategoriesTest` and `ui.tests.carbonlibre.ProductTest`
+
* API RestAssured project Baseline: `Carbon Libre`
  * Base Utility Class `BaseSetup.java` into folder `src\test\java\com\api\tests`
  * REST API Tests `RestfulApiTest.java` into folder `src\test\java\com\api\tests`
* testName: `api.tests.carbonlibre.RestfulApiTest`
