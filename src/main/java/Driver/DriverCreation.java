package Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverCreation {

//  Класс Threadlocal используем для избежания переплетения потоков.
//  Переменная типа Tthreadlocal хранит переменные, которые должны быть доступны для текущего запущенного потока.
//  На примере драйвера нам надо, чтобы создавался новый дравер в каждом новом потоке.

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

//   Singleton pattern
    public static WebDriver getDriver() {
        if (driver.get() == null) {
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.manage().window().maximize();
            driver.set(webDriver);
        }
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().close();
            driver.get().quit();
            driver.remove();
        }
    }
}
