package TestNG;

import Driver.DriverCreation;
import Driver.SelenideConfigurations;
import Properties.PropertyReader;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static Driver.DriverCreation.getDriver;


public class ListenerSelenide implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        byte[] file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshots(file);
    }

    @Override
    public void onStart(ITestContext context) {
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.setProperties(context.getSuite().getParameter("env") == null ? System.getProperties().getProperty("env") : context.getSuite().getParameter("env"));
        new SelenideConfigurations(propertyReader);
    }

    @Override
    public void onFinish(ITestContext context) {
        DriverCreation.quitDriver();
    }

    @Attachment(value = "Screenshots", type = "image/png")
    private byte[] saveScreenshots(byte[] s) {
        return s;
    }
}