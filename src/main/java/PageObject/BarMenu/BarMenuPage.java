package PageObject.BarMenu;

import PageObject.BasePage;
import org.openqa.selenium.By;

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
