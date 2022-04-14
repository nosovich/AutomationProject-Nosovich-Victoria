package Lectures.Lecture_23;

public class StaticClass {
    public static String name;
    public Integer age;
    public static final String sex = "female"; // обычные инициализации при объявлении переменной
    public static final String group;

    static {
        group = "QA07";  // инициализации в статическом блоке
    }
    public static void getName(String nameUser) {
        name = nameUser;
    }
    public void getAge() {
    }

    public void getAge(Integer ageUser) {}

    public static class User {
        public void getUser() {
        }

    }
}
