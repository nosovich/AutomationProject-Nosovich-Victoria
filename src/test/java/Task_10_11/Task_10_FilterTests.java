package Task_10_11;

import Driver.BaseTest;
import TestNG.Listener;
import PageObject.Saucedemo.Product.SortingEnum;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.Product.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.*;

@Listeners(Listener.class) //Allure report
public class Task_10_FilterTests extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        loginPage.openPage()
                .loginToApplication("standard_user", "secret_sauce");
    }

    //  Написать тесты проверяющие сортировку товара. Список элементов сортировки опишите в Enum
    @Test
    @Description("Sorting of products test")
    @Link("https://www.saucedemo.com/inventory")
    public void filter_Test() {
        productPage.verifySorting(SortingEnum.NameFromAToZ)
                .verifySorting(SortingEnum.NameFromZToA)
                .verifySorting(SortingEnum.PriceFromLowToHigh)
                .verifySorting(SortingEnum.PriceFromHighToLow);
    }

}
