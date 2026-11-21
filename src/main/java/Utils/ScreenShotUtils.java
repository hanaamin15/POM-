package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import java.io.File;

public class ScreenShotUtils {
    public static void takeScreenshot(WebDriver driver, String name) {
        try {
            File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("screenshots/" + name + ".png");
            FileUtils.copyFile(src, dest);
            AllureUtils.attachScreenshotsToAllure(name, dest.getPath());
        }
        catch (Exception e) {
            System.out.println("Error taking screenshot: " + e.getMessage());
        }
    }
}
