package Task_10;

import Driver.BaseTest;
import Driver.Listener;
import PageObject.*;
import PageObject.Product.ProductPage;
import org.testng.annotations.*;

@Listeners(Listener.class)
public class Lecture_10_3 extends BaseTest {
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    CheskoutPage cheskoutPage;

    @BeforeMethod
    public void preconditions() {
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        cheskoutPage = new CheskoutPage(driver);
        loginPage.openPage();
    }

    //  Аннотация Optional подставляет дефолтное значение в случае если данные не будут найдены в xml
    //  Аннотация Parameters дает возможность считать переменные из .xml файла
    //  RetryAnalyzer дает несколько попыток на выполнение теста прежде чем зафейлиться (логика прописана в классе Retry)


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


