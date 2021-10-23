package Task_12;

import Driver.BaseTest;
import PageObject.Herokuapp.DynamicControlsObject;
import PageObject.Herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static PageObject.Herokuapp.HomePageLinksEnum.DYNAMIC_CONTROLS;

public class DynamicControls_Test extends BaseTest {

//    В проект HerokuApp добавить тесты для следующих страницы Dynamic Controls
//    1.Найти чекбокс
//    2.Нажать на кнопку
//    3.Дождаться надписи “It’s gone”
//    4.Проверить, что чекбокса нет
//    5.Найти инпут
//    6.Проверить, что он disabled
//    7.Нажать на кнопку
//    8.Дождаться надписи “It's enabled!”
//    9.Проверить, что инпут enabled


    DynamicControlsObject dynamicControlsObject;
    HomePageObject homePageObject;

    @BeforeClass
    public void preconditions() {
        homePageObject = new HomePageObject(driver);
        dynamicControlsObject = new DynamicControlsObject(driver);
        homePageObject.clickLink(DYNAMIC_CONTROLS);
    }

    @Test
    public void dynamicControls_Test() {
        dynamicControlsObject.verifyPageTitle()
                .clickRemoveBtn()
                .verifyRemoveText("It's gone!")
                .verifyCheckboxIsNotExist()
                .verifyInputDisabled()
                .clickEnableBtn()
                .verifyEnableText("It's enabled!")
                .verifyInputEnabled();
    }
}
