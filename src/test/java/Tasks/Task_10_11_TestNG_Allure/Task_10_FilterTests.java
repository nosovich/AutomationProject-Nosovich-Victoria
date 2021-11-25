package Tasks.Task_10_11_TestNG_Allure;

import Driver.BaseTest;
import PageObject.Saucedemo.Product.SortingEnum;
import PageObject.Saucedemo.LoginPage;
import PageObject.Saucedemo.Product.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.*;

public class Task_10_FilterTests extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage();
        productPage = new ProductPage();
        loginPage.openPage()
                .loginToApplicationStandard();
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
