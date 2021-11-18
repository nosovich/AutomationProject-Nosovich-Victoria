package Tasks.Task_16;

import Driver.BaseTestSelenide;
import PageObject.MoodPanda_Selenide.AboutPage;
import PageObject.MoodPanda_Selenide.HomePage;
import PageObject.MoodPanda_Selenide.LoginPage;
import PageObject.MoodPanda_Selenide.RegistrationForm;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class Task_16 extends BaseTestSelenide {

    @DataProvider(name = "login data", parallel = true)
    public Object[][] logindata() {
        return new Object[][]{
                {"nos111@gmail.com", "111", ""},
                {"nos111@gmail.com", "", "Error: Could not find account. Forgot Password?"},
                {"", "", "Could not find account"},
        };
    }

    @DataProvider(name = "registration data", parallel = true)
    public Object[][] userData() {
        return new Object[][]{
                {"Vika", "N", 0, 15, "nos111@gmail.com", "111", "111", "Error: This email is already registed with MoodPanda"},
                {"Vika", "N", 0, 1, "", "", "", "Error: Please complete all fields correctly"},
        };
    }

    @Test
    @Description("Checking the visibility of elements on the HomePage, scrolling page")
    public void verifyHomePage_Test() {
        get(HomePage.class)
                .checkBrandNameSubtext()
                .clickScrollDownBtn();
    }

    @Test(dataProvider = "login data")
    @Description("Checking for successful and unsuccessful login")
    public void login_Test(String email, String password, String error) {
        get(HomePage.class)
                .goToLoginPage();
        get(LoginPage.class)
                .enterEmail(email)
                .enterPassword(password)
                .clickLoginBtn();
        if (!error.isEmpty()) {
            get(LoginPage.class)
                    .checkErrorMessage(error);
        }
    }

    @Test(dataProvider = "registration data")
    @Description("Checking registration of an existing user and registration with empty fields")
    public void registration_Test(String firstName, String surName, int gender, int birth, String email, String password, String confirmPassword, String error) {
        String errorMes = "Error: Please complete all fields correctly";
        get(HomePage.class)
                .goToLoginPage();
        get(LoginPage.class)
                .clickCreateAccountBtn();
        get(RegistrationForm.class)
                .enterFirstName(firstName)
                .enterSurName(surName)
                .selectGender(gender)
                .selectYourBirth(birth)
                .enterEmail(email)
                .enterPassword(password)
                .confirmPassword(confirmPassword)
                .clickloginBtn();
        if (error.equals(errorMes)) {
            get(RegistrationForm.class)
                    .checkErrorMessage(error);
        } else get(RegistrationForm.class)
                .checkErrorUserExist(error);

    }

    @Test
    @Description("Checking the visibility of AboutPage")
    public void verifyAboutPage_Test() {
        get(HomePage.class)
                .goToAboutPage();
        get(AboutPage.class)
                .verifyText();
    }

    @AfterMethod
    public void postconditions() {
        closeWebDriver();
    }
}
