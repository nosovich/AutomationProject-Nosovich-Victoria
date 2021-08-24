import Driver.DriverExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.List;

public class Task_5 extends DriverExecutor {
    /**
     * Написать 3 теста по сценарию ниже с различными данными и вариантами.
     * 1.	Открыть сайт https://masterskayapola.ru/kalkulyator/laminata.html
     * 2.	Ввести параметры для расчета.
     * 3.	Нажать на кнопку ‘Рассчитать’.
     * 4.	Проверить полученные значения.
     * 5.	Закрыть окно браузера.
     */

    @BeforeTest
    public void preconditions() {
        driver.get("https://masterskayapola.ru/kalkulyator/laminata.html");
    }

    @Test
    public void test1() {
        enter("calc_roomwidth", 4);
        enter("calc_roomheight", 5);
        enter("calc_lamwidth", 1500);
        enter("calc_lamheight", 200);
        enter("calc_inpack", 15);
        enter("calc_price", 1000);
        enter("calc_bias", 100);
        enter("calc_walldist", 10);
        select().selectByIndex(0);
        calcButton().click();
        Assert.assertEquals(Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 19.82 м2.", "Кол-во панелей: 70 шт.", "Кол-во упаковок: 5 шт.", "Стоимость: 22500 руб.", "Остатки: 5 шт.", "Отрезки: 12 шт."), getCalculations());
    }

    @Test
    public void test2() {
        enter("calc_roomwidth", 1);
        enter("calc_roomheight", 2);
        enter("calc_lamwidth", 1000);
        enter("calc_lamheight", 100);
        enter("calc_inpack", 7);
        enter("calc_price", 20000);
        enter("calc_bias", 500);
        enter("calc_walldist", 10);
        select().selectByIndex(1);
        calcButton().click();
        Assert.assertEquals(Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 1.94 м2.", "Кол-во панелей: 21 шт.", "Кол-во упаковок: 3 шт.", "Стоимость: 42000 руб.", "Остатки: 0 шт.", "Отрезки: 7 шт."), getCalculations());
    }

    @Test
    public void test3() {
        enter("calc_roomwidth", 3);
        enter("calc_roomheight", 4);
        enter("calc_lamwidth", 1300);
        enter("calc_lamheight", 100);
        enter("calc_inpack", 12);
        enter("calc_price", 700);
        enter("calc_bias", 200);
        enter("calc_walldist", 12);
        select().selectByIndex(1);
        calcButton().click();
        Assert.assertEquals(Arrays.asList("РЕЗУЛЬТАТ РАСЧЕТА:", "Площадь укладки: 11.83 м2.", "Кол-во панелей: 95 шт.", "Кол-во упаковок: 8 шт.", "Стоимость: 8736 руб.", "Остатки: 1 шт.", "Отрезки: 10 шт."), getCalculations());
    }

    public void enter(String element, Integer dataInt) {
        driver.findElement(By.name(element)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        driver.findElement(By.name(element)).sendKeys(dataInt.toString());
    }

    private Select select() {
        return new Select(driver.findElement(By.name("calc_direct")));
    }

    private WebElement calcButton() {
        WebElement calcButton = driver.findElement(By.xpath(("(//input[@type='button'])[1]")));
        return calcButton;
    }

    private List<String> getCalculations() {
        List<String> calculations = Arrays.asList(driver.findElement(By.cssSelector(".col-xs-12.col-sm-12.whiteback")).getText().split("\n"));
        return calculations;
    }
}


