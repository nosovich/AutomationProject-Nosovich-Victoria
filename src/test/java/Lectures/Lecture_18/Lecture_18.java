package Lectures.Lecture_18;

import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.ElementsCollection.*;
import static com.codeborne.selenide.CollectionCondition.*;

public class Lecture_18 {

    @Test
    public void test1() {
        browserSize = "1800x1000";
        open("https://moodpanda.com/");
        $(By.xpath("//a[@class='navbar-brand page-scroll']")).shouldBe(exist);
        $(".scroll-down > a").click();
        $("#bs-example-navbar-collapse-1").findAll(byXpath("ul//li//a")).shouldBe(sizeGreaterThan(4));
    }
}