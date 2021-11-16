package Lectures.Lecture_14;

import Compare.Person;
import Compare.Sort;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Lecture_14 {

    @Test
    public void test() {

        // Сортировка пузырьком. Идея заключатестя в том, что по результату одной итерации (прохода/повторения)
        // на поверхность выплывает маскимальный/минимальный элемент
        int[] mas = {11, 3, 14, 16, 7};

        boolean isSorted = false; // флак, просортирован массив или нет
        int buf; // переменная, куда будем закидывать значение элемента при обмене, чтобы данные не затирались
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < mas.length - 1; i++) {
                if (mas[i] > mas[i + 1]) {
                    isSorted = false;

                    buf = mas[i];
                    mas[i] = mas[i + 1];
                    mas[i + 1] = buf;
                }
            }
        }
        System.out.println(Arrays.toString(mas));
    }

    // Сортировка c помощью интерфейса Comparator.
    @Test
    public void test1() {
        Person person = new Person("Person 1", 23);
        Person person1 = new Person("Person 2", 33);
        Person person2 = new Person("Person 3", 41);
        Person person3 = new Person("Person 4", 28);
        Person person4 = new Person("Person 5", 70);

        List<Person> people = new ArrayList<>() {{
            add(person);
            add(person1);
            add(person2);
            add(person3);
            add(person4);
        }};

        Sort sort = new Sort();
        people.sort(sort);
        people.forEach(System.out::println);
    }

    // Сортировка c помощью stream
    @Test
    public void test2() {
        List<Integer> data = new ArrayList<>() {{
           addAll(Arrays.asList(94,3,40,8,23,76,33));
        }};

        data.stream().sorted((o1, o2) -> o1.compareTo(o2)); // У stream есть метод sorted, в котороый можно передать Comporator (тут сортировка по возрастанию)
        data.stream().sorted((o1, o2) -> o2.compareTo(o1)); // У stream есть метод sorted, в котороый можно передать Comporator (тут сортировка по убыванию)
        data.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()).forEach(System.out::println); // или sorted можно передать Comporator, и у того вызвать метод. Например, naturalOrder делает сортировку по возрастанию, reverseOrder делает сортировку по убыванию.

    }

    // Сортировка c помощью класса Collections
    @Test
    public void test3() {
        List<Integer> data = new ArrayList<>() {{
            addAll(Arrays.asList(94,3,40,8,23,76,33));
        }};
        Collections.sort(data); // сортировка по возрастанию
        data.forEach(System.out::println);
        Collections.reverse(data); // сортировка по убыванию
        data.forEach(System.out::println);
        Collections.shuffle(data); // перетусовать коллекцию
        data.forEach(System.out::println);
    }

 // Сортировка через метод sort самого List.
    @Test
    public void test4() {
        List<Integer> data = new ArrayList<>() {{
            addAll(Arrays.asList(94, 3, 40, 8, 23, 76, 33));
        }};

        data.sort(Comparator.reverseOrder());
        data.forEach(System.out::println);
    }
}
