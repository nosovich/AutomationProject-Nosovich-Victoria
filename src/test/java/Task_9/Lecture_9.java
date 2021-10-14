package Task_9;

import Driver.BaseTest;
import PageObject.CartPage;
import PageObject.CheskoutPage;
import PageObject.LoginPage;
import PageObject.Product.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lecture_9 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheskoutPage cheskoutPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        cheskoutPage = new CheskoutPage();
        loginPage.openPage();
    }

    @Test(priority = 1)
    public void loginToApplicationStandart_Test() {
        loginPage.verifyLoginPage()
                .loginToApplication("standard_user", "secret_sauce");
        productPage.verifyProductPage();

    }

    @Test(priority = 2)
    public void loginToApplicationLocked_Test() {
        loginPage.verifyLoginPage()
                .loginToApplication("locked_out_user", "secret_sauce")
                .checkErrorText("Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(priority = 3)
    public void loginToApplicationProblem_Test() {
        loginPage.verifyLoginPage()
                .loginToApplication("problem_user", "secret_sauce");
        productPage.verifyProductPage();
    }

    @Test(priority = 4)
    public void addProductToCart_Test() {
        loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.addProductToCart()
                .navigateToCartPage();
        cartPage.checkProduct();
    }

    @Test(priority = 5)
    public void removeProduct_Test() {
        loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.addProductToCart()
                .navigateToCartPage();
        cartPage.removeProduct();
    }

    @Test(priority = 6)
    public void payment_Test() {
        loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.addProductToCart()
                .navigateToCartPage();
        cartPage.navigateToCheckoutPage();
        cheskoutPage.makePayment("Vika", "Nos", "12345");
    }
}
