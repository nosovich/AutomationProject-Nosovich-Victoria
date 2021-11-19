package PageObject.Booking;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {

    @FindBy(css = "[data-testid~=title]")
    SelenideElement hotel;

    ElementsCollection stars = $$(By.xpath("(//div[@data-testid='rating-stars'])[1]/span"));

    public SearchPage isHotelDisplayed() {
        hotel.shouldBe(exist);
        return this;
    }

    public SearchPage verifyStars() {
        stars.shouldHave(size(5));
        return this;
    }
}