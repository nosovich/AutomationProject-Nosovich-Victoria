package PageObject;

import org.openqa.selenium.By;

public class CheskoutPage extends BasePage {
    private By firstName = By.id("first-name");
    private By lastName = By.id("last-name");
    private By zip = By.id("postal-code");
    private By continueBtn = By.id("continue");

    public CheskoutPage makePayment(String firstname, String lastname, String zipcode) {
        enter(this.firstName, firstname);
        enter(this.lastName, lastname);
        enter(this.zip, zipcode);
        click(continueBtn);
        return this;
    }


}
