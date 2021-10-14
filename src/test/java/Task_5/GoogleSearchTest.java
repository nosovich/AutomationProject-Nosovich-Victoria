package Task_5;

import Driver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GoogleSearchTest extends BaseTest {

    /**
     * Тест 1:
     * 1.	Ввести в поле поиска “Привет мир”.
     * 2.	Проскролить к последнему результату поиска.
     * 3.	Нажать на ссылку с последним результатом поиска.
     * 4.	Проверить, что портал по нажатию на ссылку успешно загрузился.
     * 5.	Закрыть окно браузера.
     * <p>
     * Тест 2:
     * 1.	Ввести в поле поиска  “//”.
     * <p>
     * 2.	Проверить, что отображается текст:
     * По запросу // ничего не найдено.
     * Рекомендации:
     * Убедитесь, что все слова написаны без ошибок.
     * Попробуйте использовать другие ключевые слова.
     * Попробуйте использовать более популярные ключевые слова.
     * <p>
     * 3.	Закрыть окно браузера.
     */

    @BeforeMethod
    public void preconditions() {
        driver.get("https://www.google.com/");
        preCondSetting();
    }

    @Test
    public void test1() {
        driver.findElement(By.name("q")).sendKeys("Привет мир", Keys.ENTER);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h3[contains(text(),'Банковская')]")));
        driver.findElement(By.xpath("//h3[contains(text(),'Банковская')]")).click();
    }

    @Test
    public void test2() {
        driver.findElement(By.name("q")).sendKeys(("//"), Keys.ENTER);
        Assert.assertEquals(expectedResultText(), searchResultText());
    }

    //    При запуске google из Польши всплывает окно, где необходимо дать согласие на обработку данных.
    private void preCondSetting() {
        boolean popupExists = !driver.findElements(By.id("L2AGLb")).isEmpty();
        if (popupExists) {
            WebElement consentData = driver.findElement(By.id("L2AGLb"));
            consentData.click();
        }
    }

    private List<String> searchResultText() {
        List<String> searchResult = Arrays.asList(driver.findElement(By.className("card-section")).getText().split("\n"));
        return searchResult;
    }

    private List<String> expectedResultText() {
        List<String> expectedResult = Arrays.asList("По запросу // ничего не найдено. ", "Рекомендации:", "Убедитесь, что все слова написаны без ошибок.", "Попробуйте использовать другие ключевые слова.", "Попробуйте использовать более популярные ключевые слова.");
        return expectedResult;
    }
}

