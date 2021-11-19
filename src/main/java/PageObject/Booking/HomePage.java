package PageObject.Booking;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "#ss")
    SelenideElement searchField;

    @FindBy(css = ".b-button__text")
    SelenideElement searchBtn;

    public HomePage enterHotel(String text) {
        searchField.setValue(text);
        searchField.pressEnter();
        return this;
    }

    public HomePage clickSearchBtn() {
        searchBtn.click();
        return this;
    }
}