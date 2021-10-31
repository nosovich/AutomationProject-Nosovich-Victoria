package PageFactory.Saucedemo;

import PageObject.BasePage;
import PageObject.Saucedemo.LoginPage;
import Patterns.ValueObject.SausedemoUser_VObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageFactory extends BasePage {

//   Инициализация элементов через аннотации @FindBy (поиск элемента по локатору), @FindBys (поиск элементов по локаторам с условием И, возвращает коллекцию),
//   @FindAll (поиск элементов по условию ИЛИ, возвращает коллекцию).
//   Сама инициализация по факту происходит после вызова метода PageFactory.initElements(driver, this);
//   Используется ТОЛЬКО для страниц со статичным контентом (если есть динамически появляющиеся элементы после каких-то действий, то можно использовать смесь с классическим Page Object).
//   Page Factory решает проблему: Повторяющиеся записи по поиску элементов внутри Page Objects.
//   В Page Object мы описываем локаторы. В Page Factory - вебэлементы с возможностью доступа ко всем методам класса WebElement (без driver.findElement(By локатор)).
//   Но тут важно в конструктор пейджи передать driver (через метод PageFactory.initElements(driver, this) !

    @FindBy(css = "#user-name")
    WebElement userName;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#login-button")
    WebElement loginBtn;

    @FindBy(css = "[data-test=error]")
    WebElement errorText;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPageFactory openPage() {
        open();
        return this;
    }

    public LoginPageFactory verifyLoginPage() {
        userName.isDisplayed();
        password.isDisplayed();
        loginBtn.isDisplayed();
        return this;
    }

    public LoginPageFactory enterUsername(SausedemoUser_VObject user) {
        this.userName.sendKeys(user.getUsername());
        return this;
    }

    public LoginPageFactory enterPassword(SausedemoUser_VObject user) {
        this.password.sendKeys(user.getPassword());
        return this;
    }

    public LoginPageFactory loginToApplication(SausedemoUser_VObject user) {
        this.userName.sendKeys(user.getUsername());
        this.password.sendKeys(user.getPassword());
        this.loginBtn.click();
        return this;
    }

    public LoginPageFactory checkErrorText(SausedemoUser_VObject user) {
        Assert.assertEquals(this.errorText.getText(), user.getErrorText());
        return this;
    }
}
