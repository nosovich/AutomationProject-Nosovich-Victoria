package Driver;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import static Driver.DriverCreation.*;



public class Listener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        byte[] file = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        saveScreenshot(file);
    }

    @Attachment(value = "Screenshots", type = "image/png")
    private byte[] saveScreenshot(byte[] s) {
        return s;
    }
}


