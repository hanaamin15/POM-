package Pages;


import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage {

    WebDriver driver;

    // Locators
    private final By username = By.id("user-name");
    private final By password = By.cssSelector("input[type='password']");
    private final By loginButton = By.id("login-button");

    private Actions actionBot;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.actionBot = new Actions(driver);
    }

    // Login method
    @Step("Login with username: {user} and password: {pass}")
    public LoginPage login(String user, String pass) {

        actionBot.click(driver.findElement(username))
                .sendKeys(user)
                .perform();

        actionBot.click(driver.findElement(password))
                .sendKeys(pass)
                .perform();

        actionBot.click(driver.findElement(loginButton))
                .perform();

        return this;
    }

    // Validation method
    @Step("Validate login success with expected URL: {expectedUrl}")
    public HomePage isLoginSuccessful(String expectedUrl) {

        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

        return new HomePage(driver);
    }
}
