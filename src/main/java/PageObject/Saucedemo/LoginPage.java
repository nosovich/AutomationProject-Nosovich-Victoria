package PageObject.Saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private By username = By.cssSelector("#user-name");
    private By password = By.cssSelector("#password");
    private By loginBtn = By.cssSelector("#login-button");
    private By errorText = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    //pattern fluent chain of invocations
    // - метод возвращает ссылку на объект класса (возвращает сам себя).
    // Используем для того, чтобы в тестах получать доступ к методам класса (продлжать вызывать методы на основе предыдущих результатов, делать запись в одну строку).

    public LoginPage openPage() {
        open("https://www.saucedemo.com/");
        return this;
    }

    public LoginPage verifyLoginPage() {
        isDisplayed(username, password, loginBtn);
        return this;
    }

    public LoginPage enterUsername(String username) {
        enter(this.username, username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enter(this.password, password);
        return this;
    }

    public LoginPage clickLogin() {
        click(this.loginBtn);
        return this;
    }

    public LoginPage loginToApplication(String username, String password) {
        enter(this.username, username);
        enter(this.password, password);
        click(this.loginBtn);
        return this;
    }

    public LoginPage checkErrorText(String expectedText) {
        Assert.assertEquals(getElementText(errorText), expectedText);
        return this;
    }

}
