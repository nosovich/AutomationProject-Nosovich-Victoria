package Task_10;

import Driver.BaseTest;
import Driver.Listener;
import PageObject.LoginPage;
import PageObject.Product.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Link;
import org.testng.annotations.*;

@Listeners(Listener.class) //Allure report
public class Task_10_LoginTests extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        loginPage.openPage();
    }

    //    Написать тесты на Логин страницу - 1 позитивный и 5 негативных с использованием с @DataProvider
    @DataProvider(name = "user data")
    public Object[][] data() {
        return new Object[][]{
                {"standard_user", "secret_sauce", ""}, //positive test
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"12345", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"standard_user", "12345", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "user data")
    @Description("Login to application test")
    @Link("https://www.saucedemo.com/")
    public void loginToApplication_Test(String username, String password, String error) {
        loginPage.verifyLoginPage()
                .loginToApplication(username, password);
        if (error.isEmpty()) {
            productPage.verifyProductPage();
        } else {
            loginPage.checkErrorText(error);
        }
    }
}
