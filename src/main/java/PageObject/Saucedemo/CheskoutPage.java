package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheskoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zip = By.id("postal-code");
    private By continueBtn = By.id("continue");

    public CheskoutPage(WebDriver driver) {
        super(driver);
    }


    public CheskoutPage makePayment(String firstname, String lastname, String zipcode) {
        enter(this.firstName, firstname);
        enter(this.lastName, lastname);
        enter(this.zip, zipcode);
        click(continueBtn);
        return this;
    }


}
