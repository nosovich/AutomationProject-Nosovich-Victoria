package Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static Driver.DriverCreation.*;

public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = driver();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
