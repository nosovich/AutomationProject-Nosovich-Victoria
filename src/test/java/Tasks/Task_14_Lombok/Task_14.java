package Tasks.Task_14_Lombok;

import Driver.BaseTest;
import Lombok.CheckoutPageLombok;
import Lombok.LoginPageLombok;
import Lombok.Lombok_Person;
import Lombok.Lombok_UserVObject;
import PageFactory.Saucedemo.CartPageFactory;
import PageFactory.Saucedemo.ProductPageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_14 extends BaseTest {

    LoginPageLombok loginPageLombok;
    ProductPageFactory productPageFactory;
    CartPageFactory cartPageFactory;
    CheckoutPageLombok checkoutPageLombok;
    Lombok_Person person;
    Lombok_UserVObject user;


    @BeforeClass
    public void preconditions() {
        loginPageLombok = new LoginPageLombok(driver);
        productPageFactory = new ProductPageFactory(driver);
        cartPageFactory = new CartPageFactory(driver);
        checkoutPageLombok = new CheckoutPageLombok(driver);
        loginPageLombok.openPage();
    }

    @Test(priority = 1)
    public void standardUserlogin_Test() {
        user = new Lombok_UserVObject();
        user.setUsername("standard_user");
        user.setPassword("secret_sauce");
        loginPageLombok.verifyLoginPage()
                .loginToApplication(user);
        productPageFactory.verifyProductPage();
    }

    @Test(priority = 2)
    public void payment_Test() {
        person = Lombok_Person.builder()
                .firstName("Vasia")
                .lastName("Pupkin")
                .zipCode("12345")
                .build();
        productPageFactory.addProductToCart()
                .navigateToCart();
        cartPageFactory.verifyCartPage()
                .navigateToCheckoutPage();
        checkoutPageLombok.verifyCheckoutPage()
                .makePayment(person);
    }
}
