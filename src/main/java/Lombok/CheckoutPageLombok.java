package Lombok;

import PageObject.BasePage;
import Patterns.Builder.SausedemoPerson_Builder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class CheckoutPageLombok extends BasePage{

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

    public CheckoutPageLombok(WebDriver driver) {
        initElements(getDriver(), this);
    }

    public CheckoutPageLombok verifyCheckoutPage() {
        firstName.isDisplayed();
        lastName.isDisplayed();
        zipCode.isDisplayed();
        continueBtn.isDisplayed();
        cancelBtn.isDisplayed();
        return this;
    }

    public void makePayment(Lombok_Person person) {
        firstName.sendKeys(person.getFirstName());
        lastName.sendKeys(person.getLastName());
        zipCode.sendKeys(person.getZipCode());
        continueBtn.click();
    }

    public CheckoutPageLombok checkErrorText(String expectedText) {
        Assert.assertEquals(errorText.getText(), expectedText);
        return this;
    }
}
