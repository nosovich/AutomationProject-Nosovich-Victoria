package Tasks.Task_12;

import Driver.BaseTest;
import PageObject.Herokuapp.HomePageObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage_Test extends BaseTest {

    HomePageObject homePageObject;

    @BeforeClass
    public void preconditions() {
        homePageObject = new HomePageObject();
    }

    @Test
    public void verifyHomePageObject_Test() {
        homePageObject.openPage()
                .verifyHomePage();
    }

//   Пример сортировки коллекции, где в элементах валюта.
//    @Test
//    public void test() {
//        List<String > list = Arrays.asList("$7,99", "$12,99", "$3,99", "$15,99");
//        list.stream()
//                .map(el -> el.replace("$", "").replace(",", "."))
//                .map(Double::parseDouble)
//                .sorted()
//                .collect(Collectors.toList())
//                .forEach(System.out:: println);
//    }

}