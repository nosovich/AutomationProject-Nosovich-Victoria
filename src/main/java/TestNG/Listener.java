package TestNG;

import Driver.DriverCreation;
import Properties.PropertyReader;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static Driver.DriverCreation.*;


public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        byte[] file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshots(file);
        //Скриншот fail тестов
    }

    @Override
    public void onStart(ITestContext context) {
        PropertyReader propertyReader = new PropertyReader();
        propertyReader.setProperties(context.getSuite().getParameter("env") == null ? System.getProperties().getProperty("env") : context.getSuite().getParameter("env"));
        Path path = Paths.get("allure-results");
        try {
            Files.walk(path)
                    .sorted(Comparator.reverseOrder())
                    .map(Path::toFile)
                    .forEach(File::delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
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