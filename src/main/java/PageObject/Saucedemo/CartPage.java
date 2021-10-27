package PageObject.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class CartPage extends BasePage {
    private By prodNameInCart = By.className("inventory_item_name");
    private By prodPriceInCart = By.className("inventory_item_price");
    private By removeBtn = By.xpath("//button[contains(text(),'Remove')]");
    private By checkoutBtn = By.id("checkout");
    private By coontinueShoppingBtn = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }


    public CartPage checkProduct() {
        checkProdDescription(expectedDescription, prodNameInCart, prodPriceInCart);
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

    public List<String> getProductsList() {
        return getItemList(prodNameInCart);
    }

    List<String> expectedDescription = Arrays.asList("Sauce Labs Backpack", "$29.99");


    public void navigateToProductPage() {
        click(coontinueShoppingBtn);
    }
}

