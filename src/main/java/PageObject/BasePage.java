package PageObject;

import Driver.DriverCreation;
import Properties.PropertyReader;
import lombok.extern.log4j.Log4j2;
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

@Log4j2
public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;
    protected Properties properties;

    protected BasePage() {
        this.driver = DriverCreation.getDriver();
        wait = new WebDriverWait(driver, 5);
        actions = new Actions(driver);
        properties = PropertyReader.getProperties();
    }

    protected void enter(By element, CharSequence... charSequence) {
        log.info("Enter in element :: " + element);
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(charSequence);
    }

    protected void click(By... elements) {
        for (By element : elements) {
            log.info("Click on element :: " + element);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            driver.findElement(element).click();
        }
    }

    protected void click(WebElement element) {
        log.info("Click on element :: " + element);
        element.click();
    }

    protected void clickAll(By... elements) {
        for (By element : elements) {
            log.info("Click on element :: " + element);
            List<WebElement> buttons = driver.findElements(element);
            for (WebElement button : buttons) {
                button.click();
            }
        }
    }

    protected void open() {
        open(properties.getProperty("url"));
    }

    protected void open(String url) {
        driver.get(url);
    }

    protected String getElementText(By element) {
        log.info("Get text from element :: " + element);
        return driver.findElement(element).getText();
    }

    protected List<String> getItemList(By elements) {
        log.info("Get text from collection of elements :: " + elements);
        List<String> itemList = driver.findElements(elements).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        return itemList;
    }

    protected void isDisplayed(By... elements) {
        for (By element : elements) {
            log.info("Verify that element :: " + element + " is displayed");
            Assert.assertFalse(driver.findElements(element).isEmpty(), "Element :: " + element + " is not exist.");
        }
    }

    protected boolean notExist(By... elements) {
        boolean elementExist = true;
        for (By element : elements) {
            log.info("Verify that element :: " + element + " is not displayed");
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
            log.info("Verify the discription of element :: " + element);
            prodDescription.add(getElementText(element));
        }
        Assert.assertEquals(expectedDescription, prodDescription);
    }

    public void pause(Integer seconds) {
        try {
            long time = seconds * 1000;
            log.info("Sleep :: " + time);
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
