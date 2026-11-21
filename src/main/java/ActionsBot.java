import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionsBot {
   private WebDriver driver;
   private WaitBot waitBot;

    public ActionsBot(WebDriver driver) {
        this.driver = driver;
        this.waitBot = new WaitBot(driver);
    }

    // Method to perform click action on an element
    public ActionsBot click(By locator) {
        waitBot.wait(10).until(driver -> driver.findElement(locator)).click();
        return this;
    }
    // Method to perform sendKeys action on an element
    public ActionsBot sendKeys(By locator, String text) {
        waitBot.wait(10).until(driver -> driver.findElement(locator).isDisplayed());
        driver.findElement(locator).sendKeys(text);
        return this;
    }


}
