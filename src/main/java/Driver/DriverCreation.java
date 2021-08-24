package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverCreation {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=ru"); // Так как польлзуюсь google из Польши меняю язык на русский в Настройках google.
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;
    }
}
