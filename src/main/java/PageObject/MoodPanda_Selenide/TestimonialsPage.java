package PageObject.MoodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class TestimonialsPage {

    @FindBy(css = ".row.text-center h1")
    SelenideElement testimonialsTxt;

 // Тот же самый элемент, только описание без аннотации @FindBy
    SelenideElement testimonialsTxt1 = $(".row.text-center h1");

    public TestimonialsPage verifyContentText(String text) {
        testimonialsTxt.shouldBe(matchText(text));
        return this;
    }
}
