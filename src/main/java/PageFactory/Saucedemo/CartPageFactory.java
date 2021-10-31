package PageFactory.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class CartPageFactory extends BasePage {

    @FindBy(className = "inventory_item_name")
    WebElement prodInCart;

    @FindBy(className = "inventory_item_price")
    WebElement prodPriceInCart;

    @FindBy(xpath = "//button[contains(text(),'Remove')]")
    WebElement removeBtn;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    @FindBy(id = "continue-shopping")
    WebElement coontinueShoppingBtn;

    private By prodNameInCart = By.className("inventory_item_name");

    public CartPageFactory verifyCartPage() {
        coontinueShoppingBtn.isDisplayed();
        checkoutBtn.isDisplayed();
        return this;
    }

    public CartPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CartPageFactory removeProduct() {
        removeBtn.click();
        notExist();
        return this;
    }

    public CartPageFactory verifyProductInCart() {
        Assert.assertTrue(prodInCart.isDisplayed());
        return this;
    }

    public void navigateToCheckoutPage() {
        checkoutBtn.click();
    }

    public List<String> getProductsList() {
        return getItemList(prodNameInCart);
    }

    public void navigateToProductPage() {
        coontinueShoppingBtn.click();
    }
}


