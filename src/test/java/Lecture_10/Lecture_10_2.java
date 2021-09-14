package Lecture_10;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Lecture_10_2 {
    List<String> list = new ArrayList<>();

//  dependsOnMethods — методы, от которых зависит, сначала будут выполнены они, а затем данный метод
    @Test(dependsOnMethods = "test3")
    public void test1() {
        Assert.assertTrue(list.isEmpty());
    }

//  enabled — можно временно отключить тест, установив значение в false (по умолчанию true)
    @Test(enabled = false)
    public void test2() {
        Assert.assertTrue(list.isEmpty());
    }

//  timeOut - время после которого тест считается упавшим
    @Test(timeOut = 3000)
    public void test3() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertTrue(list.isEmpty());
    }

    @Test(dependsOnMethods = "test1")
    public void test4() {
        Assert.assertTrue(list.isEmpty());}

//  invocationCount - количество раз которое нужно повторить тест
    @Test(dependsOnMethods = "test4", invocationCount = 3)
    public void test5() {
        list.add("123");
        System.out.println(list);}

//  expectedExceptions — ожидаемые Exceptions, если тест-кейс негативный
    @Test(dependsOnMethods = "test5", expectedExceptions = AssertionError.class)
    public void test6() {
        Assert.assertTrue(list.isEmpty());
    }

//  alwaysRun - если true, то метод будет выполняться вне зависимости от результатов методов на которые он завязан
    @Test(dependsOnMethods = "test6", expectedExceptions = AssertionError.class, alwaysRun = true)
    public void test7() {
        Assert.assertTrue(list.isEmpty());
    }

}
