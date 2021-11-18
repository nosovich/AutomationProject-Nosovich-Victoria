package Tasks.Task_10_11;

import Driver.BaseTest;
import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.Product.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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
                .loginToApplicationStandard();
    }

    // Написать тесты на добавления/удаление товаров в корзину (invocationCount)
    // Новая реализация, сравниваем списки добавленных товаров со страницы Продуктов, с теми, что попали в Корзину

    @Test(invocationCount = 3)
    @Description("Adding and removing items to cart test")
    @Link("https://www.saucedemo.com/cart")
    public void addAndRemoveProdToCart_Test() {
        productPage.addProductsToCart();
        List<String> productPageList = productPage.getProductsList();
        productPage.navigateToCartPage();
        List<String> cartPageList = cartPage.getProductsList();
        Assert.assertEquals(productPageList, cartPageList);
        cartPage.removeProduct()
                .navigateToProductPage();
    }
}
