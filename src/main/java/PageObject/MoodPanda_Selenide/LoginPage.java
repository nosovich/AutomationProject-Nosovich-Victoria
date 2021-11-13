package PageObject.MoodPanda_Selenide;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    SelenideElement email = $("#ContentPlaceHolderContent_TextBoxEmail");
    SelenideElement password = $("#ContentPlaceHolderContent_TextBoxPassword");
    SelenideElement loginBtn = $("#ContentPlaceHolderContent_ButtonLogin");
    SelenideElement errorMessage = $("#ContentPlaceHolderContent_MessageError");
    SelenideElement createAccountBtn = $("#ContentPlaceHolderContent_HyperLinkRegister");

    public LoginPage clickCreateAccountBtn() {
        createAccountBtn.click();
        return this;
    }

    public LoginPage clickLoginBtn() {
        loginBtn.click();
        return this;
    }

    public LoginPage enterEmail(String emailText) {
        email.setValue(emailText);
        return this;
    }

    public LoginPage enterPassword(String passwordText) {
        password.setValue(passwordText);
        return this;
    }

    public LoginPage checkErrorMessage(String errorText) {
        errorMessage.shouldBe(matchText(errorText));
        return this;
    }

}
