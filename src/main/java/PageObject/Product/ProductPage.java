package PageObject.Product;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static Driver.DriverCreation.*;


public class ProductPage extends BasePage {
    private By title = By.cssSelector(".title");
    private By logo = By.cssSelector(".app_logo");
    private By filterBtn = By.tagName("select");
    private By addToCartBtn = By.cssSelector("[id|=add-to-cart]");
    private By backpackAddBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By cartIcon = By.className("shopping_cart_link");
    private By products = By.className("inventory_item_name");
    private By productPrices = By.className("inventory_item_price");
    private By productSortContainer = By.className("product_sort_container");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage verifyProductPage() {
        isDisplayed(title, logo, filterBtn);
        return this;
    }

    public void navigateToCartPage() {
        click(cartIcon);
    }

    public ProductPage addBackpackToCart() {
        click(backpackAddBtn);
        return this;
    }

    public ProductPage addProductsToCart()
    {
        clickAll(addToCartBtn);
        return this;
    }

    public List<String> getProductsList() {
        return getItemList(products);
    }

    public ProductPage clickProductSortContainer() {
        click(productSortContainer);
        return this;
    }

    public ProductPage clickFilterBtn() {
        click(filterBtn);
        return this;
    }

    public ProductPage chooseFilter(SortingEnum sort) {
        click(sort.getElement());
        return this;
    }

    public ProductPage sortProdNameFromAToZ() {
        List<String> actualData = getDriver().findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<String> expectedData = getDriver().findElements(products).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPage sortProdNameFromZToA() {
        List<String> actualData = getDriver().findElements(products).stream().map(data -> data.getText()).collect(Collectors.toList());
        List<String> expectedData = getDriver().findElements(products).stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        Collections.reverse(expectedData);
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPage sortProdPriceFromLowToHigh() {
        List<Double> actualData = getDriver().findElements(productPrices)
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> expectedData = getDriver().findElements(productPrices)
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble).sorted()
                .collect(Collectors.toList());
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPage sortProdPriceFromHighToLow() {
        List<Double> actualData = getDriver().findElements(productPrices)
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> expectedData = getDriver().findElements(productPrices)
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble).sorted()
                .collect(Collectors.toList());
        Collections.reverse(expectedData);
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPage verifySorting(SortingEnum sort) {
        clickFilterBtn();
        chooseFilter(sort);
        switch (sort) {
            case NameFromAToZ:
                sortProdNameFromAToZ();
                break;
            case NameFromZToA:
                sortProdNameFromZToA();
                break;
            case PriceFromLowToHigh:
                sortProdPriceFromLowToHigh();
                break;
            case PriceFromHighToLow:
                sortProdPriceFromHighToLow();
        }
        return this;
    }
}

