package PageFactory.Saucedemo;

import PageObject.BasePage;
import Patterns.Builder.SausedemoPerson_Builder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPageFactory extends BasePage {

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement zipCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "cancel")
    WebElement cancelBtn;

    @FindBy(css = "[data-test=error]")
    WebElement errorText;

    public CheckoutPageFactory(WebDriver driver) {
        initElements(getDriver(), this);
    }

    public CheckoutPageFactory verifyCheckoutPage() {
        firstName.isDisplayed();
        lastName.isDisplayed();
        zipCode.isDisplayed();
        continueBtn.isDisplayed();
        cancelBtn.isDisplayed();
        return this;
    }

    public void makePayment(SausedemoPerson_Builder personBuilder) {
        firstName.sendKeys(personBuilder.getFirstName());
        lastName.sendKeys(personBuilder.getLastName());
        zipCode.sendKeys(personBuilder.getZipCode());
        continueBtn.click();
    }

    public CheckoutPageFactory checkErrorText(String expectedText) {
        Assert.assertEquals(errorText.getText(), expectedText);
        return this;
    }
}
