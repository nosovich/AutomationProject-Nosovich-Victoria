package PageObject;
import static Driver.DriverCreation.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CartPage extends BasePage {
    private By prodNameInCart = By.className("inventory_item_name");
    private By prodPriceInCart = By.className("inventory_item_price");
    private By removeBtn = By.xpath("//button[contains(text(),'Remove')]");
    private By checkoutBtn = By.id("checkout");


    public CartPage checkProduct() {
        checkProdDescription(expectedDescription,prodNameInCart,prodPriceInCart);
        return this;
    }

    public CartPage removeProduct() {
        click(removeBtn);
        notExist();
        return this;
    }

    public void navigateToCheckoutPage() {
        click(checkoutBtn);
    }

    List<String> expectedDescription = Arrays.asList("Sauce Labs Backpack", "$29.99");
}
