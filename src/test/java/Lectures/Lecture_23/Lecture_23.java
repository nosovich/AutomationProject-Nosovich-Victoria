package Lectures.Lecture_23;

import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Lecture_23 extends AbstractClass implements UserInterface {
    // Повторение понятие ссылки на метод
    @Test
    public void test() {
        List<String> list = Arrays.asList("13", "123", "123");
        list.stream().map(data -> Integer.parseInt(data)); // - приведение каждого элемента коллекции к типу Integer с помощью лямбда выражения
        list.stream().map(Integer::parseInt);// - приведение каждого элемента коллекции к типу Integer с помощью ссылки на метод
    }

    // Повторение лямбда выражений
    @Test
    public void test1() {
        Integer[] arr = {1, 2, 3};
        List<Integer> list = Arrays.asList(arr);

        List<Integer> newlist = new ArrayList<>();
        for (Integer el : list) {
            if (el > 1) {
                newlist.add(el);
            }
        }
        // То же действие, но записано с помощью лябмда выражения
        List<Integer> newlist1 = newlist.stream().filter(el -> el > 1).collect(Collectors.toList());

        Map<String, String> map = new HashMap<>();
        map.forEach((key, value) -> value.toLowerCase());
    }

    // Повторение по абстракции
    @Override
    public void setName() {
        super.name = "test";
    }
    @Test
    public void test2() {
        setName();
        System.out.println(super.getName());
    }
}