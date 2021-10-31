package Lombok;

import PageObject.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPageLombok extends BasePage {

    @FindBy(css = "#user-name")
    WebElement userName;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#login-button")
    WebElement loginBtn;

    @FindBy(css = "[data-test=error]")
    WebElement errorText;

    public LoginPageLombok(WebDriver driver) {
        initElements(getDriver(), this);
    }

    public LoginPageLombok openPage() {
        open();
        return this;
    }

    public LoginPageLombok verifyLoginPage() {
        userName.isDisplayed();
        password.isDisplayed();
        loginBtn.isDisplayed();
        return this;
    }

    public LoginPageLombok enterUsername(Lombok_UserVObject user) {
        this.userName.sendKeys(user.getUsername());
        return this;
    }

    public LoginPageLombok enterPassword(Lombok_UserVObject user) {
        this.password.sendKeys(user.getPassword());
        return this;
    }

    public LoginPageLombok loginToApplication(Lombok_UserVObject user) {
        this.userName.sendKeys(user.getUsername());
        this.password.sendKeys(user.getPassword());
        this.loginBtn.click();
        return this;
    }

    public LoginPageLombok checkErrorText(Lombok_UserVObject user) {
        Assert.assertEquals(this.errorText.getText(), user.getErrorText());
        return this;
    }
}
