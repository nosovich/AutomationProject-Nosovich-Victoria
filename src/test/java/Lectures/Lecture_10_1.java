package Lectures;

import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class Lecture_10_1 {

    List<String> list = new ArrayList<>();

//   groups — группы к которым принадлежит тест, например “smoke”, “slow”, “user-profile”
    @BeforeSuite(groups = "Before Group")
    public void beforeSuit() {
        list.add("BeforeSuit");
    }

    @BeforeTest(groups = "Before Group")
    public void beforeTest() {
        list.add("BeforeTest");
    }

    @BeforeClass(groups = "Before Group")
    public void beforeClass() {
        list.add("BeforeClass");
    }

    @BeforeGroups("Before Group")
    public void beforeGroups() {
        list.add("BeforeGroups");
    }

    @BeforeMethod(groups = "Before Group")
    public void beforeMethod() {
        list.add("BeforeMethod");
    }

    @Test(groups = "Before Group")
    public void test() {
        System.out.println(list);
    }

    @Test(groups = "Before Group1")
    public void test1() {
        System.out.println(list);
    }

    @AfterMethod(groups = "Before Group")
    public void afterMethod() {
        list.add("AfterMethod");
    }

    @AfterGroups(groups = "Before Group")
    public void afterGroups() {
        list.add("AfterGroups");
    }

    @AfterClass(groups = "Before Group")
    public void afterClass() {
        list.add("AfterClass");
    }

    @AfterTest(groups = "Before Group")
    public void afterTest() {
        list.add("AfterTest");
    }

    @AfterSuite(groups = "Before Group")
    public void afterSuite() {
        list.add("AfterSuite");
        System.out.println(list);
        System.out.println("AfterSuite was executed");
    }

}
