package PageObject.Herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import static PageObject.Herokuapp.HomePageLinksEnum.*;

public class ContextMenuObject extends BasePage {

    private By title = By.tagName("h3");
    private By hotSpot = By.id("hot-spot");

    public ContextMenuObject verifyPageTitle() {
        Assert.assertEquals(getElementText(title), CONTEXT_MENU.getLinkText());
        return this;
    }

    public ContextMenuObject verifyAlertText() {
        actions.contextClick(driver.findElement(hotSpot)).perform();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), properties.getProperty("verifyAlertText"));
        alert.accept();
        return this;
    }
}
