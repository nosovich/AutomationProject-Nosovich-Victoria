package Lectures.Lecture_19;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static MySQL.DeleteHelper.getDelete;
import static MySQL.InputHelper.getInput;
import static MySQL.SelectHelper.getSelect;
import static MySQL.UpdatedHelper.getUpdate;

public class Lecture_19 {

//    @Test
//    public void test1() throws Exception {
//        Connection connection = DriverManager.getConnection("jdbc:mysql://db4free.net/testqa07?user=testqa07&password=testqa07");
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from user");
//        while (resultSet.next()) {
//            Integer id = resultSet.getInt("id");
//            String firstName = resultSet.getString("first_name");
//            String lastName = resultSet.getString("last_name");
//            Integer age = resultSet.getInt("age");
//            System.out.println("Id => " + id + ", First name => " + firstName + ", Last name => " + lastName + ", Age => " + age);
//        }
//    }
//
//    @Test
//    public void test2() throws Exception {
//        ResultSet resultSet = getSelect().select("*").from("user").resultSet();
//        while (resultSet.next()) {
//            Integer id = resultSet.getInt("id");
//            String firstName = resultSet.getString("first_name");
//            String lastName = resultSet.getString("last_name");
//            Integer age = resultSet.getInt("age");
//            System.out.println("Id => " + id + ", First name => " + firstName + ", Last name => " + lastName + ", Age => " + age);
//        }
//    }

    @Test
    public void test3() throws Exception {
        getSelect().select("*").from("user").getListData().forEach(System.out::println);
        getSelect().select("*").from("user").where("id in (3, 4)").getListData().forEach(System.out::println);
        System.out.println(getSelect().select("*").from("user").where("id in (3, 4)").getListData()); // код из предыдущей строчки, только иной способ вывода данных в консоль
        System.out.println(getSelect().select("*").from("user").where("id in (3, 4)").getMapData());
        System.out.println(getSelect().select("*").from("user").where("id in (3, 4)").getMapData().get("age"));
        Assert.assertEquals(getSelect().select("*").from("user").where("id in (3)").getMapData().get("id").get(0), "3");
    }

    @Test(dataProvider = "data")
    public void selectTest(String id) {
        Assert.assertEquals(getSelect().select("*").from("user").where("id=" + id).execute().getListData().get(0).get(0), id);
        Assert.assertEquals(getSelect().select("*").from("user").where("id=" + id).execute().getMapData().get("id").get(0), id);
    }

    @DataProvider(name = "data", parallel = true)
    private Object[][] getData() {
        return new Object[][]{
                {"1"},
                {"2"},
                {"3"},
                {"4"},
        };
    }

    @Test(priority = 2)
    public void insertTest() {
        getInput().table("user").into("id, first_name").values("33, 'Data'").execute();
        Assert.assertEquals(getSelect().select("*").from("user").where("id=33").execute().getListData().get(0).get(0), "33");
    }

    @Test(priority = 3)
    public void updateTest() {
        getUpdate().table("user").set("first_name='Data 1'").where("id=33").execute();
        Assert.assertEquals(getSelect().select("*").from("user").where("id=33").execute().getMapData().get("first_name").get(0), "Data 1");
    }

    @Test(priority = 4)
    public void deleteTest() {
        getDelete().from("user").where("id=33").execute();
        Assert.assertTrue(getSelect().select("*").from("user").where("id=33").execute().getListData().isEmpty());
    }
}

}
