package PageFactory.Herokuapp;

import PageObject.BasePage;
import Patterns.Builder.HerokuappUser_Builder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static Driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

public class LoginPage_Builder extends BasePage {
    @FindBy(tagName = "h2")
    WebElement title;

    @FindBy(id = "username")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(css = "[type='submit']")
    WebElement loginBtn;

    @FindBy(id = "flash")
    WebElement statusText;

    public LoginPage_Builder(WebDriver driver) {
        initElements(getDriver(), this);
    }

    public LoginPage_Builder login(HerokuappUser_Builder userBuilder) {
        userName.sendKeys(userBuilder.getUserName());
        password.sendKeys(userBuilder.getPassword());
        loginBtn.click();
        return this;
    }

    public LoginPage_Builder checkStatusText(HerokuappUser_Builder userBuilder) {
        Assert.assertTrue(statusText.getText().contains(userBuilder.getStatusText()));
        return this;
    }
}
