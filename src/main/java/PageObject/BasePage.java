package PageObject;

import PageObject.Product.ProductPage;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Driver.DriverCreation.getDriver;

public class BasePage {

    protected WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected void enter(By element, CharSequence... charSequence) {
        getDriver().findElement(element).clear();
        getDriver().findElement(element).sendKeys(charSequence);
    }

    protected void click(By... elements) {
        for (By element : elements) {
            getDriver().findElement(element).click();
        }
    }

    protected void clickAll(By... elements) {
        for (By element : elements) {
            List<WebElement> buttons = getDriver().findElements(element);
            for (WebElement button: buttons) {
                button.click();
            }
        }
    }

    protected void open(String url) {
        getDriver().get(url);
//        WebStorage webStorage = (WebStorage) getDriver();
//        webStorage.getLocalStorage().clear();
    }

    protected String getElementText(By element) {
        return getDriver().findElement(element).getText();
    }

    protected List<String> getItemList(By elements) {
        List<String> itemList = getDriver().findElements(elements).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        return itemList;
    }

    protected void isDisplayed(By... elements) {
        for(By element : elements) {
            Assert.assertTrue(getDriver().findElement(element).isDisplayed(), "Element :: " + element + " is not exist.");
        }
    }

    protected boolean notExist(By... elements) {
        boolean elementExist = true;
        for(By element : elements) {
            Assert.assertFalse(getDriver().findElement(element).isDisplayed());
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
