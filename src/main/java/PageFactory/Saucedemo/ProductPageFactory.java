package PageFactory.Saucedemo;

import PageObject.BasePage;
import PageObject.Saucedemo.Product.SortingEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPageFactory extends BasePage {

    @FindBy(css = ".title")
    WebElement title;

    @FindBy(css = ".app_logo")
    WebElement logo;

    @FindBy(tagName = "select")
    WebElement filterBtn;

    @FindBy(css = "[id|=add-to-cart]")
    WebElement addToCartBtn;

    @FindBy(css = ".shopping_cart_link")
    WebElement cartIcon;

    @FindBy(className = "inventory_item_name")
    WebElement product;

    @FindBys({
            @FindBy(className = "inventory_item_name")
    })
    private List<WebElement> productCollection;

    @FindBys({
            @FindBy(className = "inventory_item_price")
    })
    private List<WebElement> productPriceCollection;

    @FindBy(className = "product_sort_container")
    WebElement productSortContainer;

    public ProductPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductPageFactory verifyProductPage() {
        title.isDisplayed();
        logo.isDisplayed();
        filterBtn.isDisplayed();
        product.isDisplayed();
        return this;
    }

    public void navigateToCart() {
        cartIcon.click();
    }


    public ProductPageFactory addProductToCart() {
        addToCartBtn.click();
        return this;
    }

    public ProductPageFactory clickProductSortContainer() {
        productSortContainer.click();
        return this;
    }

    public ProductPageFactory chooseFilter(SortingEnum sort) {
        click(sort.getElement());
        return this;
    }

    public ProductPageFactory sortNameFromAToZ() {
        List<String> actualData = productCollection.stream().map(data -> data.getText()).collect(Collectors.toList());
        List<String> expectedData = productCollection.stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPageFactory sortNameFromZToA() {
        List<String> actualData = productCollection.stream().map(data -> data.getText()).collect(Collectors.toList());
        List<String> expectedData = productCollection.stream().map(data -> data.getText()).sorted().collect(Collectors.toList());
        Collections.reverse(expectedData);
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPageFactory sortPriceFromLowToHigh() {
        List<Double> actualData = productPriceCollection
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> expectedData = productPriceCollection
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble).sorted()
                .collect(Collectors.toList());
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPageFactory sortPriceFromHighToLow() {
        List<Double> actualData = productPriceCollection
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        List<Double> expectedData = productPriceCollection
                .stream().map(data -> data.getText())
                .map(data -> data.replace("$", ""))
                .map(data -> data.replace(",", "."))
                .map(Double::parseDouble).sorted()
                .collect(Collectors.toList());
        Collections.reverse(expectedData);
        Assert.assertEquals(actualData, expectedData);
        return this;
    }

    public ProductPageFactory verifySorting(SortingEnum sort) {
        filterBtn.click();
        chooseFilter(sort);
        switch (sort) {
            case NameFromAToZ:
                sortNameFromAToZ();
                break;
            case NameFromZToA:
                sortNameFromZToA();
                break;
            case PriceFromLowToHigh:
                sortPriceFromLowToHigh();
                break;
            case PriceFromHighToLow:
                sortPriceFromHighToLow();
        }
        return this;
    }
}

