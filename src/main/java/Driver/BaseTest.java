package Driver;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static Driver.DriverCreation.*;

@Listeners(Listener.class)
public class BaseTest {

    public static WebDriver driver;

    @BeforeTest
    public void setupDriver() {
        driver = getDriver();
    }

//    @AfterTest
//    public void closeDriver() { quitDriver();}
}

