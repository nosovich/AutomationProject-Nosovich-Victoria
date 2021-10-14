package Task_10;

import Driver.BaseTest;
import Driver.Listener;
import PageObject.CartPage;
import PageObject.LoginPage;
import PageObject.Product.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class) //Allure report
public class Task_10_CartTests extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        cartPage = new CartPage();
        loginPage.openPage()
                .loginToApplication("standard_user", "secret_sauce");
    }

    //  Написать тесты на добавления/удаление товаров в корзину (invocationCount)
    @Test(invocationCount = 3)
    @Description("Adding and removing items to cart test")
    @Link("https://www.saucedemo.com/cart")
    public void addAndRemoveProdToCart_Test() {
        productPage.addProductToCart()
                .navigateToCartPage();
        cartPage.checkProduct()
                .removeProduct()
                .navigateToProductPage();
    }

}
