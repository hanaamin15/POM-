import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitBot {

    private WebDriver driver;

    // Constructor to initialize the WebDriver
    public WaitBot(WebDriver driver) {
        this.driver = driver;
    }

    public FluentWait<WebDriver> wait(int timeout) {
        return new FluentWait<>(driver)
                .withTimeout(java.time.Duration.ofSeconds(10))
                .pollingEvery(java.time.Duration.ofMillis(500))
                .ignoring(org.openqa.selenium.NoSuchElementException.class);
    }
}
