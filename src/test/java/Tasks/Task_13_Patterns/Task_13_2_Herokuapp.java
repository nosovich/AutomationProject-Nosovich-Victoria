package Tasks.Task_13_Patterns;

import Driver.BaseTest;
import PageFactory.Herokuapp.LoginPage_Builder;
import PageFactory.Herokuapp.LoginPage_VObject;
import PageObject.Herokuapp.HomePageObject;
import Patterns.Builder.HerokuappUser_Builder;
import Patterns.ValueObject.HerokuappUser_VObject;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.FORM_AUTHENTICATION;

public class Task_13_2_Herokuapp extends BaseTest {

    HomePageObject homePageObject;
    LoginPage_VObject loginPageVObject;
    LoginPage_Builder loginPageBuilder;
    HerokuappUser_Builder userBuilder;
    HerokuappUser_VObject herokuappUser;

    @BeforeMethod
    public void preconditions() {
        homePageObject = new HomePageObject();
        loginPageBuilder = new LoginPage_Builder(driver);
        loginPageVObject = new LoginPage_VObject(driver);
        herokuappUser = new HerokuappUser_VObject();
        homePageObject.openPage()
                .clickLink(FORM_AUTHENTICATION);
    }

    @Test
    public void loginToAppPositive_Test() {
        herokuappUser.setUserName("tomsmith");
        herokuappUser.setPassword("SuperSecretPassword!");
        herokuappUser.setStatusText("You logged into a secure area!");
        loginPageVObject.login(herokuappUser);
    }

    @Test
    public void loginToApplicationNegative_Test() {
        userBuilder = new HerokuappUser_Builder.Builder()
                .withUserName("agent 007")
                .withPassword("SuperSecretPassword!")
                .withStatusText("Your username is invalid!")
                .build();
        loginPageBuilder.login(userBuilder)
                .checkStatusText(userBuilder);
    }
}