package PageFactory.Saucedemo;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

import static Driver.DriverCreation.getDriver;
import static org.openqa.selenium.support.PageFactory.initElements;

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
    WebElement continueShoppingBtn;

    private By prodNameInCart = By.className("inventory_item_name");

    public CartPageFactory(WebDriver driver) {
        initElements(getDriver(), this);
    }

    public CartPageFactory verifyCartPage() {
        continueShoppingBtn.isDisplayed();
        checkoutBtn.isDisplayed();
        return this;
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
        continueShoppingBtn.click();
    }
}


