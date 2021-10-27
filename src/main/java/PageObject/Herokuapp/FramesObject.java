package PageObject.Herokuapp;

import PageObject.BasePage;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;

public class FramesObject extends BasePage {

    private By title = By.tagName("h3");
    private By iframeId = By.id("mce_0_ifr");
    private By iframeText = By.cssSelector("#tinymce > p");

    private By getFrameLink(String frame) {
        return By.linkText(frame);
    }

    public FramesObject(WebDriver driver) {
        super(driver);
    }

    public FramesObject verifyPageTitle(String title) {
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }

    public FramesObject clickFrameLink(String framelink) {
        click(getFrameLink(framelink));
        return this;
    }

    public FramesObject verifyFrameText(String expectedText) {
        driver.switchTo().frame(driver.findElement(iframeId));
        Assert.assertEquals(getElementText(iframeText), expectedText);
        return this;
    }
}
