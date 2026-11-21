package Utils;
import com.google.common.collect.ImmutableMap;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;

import java.io.File;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static java.nio.file.Files.newInputStream;

public class AllureUtils {
    public static void cleanAllureResults() {
        FileUtils.deleteQuietly(new File("allure-results"));
    }
    public static void attachScreenshotsToAllure(String screenName, String screenshotPath) {

        try {
            File screenshot = new File(screenshotPath);
            Allure.attachment(screenName, newInputStream(screenshot.toPath()));
        }
        catch (Exception e) {
            System.out.println("Error attaching screenshot to Allure: " + e.getMessage());
        }

    }

    public static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("OS", PropertyReader.getProperty("os.name"))
                        .put("JDK Version",PropertyReader.getProperty("java.runtime.version"))
                        .put("Base URL", "https://www.saucedemo.com/")
                        .build(),PropertyReader.getProperty("user.dir")+File.separator+"/allure-results/"+File.separator);



    }

}


