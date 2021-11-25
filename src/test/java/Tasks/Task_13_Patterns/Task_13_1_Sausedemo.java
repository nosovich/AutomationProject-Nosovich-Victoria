package Tasks.Task_13_Patterns;

import Driver.BaseTest;
import PageFactory.Saucedemo.CartPageFactory;
import PageFactory.Saucedemo.CheckoutPageFactory;
import PageFactory.Saucedemo.LoginPageFactory;
import PageFactory.Saucedemo.ProductPageFactory;
import Patterns.Builder.SausedemoPerson_Builder;
import Patterns.ValueObject.SausedemoUser_VObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Task_13_1_Sausedemo extends BaseTest {

    LoginPageFactory loginPageFactory;
    ProductPageFactory productPageFactory;
    CartPageFactory cartPageFactory;
    CheckoutPageFactory checkoutPageFactory;
    SausedemoUser_VObject user;
    SausedemoPerson_Builder person;


    @BeforeClass
    public void preconditions() {
        loginPageFactory = new LoginPageFactory(driver);
        productPageFactory = new ProductPageFactory(driver);
        cartPageFactory = new CartPageFactory(driver);
        checkoutPageFactory = new CheckoutPageFactory(driver);
        loginPageFactory.openPage();
    }

    @Test(priority = 1)
    public void standardUserlogin_Test() {
        user = new SausedemoUser_VObject();
        user.setUsername("standard_user");
        user.setPassword("secret_sauce");
        loginPageFactory.verifyLoginPage()
                .loginToApplication(user);
        productPageFactory.verifyProductPage();
    }

    @Test(priority = 2)
    public void payment_Test() {
        person = new SausedemoPerson_Builder.Builder()
                .withFirstName("Vika")
                .withLastName("Nos")
                .withZipCode("11111")
                .built();
        productPageFactory.addProductToCart()
                .navigateToCart();
        cartPageFactory.verifyCartPage()
                .navigateToCheckoutPage();
        checkoutPageFactory.verifyCheckoutPage()
                .makePayment(person);
    }
}
