import Pages.HomePage;
import Utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest {
    WebDriver driver;
    JsonReader jsonReader;
    @BeforeMethod
    public void setUp() {
        jsonReader = new JsonReader("data");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
    }
    @Test
    public void testHomepage() {
        // Test implementation here
        new HomePage(driver).login(jsonReader.getJsonData("username"), jsonReader.getJsonData("password"))
                .isLoginSuccessful("https://www.saucedemo.com/inventory.html")
                .clickMenuList()
                .clickShoppingCart();
    }

}
