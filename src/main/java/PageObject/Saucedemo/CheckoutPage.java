package PageObject.Saucedemo;

import PageFactory.Saucedemo.CheckoutPageFactory;
import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CheckoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zip = By.id("postal-code");
    private By continueBtn = By.id("continue");
    private By errorText = By.cssSelector("[data-test=error]");

    public void makePayment(String firstname, String lastname, String zipcode) {
        enter(this.firstName, firstname);
        enter(this.lastName, lastname);
        enter(this.zip, zipcode);
        click(continueBtn);
    }

    public CheckoutPage checkErrorText(String expectedText) {
        Assert.assertEquals(getElementText(errorText), expectedText);
        return this;
    }

}
