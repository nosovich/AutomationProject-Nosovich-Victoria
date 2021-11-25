package Tasks.Task_20_Cucumber.steps;

import Driver.BaseTestSelenide;
import PageObject.Booking.HomePage;
import PageObject.Booking.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingTest extends BaseTestSelenide {

    @Given("to go {string}")
    public void openPage(String url) {
        get(HomePage.class, url);
    }

    @When("enter the hotel name and press search button")
    public void chooseHotel() {
        get(HomePage.class)
                .enterHotel("Nosalowy Park Hotel");
    }

    @Then("check that the selected hotel exists and has 5 stars")
    public void checkHotelStars() {
        get(SearchPage.class)
                .isHotelDisplayed()
                .verifyStars();
    }
}