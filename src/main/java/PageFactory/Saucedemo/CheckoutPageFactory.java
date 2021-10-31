package PageFactory.Saucedemo;

import PageObject.BasePage;
import Patterns.Builder.SausedemoPerson_Builder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPageFactory extends BasePage {

    public CheckoutPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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
