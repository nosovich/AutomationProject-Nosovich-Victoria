package Lecture_7;

import Driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Task_6 extends BaseTest {

    @BeforeMethod
    public void preconditions() {
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void loginErrorTest() {
        driver.findElement(By.id("user-name")).clear(); // id
        driver.findElement(By.name("password")).clear(); // name
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click(); // css.class
        Assert.assertTrue(driver.findElement(By.tagName("h3")).isDisplayed()); // tagname
        Assert.assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Epic sadface: Username is required"); // css(tagname)
    }

    @Test
    public void Test1() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user", Keys.ENTER); // id
        driver.findElement(By.name("password")).sendKeys("secret_sauce", Keys.ENTER); // name
        driver.findElement(By.cssSelector(".submit-button.btn_action")).click(); // css.class
        Assert.assertTrue(driver.findElement(By.className("app_logo")).isDisplayed()); // classname
        Assert.assertTrue(driver.findElement(By.cssSelector("[class|=title]")).isDisplayed()); // [attribute|=value]
        Assert.assertTrue(driver.findElement(By.xpath("//button/ancestor::div[@class='bm-burger-button']")).isDisplayed()); //	ancestor
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='header_secondary_container']//descendant::span)[2]")).isDisplayed()); //	descendant
        Assert.assertTrue(driver.findElement(By.xpath("(//div[@class='header_label']//following::a)[1]")).isDisplayed()); // following
        Assert.assertTrue(driver.findElement(By.cssSelector(".btn.btn_primary")).isDisplayed()); // .class1.class2
        Assert.assertTrue(driver.findElement(By.cssSelector("[class*=sort_]")).isDisplayed()); // [attribute*=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class$=_name]")).isDisplayed()); // [attribute$=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class=inventory_item_desc]")).isDisplayed()); // [attribute=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[class~=inventory_item_img]")).isDisplayed()); // [attribute~=value]
        Assert.assertTrue(driver.findElement(By.cssSelector("[href^=\"https://twitter\"]")).isDisplayed()); // [attribute^=value]
        Assert.assertTrue(driver.findElement(By.linkText("Facebook")).isDisplayed()); //	linktext
        Assert.assertTrue(driver.findElement(By.partialLinkText("LinkedIn")).isDisplayed()); //	partiallinktext
        Select select = new Select(driver.findElement(By.cssSelector(".select_container .product_sort_container"))); // .class1 .class2
        select.selectByIndex(2);
        List<WebElement> cartAdd = driver.findElements(By.xpath("//*[@class='pricebar']//parent::div//button")); // parent
        cartAdd.forEach(element -> element.click());
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='header_secondary_container']//preceding::span")).getText(), "6"); // preceding
        List<WebElement> cartClean = driver.findElements(By.xpath("//button[contains(@id,'remove') and contains(text(),'Remove')]")); // поиск элемента с условием AND, прим. //input[@class='_2zrpKA _1dBPDZ' and @type='text']
        cartClean.forEach(element -> element.click());
        driver.findElement(By.xpath("//div[contains(text(),'Backpack')]")).click(); // Поиск по частичному совпадению текста, прим. By.xpath("//tag[contains(text(),'text')]");
        driver.findElement(By.xpath("//button[contains(@id,'backpack')]")).click(); // Поиск по частичному совпадению атрибута, прим. By.xpath("//tag[contains(@attribute,'text')]");
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='inventory_item_price']")).getText(), "$29.99"); // Поиск по атрибуту, прим. By.xpath("//tag[@attribute='value']");
        Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), "Sauce Labs Backpack"); // tagname.class
        driver.findElement(By.xpath("//button[text()='Remove']")).click(); // Поиск по тексту, наприм. By.xpath("//tag[text()='text']");
        driver.findElement(By.cssSelector("#checkout")).click(); // #id
    }
}
