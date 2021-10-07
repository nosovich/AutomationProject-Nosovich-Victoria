package Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static Driver.DriverCreation.*;

public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public void setupDriver() {
        driver = getDriver();
    }

    @AfterMethod
    public void closeDriver() { quitDriver();}

}

