package Lectures.Lecture_22.steps;

import Driver.BaseTestSelenide;
import PageObject.MoodPanda_Selenide.HomePage;
import PageObject.MoodPanda_Selenide.TestimonialsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TestimonialsPage_Steps extends BaseTestSelenide {

    @When("click scroll down button")
    public void clickScrollDownBtn() {
        get(HomePage.class)
                .clickScrollDownBtn();
    }

    @Then("verify testimonials page")
    public void verifyTestimonialsPage() {
        get(TestimonialsPage.class)
                .verifyContentText("FOR MOOD-TRACKING")
                .verifyContentText("MOBILE & WEB APP");
    }
}
