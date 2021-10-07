package PageObject;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.WebStorage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static Driver.DriverCreation.driver;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void enter(By element, CharSequence... charSequence) {
        driver().findElement(element).clear();
        driver().findElement(element).sendKeys(charSequence);
    }

    protected void click(By... elements) {
        for (By element : elements) {
            driver().findElement(element).click();
        }
    }

    protected void open(String url) {
        driver.get(url);
        WebStorage webStorage = (WebStorage) driver;
        webStorage.getLocalStorage().clear();
    }

    protected String getElementText(By element) {
        return driver().findElement(element).getText();
    }

    protected void isDisplayed(By... elements) {
        for(By element : elements) {
            Assert.assertTrue(driver().findElement(element).isDisplayed(), "Element :: " + element + " is not exist.");
        }
    }

    protected boolean notExist(By... elements) {
        boolean elementExist = true;
        for(By element : elements) {
            Assert.assertFalse(driver().findElement(element).isDisplayed());
            if(!elementExist) {
                elementExist = false;
            }
        }
        return elementExist;
    }

    protected void checkProdDescription(List<String> expectedDescription,By...elements) {
        List<String> prodDescription = new ArrayList<>();
        for(By element: elements) {
            prodDescription.add(getElementText(element));
        }
        Assert.assertEquals(expectedDescription, prodDescription);
    }
}
