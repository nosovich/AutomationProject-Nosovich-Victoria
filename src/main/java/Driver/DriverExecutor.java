package Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static Driver.DriverCreation.*;

public class DriverExecutor {

    public static WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = getDriver();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }
}
