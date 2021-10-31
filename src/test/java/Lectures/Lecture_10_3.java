package Lectures;

import Driver.BaseTest;
import TestNG.Listener;
import PageObject.Saucedemo.Product.ProductPage;
import PageObject.Saucedemo.CartPage;
import PageObject.Saucedemo.CheckoutPage;
import PageObject.Saucedemo.LoginPage;
import org.testng.annotations.*;

@Listeners(Listener.class)
public class Lecture_10_3 extends BaseTest {
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

    //  Аннотация Optional подставляет дефолтное значение в случае если данные не будут найдены в xml
    //  Аннотация Parameters дает возможность считать переменные из .xml файла
    //  RetryAnalyzer дает несколько попыток на выполнение теста прежде чем зафейлиться (логика прописана в классе Retry)

    // Если в тесте мы искользуем Data Provider и хотим запустить его в параллели (создастя столько потоков, сколько входных данных в провайдере),
    // то непосредственно в самом тесте необходимо создать новый драйвер и все переменные экземмпляра классов наших Pages.
    // Иначе драйвер создастя только один раз (в BeforeMethod).


//  Специально зафейленный тест (сейчас enabled)
//    @Parameters({"username", "password"})
//    @Test(priority = 2, retryAnalyzer = Retry.class, enabled = false)
//    public void loginToApplicationLocked_Test(@Optional("standard_user") String username, @Optional("secret_sauce") String password) {
//        loginPage.verifyLoginPage()
//                .loginToApplication(username, password);
//        productPage.verifyProductPage();
//    }

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
}