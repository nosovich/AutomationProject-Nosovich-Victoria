package Tasks.Task_12;

import Driver.BaseTest;
import PageObject.Herokuapp.FramesObject;
import PageObject.Herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.FRAMES;

public class Frames_Test extends BaseTest {

    FramesObject framesObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void preconditions() {
        framesObject = new FramesObject();
        homePageObject = new HomePageObject();
        homePageObject.clickLink(FRAMES);
    }

    @Test
    public void frames_Test() {
        framesObject
                .verifyPageTitle("Frames")
                .clickFrameLink("iFrame")
                .verifyPageTitle("An iFrame containing the TinyMCE WYSIWYG Editor")
                .verifyFrameText("Your content goes here.");

    }

}
