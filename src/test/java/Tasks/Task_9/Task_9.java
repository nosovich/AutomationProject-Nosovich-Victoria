package Tasks.Task_9;

import Driver.BaseTest;
import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.CheckoutPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.Product.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task_9 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
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
    public void addAndRemoveProductToCart_Test() {
        loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.addBackpackToCart()
                .navigateToCartPage();
        cartPage.checkProduct()
                .removeProduct();

    }

    @Test(priority = 5)
    public void payment_Test() {
        loginPage.loginToApplication("standard_user", "secret_sauce");
        productPage.addBackpackToCart()
                .navigateToCartPage();
        cartPage.navigateToCheckoutPage();
        checkoutPage.makePayment("Vika", "Nos", "12345");
    }
}
