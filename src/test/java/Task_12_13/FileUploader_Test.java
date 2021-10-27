package Task_12_13;

import Driver.BaseTest;
import PageObject.Herokuapp.FileUploaderObject;
import PageObject.Herokuapp.HomePageLinksEnum;
import PageObject.Herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static PageObject.Herokuapp.HomePageLinksEnum.*;


public class FileUploader_Test extends BaseTest {
    HomePageObject homePageObject;
    FileUploaderObject fileUploaderObject;

    @BeforeClass
    public void precondition() {
        homePageObject = new HomePageObject(driver);
        fileUploaderObject = new FileUploaderObject(driver);
        homePageObject.clickLink(FILE_UPLOADER);
    }

    @Test
    public void fileUploader_Test() {
        fileUploaderObject
                .verifyPageTitle("File Uploader")
                .uploadFile()
                .clickFileSubmit()
                .verifyPageTitle("File Uploaded!")
                .verifyThatFileUploaded("image.jpg");
    }
}