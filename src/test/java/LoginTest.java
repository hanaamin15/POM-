import Pages.LoginPage;
import Utils.PropertyReader;
import drivers.WebDriverFactory;
import io.qameta.allure.*;
import io.qameta.allure.testng.Tag;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver ;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    @Description("This test verifies that a user can log in with valid credentials.")
    @Tag("Valid Login")
    @Owner("Hana Amin")
    @Severity(SeverityLevel.CRITICAL)
    @Link(name = "Saucedemo", url = "https://www.saucedemo.com/")
    @TmsLink("https://hana6amin01.atlassian.net/jira/software/projects/PID/apps/3feb7ced-1450-4676-aded-099c99bf534b/2baaeb69-15ac-4955-8eb6-e346aa1567aa#/v2/testCases?projectId=10165")
    @Issue("https://hana6amin01.atlassian.net/browse/PID-2")

    public void testLoginValid() {
        // Test implementation here
         new LoginPage(driver).login(PropertyReader.getProperty("ValidUsername"), PropertyReader.getProperty("ValidPassword")).isLoginSuccessful("https://www.saucedemo.com/inventory.html");
        Allure.getLifecycle().updateTest(testResult -> testResult.setName("Valid log-in test"));

    }


    @Epic("Login Functionality")
    @Feature("Invalid Login Test")
    @Story("Verify that the application handles invalid login attempts correctly.")
    @Test
    public void testLoginInvalid() {
        // Test implementation here
        new LoginPage(driver).login(PropertyReader.getProperty("InvalidUsername"), PropertyReader.getProperty("InvalidPassword")).isLoginSuccessful("https://www.saucedemo.com/inventory.html");
    }


}
