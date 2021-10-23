package PageObject.Saucedemo.Product;

import org.openqa.selenium.By;

public enum SortingEnum {
    NameFromAToZ(By.xpath("(//select//option)[1]")),
    NameFromZToA(By.xpath("(//select//option)[2]")),
    PriceFromLowToHigh(By.xpath("(//select//option)[3]")),
    PriceFromHighToLow(By.xpath("(//select//option)[4]"));

    private By element;

    SortingEnum(By element) {
        this.element = element;
    }

    public By getElement() {
        return element;
    }

}

