package PageObject;

import Driver.DriverCreation;
import Properties.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    public BasePage(WebDriver driver) {
        this.driver = DriverCreation.getDriver();
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        properties = PropertyReader.getProperties();
    }

    protected void enter(By element, CharSequence... charSequence) {
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequence);
    }

    protected void click(By... elements) {
        for (By element : elements) {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            driver.findElement(element).click();
        }
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected void clickAll(By... elements) {
        for (By element : elements) {
            List<WebElement> buttons = driver.findElements(element);
            for (WebElement button : buttons) {
                button.click();
            }
        }
    }

    protected void open() {
        driver.get(properties.getProperty("url"));
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected String getElementText(By element) {
        return driver.findElement(element).getText();
    }

    protected List<String> getItemList(By elements) {
        List<String> itemList = driver.findElements(elements).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        return itemList;
    }

    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            System.out.println("Verify element :: " + element);
            Assert.assertFalse(driver.findElements(element).isEmpty(), "Element :: " + element + " is not exist.");
        }
    }

    protected boolean notExist(By... elements) {
        boolean elementExist = true;
        for (By element : elements) {
            Assert.assertFalse(driver.findElement(element).isDisplayed());
            if (!elementExist) {
                elementExist = false;
            }
        }
        return elementExist;
    }

    protected void checkProdDescription(List<String> expectedDescription, By... elements) {
        List<String> prodDescription = new ArrayList<>();
        for (By element : elements) {
            prodDescription.add(getElementText(element));
        }
        Assert.assertEquals(expectedDescription, prodDescription);
    }

    public void pause(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
