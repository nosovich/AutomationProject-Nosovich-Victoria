package Lectures.Lecture_17;

import Lectures.Lecture_17.User.Root;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Lecture_17 {

    @DataProvider(parallel = true)
    public Object[][] data() {
        return new Object[][]{
                {1},
                {2},
                {3},
                {4},
                {5}
        };
    }

    public String readFilesAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Lectures/Lecture_17/Requests/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in/";
    }

    @Test
    public void test() {
        String endpoint = "/api/users?id=1";
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        assertEquals(root.data.id, 1);
    }

// GET запросы - получение данных

// Использование DaraProvider
    @Test(dataProvider = "data")
    public void test1(int idValue) {
        String endpoint = "/api/users?id=" + idValue;
        Gson gson = new Gson();
        Root root = gson.fromJson(given().when().get(endpoint).getBody().asPrettyString(), Root.class);
        assertEquals(root.data.id, idValue);
    }

// Если у нас есть POJO объекты, библиотека REST Assured позволяет работать с представлением объекта
// без библиотеки GSON. Делается это с помощью метода as(в параметре указываем класс, объект которого хотим создать)
    @Test
    public void test2() {
        String endpoint = "/api/users?id=6";
        Root root = given().when().get(endpoint).as(Root.class);
        assertEquals(root.data.id, 6);
    }

// Проверка статус-кода
    @Test
    public void test3() {
        String endpoint = "/api/users?id=7";
        given().when().get(endpoint).then().statusCode(HttpStatus.SC_OK);// Код можно забить с помощью HttpStatus...
        given().when().get(endpoint).then().statusCode(200);// Или прописать само значение числом
    }


// Использование параметра в тестах c помощью метода param("название параметра", "значение").
    @Test
    public void test4() {
        String endpoint = "/api/users";
        assertEquals(given().when().param("id", "8").get(endpoint).as(Root.class).data.id, 8);
    }


// POST запросы - создание сущности, передача данных

    @Test
    public void test5() {
        String endpoint = "/api/users";
        String requestBody = readFilesAsString("Post");
        Response response = given().header("Content-type", "application/json").and().body(requestBody).and().post(endpoint).then().extract().response();
        assertEquals(201, response.statusCode());
        assertEquals(response.jsonPath().get("name"), "morpheus");
        assertEquals(response.jsonPath().get("job"), "leader");
    }


// PUT запросы - изменение данных (всех). Если менять только часть полей в объекте черех Put запрос,
// в остальных полях, даже если перед изменениями в них имелись данные, автоматически проставится null.

    @Test
    public void test6() {
        String endpoint = "/api/users";
        String requestBody = readFilesAsString("Put");
        Response response = given().header("Content-type", "application/json").and().body(requestBody).and().put(endpoint).then().extract().response();
        assertEquals(200, response.statusCode());
        assertEquals(response.jsonPath().get("job"), "zion resident");
    }


// PATCH запросы - изменение данных (можно частично). Если менять только часть полей в объекте черех Patch запрос,
// в остальных полях данные останутся неизменными.
    @Test
    public void test7() {
        String endpoint = "/api/users";
        String requestBody = readFilesAsString("Patch");
        Response response = given().header("Content-type", "application/json").and().body(requestBody).and().patch(endpoint).then().extract().response();
        assertEquals(200, response.statusCode());
        assertEquals(response.jsonPath().get("job"), "zion resident111");
    }


// Delete запросы - удвление сущности
    @Test
    public void test8() {
        String endpoint = "/api/users/2";
        Response response = given().when().delete(endpoint).then().extract().response();
        assertEquals(204, response.statusCode());
    }

}
