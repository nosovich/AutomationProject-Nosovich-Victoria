package PageObject.Herokuapp;

import PageObject.Saucedemo.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static PageObject.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControlsObject extends BasePage {

    private By title = By.tagName("h4");
    private By checkbox = By.cssSelector("#checkbox-example>div");
    private By input = By.cssSelector("#input-example>input");
    private By enableBtn = By.cssSelector("#input-example>button");
    private By removeBtn = By.cssSelector("#checkbox-example>button");
    private By enableText = By.cssSelector("#input-example>p");
    private By textBack = By.cssSelector("#checkbox-example>p");

    public DynamicControlsObject(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsObject verifyPageTitle() {
        Assert.assertEquals(getElementText(title), DYNAMIC_CONTROLS.getLinkText());
        return this;
    }

    public DynamicControlsObject clickRemoveBtn() {
        click(removeBtn);
        return this;
    }

    public DynamicControlsObject clickEnableBtn() {
        click(enableBtn);
        return this;
    }

    public DynamicControlsObject verifyRemoveText(String text) {
        wait.until(ExpectedConditions.textToBe(textBack, text));
        return this;
    }

    public DynamicControlsObject verifyCheckboxIsNotExist() {
        notExist(checkbox);
        return this;
    }

    public DynamicControlsObject verifyInputDisabled() {
        isDisplayed(input);
        wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(input)));
        return this;
    }

    public DynamicControlsObject verifyEnableText(String text) {
        wait.until(ExpectedConditions.textToBe(enableText, text));
        return this;
    }

    public DynamicControlsObject verifyInputEnabled() {
        isDisplayed(input);
        wait.until(ExpectedConditions.elementToBeClickable(input));
        return this;
    }

}
