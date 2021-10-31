package PageFactory.Herokuapp;

import PageObject.BasePage;
import Patterns.Builder.HerokuappUser_Builder;
import Patterns.ValueObject.HerokuappUser_VObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage_Builder login (HerokuappUser_Builder userBuilder) {
        userName.sendKeys(userBuilder.getUserName());
        password.sendKeys(userBuilder.getPassword());
        loginBtn.click();
        return this;
    }

    public LoginPage_Builder checkStatusText(HerokuappUser_Builder userBuilder) {
        Assert.assertEquals(statusText.getText(), userBuilder.getStatusText());
        return this;
    }
}
