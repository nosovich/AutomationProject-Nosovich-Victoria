package PageObject.Herokuapp;

import PageObject.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import static PageObject.Herokuapp.HomePageLinksEnum.FILE_UPLOADER;

public class FileUploaderObject extends BasePage {
    private By uploadBtn = By.id("file-upload");
    private By title = By.tagName("h3");
    private By fileSubmit = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");
    private By dragDropUpload = By.id("drag-drop-upload");
    private By uploadFileName = By.xpath("//*[@id='drag-drop-upload']//span");
    private String userDir = System.getProperty("user.dir");

    public FileUploaderObject(WebDriver driver) {
        super(driver);
    }

    public FileUploaderObject verifyPageTitle(String title) {
        Assert.assertEquals(getElementText(this.title), title);
        return this;
    }

    public FileUploaderObject uploadFile() {
        driver.findElement(uploadBtn).sendKeys(userDir + properties.getProperty("filePath"));
        return this;
    }

    public FileUploaderObject clickFileSubmit() {
        click(fileSubmit);
        return this;
    }

    public FileUploaderObject verifyThatFileUploaded(String name) {
        Assert.assertEquals(getElementText(uploadedFiles), name);
        return this;
    }

    public FileUploaderObject dragAndDropUpload(String imgName) {
        click(dragDropUpload);
        pause(1);
        StringSelection stringSelection = new StringSelection(userDir + "\\files\\" + imgName);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
        try{
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        Assert.assertEquals(getElementText(uploadFileName), imgName);
        return this;
    }
}