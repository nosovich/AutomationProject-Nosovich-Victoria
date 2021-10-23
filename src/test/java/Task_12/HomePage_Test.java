package Task_12;

import Driver.BaseTest;
import PageObject.Herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {

    HomePageObject homePageObject;

    @BeforeClass
    public void preconditions() {
        homePageObject = new HomePageObject(driver);
    }

    @Test
    public void verifyHomePageObject_Test() {
        homePageObject.open()
                .verifyHomePage();
    }

}