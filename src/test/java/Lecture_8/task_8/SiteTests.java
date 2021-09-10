package Lecture_8.task_8;

import Driver.DriverExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class SiteTests extends DriverExecutor {

    @BeforeTest
    public void preconditions() {
        driver.get("file:///R:/AutomationProject/AutomationProject-Nosovich-Victoria/src/test/java/Lecture_8/task_8/site.html");
    }

    @Test
    public void siteTest() {
        driver.findElement(By.id("username")).sendKeys("Victoria");
        driver.findElement(By.id("pwd")).sendKeys("1111");
        driver.findElement(By.id("logIn_btn")).click();
        driver.findElement(By.id("cat")).click();
        new Select(driver.findElement(By.id("cities"))).selectByIndex(1);
        assertTrue(driver.findElement(By.cssSelector("[src='pets.jpg']")).isDisplayed());
        assertEquals(driver.findElement(By.id("hotel_chain")).getText(), "Pet hotel chain");
        List<WebElement> heads = driver.findElements(By.xpath("//table//th"));
        Map<String, List<String>> data = new HashMap<>();
        for (int index = 0; index < heads.size(); index++) {
            List<String> columnData = new ArrayList<>();
            List<WebElement> columns = driver.findElements(By.xpath("//table//tr//following::tr//td[" + (index + 1) + "]"));
            for (WebElement column : columns) {
                columnData.add(column.getText());
            }
            data.put(heads.get(index).getText(), columnData);
        }
        data.forEach((k, v) -> System.out.println(k + " -> " + v));
//        Map<String, List<String>> data1 = new HashMap<>() {{
//            List<WebElement> heads = driver.findElements(By.xpath("//table//th"));
//            for (int index = 0; index < heads.size(); index++) {
//                List<WebElement> columns = driver.findElements(By.xpath("//table//tr//following::tr//td[" + (index + 1) + "]"));
//                put(heads.get(index).getText(),columns.stream().map(d -> d.getText()).collect(Collectors.toList()));
//            }
//        }};
//        data.forEach((k, v) -> System.out.println(k + " -> " + v));
        assertEquals(data.get("Team").get(0).toString(),"Dinara Anders");
        assertEquals(data.get("Position").get(1).toString(),"Veterinary paramedic");
        driver.findElement(By.linkText("Instagram")).click();
        assertTrue(driver.findElement(By.cssSelector("[title=Home]")).isDisplayed());
    }
}


