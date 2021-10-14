package PageObject.BarMenu;

import org.openqa.selenium.By;

public enum   LinksEnum {
    Logout(By.id("logout_sidebar_link")),
    Inventory(By.id("inventory_sidebar_link")),
    About(By.id("about_sidebar_link")),
    Reset(By.id("reset_sidebar_link"));

    private By element;

    LinksEnum(By element) {
        this.element = element;
    }

    public By getElement() {
        return element;
    }
}
