package PageObject.MoodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class AboutPage {

    SelenideElement aboutUsTxt = $(".bg-gray h2");

    public AboutPage verifyText() {
        aboutUsTxt.shouldBe(matchText("ABOUT US"));
        return this;
    }


}
