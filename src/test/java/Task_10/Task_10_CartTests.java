package Task_10;

import Driver.BaseTest;
import Driver.Listener;
import PageObject.CartPage;
import PageObject.LoginPage;
import PageObject.Product.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(Listener.class) //Allure report
public class Task_10_CartTests extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        loginPage.openPage()
                .loginToApplication("standard_user", "secret_sauce");
    }

//    // Написать тесты на добавления/удаление товаров в корзину (invocationCount)
//    // Старая реализация с проверкой первого товара в списке
//    @Test(priority = 2, invocationCount = 3)
//    @Description("Adding and removing item to cart test")
//    @Link("https://www.saucedemo.com/cart")
//    public void addAndRemoveProdToCart_Test1() {
//        productPage.addBackpackToCart()
//                .navigateToCartPage();
//        cartPage.checkProduct()
//                .removeProduct()
//                .navigateToProductPage();
//    }

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
