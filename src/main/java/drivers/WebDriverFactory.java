
package drivers;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    private static WebDriver getDriverFactory(String browser) {
        Browser browserType = Browser.valueOf(browser.toUpperCase());
        AbstractDriver driverFactory = browserType.getDriverFactory();

        return driverFactory.createDriver();
    }

    public static WebDriver initDriver(String browser) {
        if (driver != null) {
            driver.quit();
        }

        driver = getDriverFactory(browser);
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
