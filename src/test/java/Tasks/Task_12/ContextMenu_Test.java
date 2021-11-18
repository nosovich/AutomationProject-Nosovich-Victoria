package Tasks.Task_12;

import Driver.BaseTest;
import PageObject.Herokuapp.ContextMenuObject;
import PageObject.Herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.*;

public class ContextMenu_Test extends BaseTest {

    ContextMenuObject contextMenuObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void preconditions() {
        homePageObject = new HomePageObject();
        contextMenuObject = new ContextMenuObject();
        homePageObject.clickLink(CONTEXT_MENU);
    }

    @Test
    public void ContextMenu_Test() {
        contextMenuObject.verifyPageTitle()
                .verifyAlertText().pause(2);
    }
}

