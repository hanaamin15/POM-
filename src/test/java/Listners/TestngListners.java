package Listners;

import Utils.AllureUtils;
import Utils.PropertyReader;
import Utils.ScreenShotUtils;
import drivers.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class TestngListners implements ITestListener, IInvokedMethodListener  , IExecutionListener {


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());


    }


    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());
        result.getThrowable().printStackTrace();


    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());
    }

    @Override
    public void onExecutionStart() {
        System.out.println("Test execution started");
        PropertyReader.loadProperties();
        AllureUtils.cleanAllureResults();
    }

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

        System.out.println("Before: " + method.getTestMethod().getMethodName());
    }




    @Override
    public void afterInvocation(
            IInvokedMethod method, ITestResult testResult) {

        if (method.isTestMethod()) {
            WebDriver driver = WebDriverFactory.getDriver();

            if (driver != null) {
                ScreenShotUtils.takeScreenshot(
                        driver,
                        method.getTestMethod().getMethodName()
                );
            } else {
                System.out.println("Screenshot skipped: WebDriver is null");
            }
        }
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("Test execution finished");
        AllureUtils.setAllureEnvironment();
    }

    }










