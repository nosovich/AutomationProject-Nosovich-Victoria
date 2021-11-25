package Lectures.Lecture_18;

import Driver.BaseTestSelenide;
import PageObject.MoodPanda_Selenide.HomePage;
import PageObject.MoodPanda_Selenide.TestimonialsPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class MoodPandaTest extends BaseTestSelenide {


    @Test
    public void verifyHomePage_Test() {
        open("https://moodpanda.com/");
        page(HomePage.class)
                .checkBrandNameSubtext()
                .checkImage();
    }
// Тут методы open и page объединены в один метод get с помощью дженериков(см. BaseTestSelenide)
    @Test
    public void verifyHomePage_Test1() {
        get(HomePage.class)
                .checkBrandNameSubtext()
                .clickScrollDownBtn();
        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }

    @AfterMethod
    public void postconditions() {
        closeWebDriver();
    }
}
