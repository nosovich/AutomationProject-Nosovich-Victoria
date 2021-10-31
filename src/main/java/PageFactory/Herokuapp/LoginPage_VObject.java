package PageFactory.Herokuapp;

import PageObject.BasePage;
import Patterns.ValueObject.HerokuappUser_VObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage_VObject extends BasePage {

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

    public LoginPage_VObject(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage_VObject login(HerokuappUser_VObject herokuappUser) {
        userName.sendKeys(herokuappUser.getUserName());
        password.sendKeys(herokuappUser.getPassword());
        loginBtn.click();
        return this;
    }

    public LoginPage_VObject checkStatusText(HerokuappUser_VObject user) {
        Assert.assertEquals(statusText.getText(), user.getStatusText());
        return this;
    }
}
