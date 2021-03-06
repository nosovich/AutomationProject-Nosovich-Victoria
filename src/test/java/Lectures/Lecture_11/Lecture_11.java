package Lectures.Lecture_11;

import Driver.BaseTest;
import PageObject.Saucedemo.BarMenu.BarMenuPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.Product.ProductPage;
import TestNG.ListenerSelenium;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import org.testng.annotations.*;

import static PageObject.Saucedemo.BarMenu.LinksEnum.Logout;

@Listeners(ListenerSelenium.class)
public class Lecture_11 extends BaseTest {

    LoginPage loginPage;
    ProductPage productPage;
    BarMenuPage barMenuPage;

    @BeforeClass
    public void preconditions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        barMenuPage = new BarMenuPage();
        loginPage.openPage();
    }

    @Description("Login to application")
    @Link("https://docs.google.com/presentation/d/1iR-GZb--qaiMzKzymCQzgBHY2Jwui_YuwJSG_C3edyk/edit")
    @Issue("Issue-007")
    @Parameters({"username", "password", "error"})
    @Test(priority = 1)
    public void loginToApplication_Test(@Optional("standard_user") String username, @Optional("secret_sauce") String password, @Optional("") String error) {
        loginPage.verifyLoginPage()
                .loginToApplication(username, password);
        if (error.isEmpty()) {
            productPage.verifyProductPage();
        } else {
            loginPage.checkErrorText(error);
        }
    }

    @Test(priority = 2)
    public void clickLink_Test() {
        barMenuPage.clickBarMenu()
                .clickLinks(Logout);
    }
}
