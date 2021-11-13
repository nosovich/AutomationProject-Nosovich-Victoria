package PageObject.MoodPanda_Selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationForm {

    SelenideElement firstName = $("#ContentPlaceHolderContent_TextBoxFirstName");
    SelenideElement surName = $("#ContentPlaceHolderContent_TextBoxSurname");
    SelenideElement gender = $("#ContentPlaceHolderContent_DropDownListGender");
    SelenideElement yourBirth = $("#ContentPlaceHolderContent_DropDownListYearOfBirth");
    SelenideElement email = $("#ContentPlaceHolderContent_TextBoxEmail");
    SelenideElement password = $("#ContentPlaceHolderContent_TextBoxPassword");
    SelenideElement passwordConfirm = $("#ContentPlaceHolderContent_TextBoxPasswordConfirm");
    SelenideElement cancelBtn = $(".modal-footer>a[href = '/']");
    SelenideElement loginBtn = $("#ContentPlaceHolderContent_ButtonLogin");
    SelenideElement errorMessage = $("#ContentPlaceHolderContent_MessageError");
    SelenideElement errorUserExist = $("#ContentPlaceHolderContent_MessageExists");
    SelenideElement updateMoodWindow = $("[class*='ButtonUpdateWelcome']");

    public RegistrationForm clickloginBtn() {
        loginBtn.click();
        return this;
    }

    public RegistrationForm clickCancelBtn() {
        cancelBtn.click();
        return this;
    }

    public RegistrationForm enterFirstName(String firstName) {
        this.firstName.setValue(firstName);
        return this;
    }

    public RegistrationForm enterSurName(String surName) {
        this.surName.setValue(surName);
        return this;
    }

    public RegistrationForm selectGender(int option) {
        gender.selectOption(option);
        return this;
    }

    public RegistrationForm selectYourBirth(int option) {
        yourBirth.selectOption(option);
        return this;
    }

    public RegistrationForm enterEmail(String email) {
        this.email.setValue(email);
        return this;
    }

    public RegistrationForm enterPassword(String password) {
        this.password.setValue(password);
        return this;
    }

    public RegistrationForm confirmPassword(String password) {
        passwordConfirm.setValue(password);
        return this;
    }

    public RegistrationForm checkErrorMessage(String errorText) {
        errorMessage.shouldBe(matchText(errorText));
        return this;
    }

    public RegistrationForm verifyUpdateMoodWindow() {
        updateMoodWindow.shouldBe(exist);
        return this;
    }

    public RegistrationForm checkErrorUserExist(String errorText) {
        errorUserExist.shouldBe(matchText(errorText));
        return this;
    }
}
