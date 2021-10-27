package Driver;

import Properties.PropertyReader;
import TestNG.Listener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static Driver.DriverCreation.*;

@Listeners(Listener.class)
public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void setupDriver(ITestContext context) {
        driver = getDriver();
    }

//    @AfterTest
//    public void closeDriver() { quitDriver();}
}

