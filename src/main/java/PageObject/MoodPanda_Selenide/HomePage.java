package PageObject.MoodPanda_Selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = ".scroll-down > a")
    SelenideElement scrollDownBtn;

    @FindBy(className = "brand-name-subtext")
    SelenideElement brandNameSubtext;

    @FindBy(css = ".img-responsive.img-centered")
    SelenideElement img;

    @FindBy(xpath = "//li//a[@href = '/Login/']")
    SelenideElement loginBtn;

    @FindBy(xpath = "//li//a[@href = '/about.aspx']")
    SelenideElement aboutBtn;

    public HomePage clickScrollDownBtn() {
        scrollDownBtn.click();
        return this;
    }

    public HomePage checkBrandNameSubtext() {
        brandNameSubtext.should(Condition.matchText("track your mood & get anonymous support"));
        return this;
    }

    public HomePage checkImage() {
        this.img.shouldBe(Condition.exist);
        return this;
    }

    public HomePage goToLoginPage() {
        loginBtn.click();
        return this;
    }

    public HomePage goToAboutPage() {
        aboutBtn.click();
        return this;
    }
}
