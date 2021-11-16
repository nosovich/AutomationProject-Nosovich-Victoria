package PageObject.Saucedemo.BarMenu;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BarMenuPage extends BasePage {
    private By reactBurgerMenuBtn = By.id("react-burger-menu-btn");

    public BarMenuPage clickBarMenu() {
        click(reactBurgerMenuBtn);
        return this;
    }

    public BarMenuPage clickLinks(LinksEnum links) {
        click(links.getElement());
        return this;
    }
}
