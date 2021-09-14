package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductPage extends BasePage {
    private By title = By.cssSelector(".title");
    private By logo = By.cssSelector(".app_logo");
    private By filter = By.tagName("select");
    private By backpackAddBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");

    public ProductPage verifyProductPage() {
        isDisplayed(title, logo, filter);
        return this;
    }

    public void navigateToCartPage() {
        click(cartIcon);
    }

    public ProductPage addProductToCart() {
        click(backpackAddBtn);
        return this;
    }
}
