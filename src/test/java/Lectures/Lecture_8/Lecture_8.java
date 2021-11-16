package Lectures.Lecture_8;

import Pojo.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.testng.Assert.*;

public class Lecture_8 {
    @Test
    public void test1() throws IOException {
        Gson gson = new Gson();
        String jsonData = readData();
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
        System.out.println(jsonObject.get("shopperName"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(0).getAsJsonObject().get("productName"));
        System.out.println(jsonObject.get("contents").getAsJsonArray().get(1).getAsJsonObject().get("productName"));
        System.out.println(jsonObject);
    }

    //POJO
    @Test
    public void test2() throws IOException {
        Gson gson = new Gson();
        String jsonData = readData();
        User user = gson.fromJson(jsonData, User.class);
        System.out.println(user.getShopperName());
        System.out.println(user.getOrderID());
        System.out.println(user.getContents().get(0).getProductName());
        System.out.println(user.getContents().get(1).getProductName());
    }

    @Test
    public void test3() throws IOException {
        Gson gson = new Gson();
        String jsonData = readData();
        User user = gson.fromJson(jsonData, User.class);
        JsonObject jsonObject = gson.fromJson(jsonData, JsonObject.class);
        assertEquals(user.getOrderID(), jsonObject.get("orderID").getAsDouble());
    }

    public String readData() throws IOException {
        return new String(Files.readAllBytes(Paths.get("src/test/java/Lecture_8/data.json")));
    }

}
