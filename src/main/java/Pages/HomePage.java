package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    //Locators for the home page elements
    private final By username = By.id("user-name");
    private final By password = By.cssSelector("input[type='password']");
    private final By loginButton = By.id("login-button");

    private final By menuList =By.xpath("//button[@type='button']");
    private final By shoppingCart = By.cssSelector("[data-test='shopping-cart-link']");

    //Constructor to initialize the WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Method to perform login action
    public LoginPage login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginButton).click();
        return new LoginPage(driver);
    }

    //Validation method to check if login was successful
    public HomePage isLoginSuccessful(String expectedUrl) {
        String actualUrl = driver.getCurrentUrl();
        if (!actualUrl.equals(expectedUrl)) {
            throw new AssertionError("Login was not successful. Expected URL: " + expectedUrl + ", but got: " + actualUrl);

        }
        return this;
    }

    // Additional methods for interacting with the home page can be added here
    public HomePage clickMenuList() {
        driver.findElement(menuList).click();
        return this;

    }
    public HomePage clickShoppingCart() {
        driver.findElement(shoppingCart).click();
        return this;
    }
}
