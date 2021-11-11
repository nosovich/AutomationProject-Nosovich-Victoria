package Task_15;

import Task_15.Pojo.ResourceList.Root;
import Task_15.Pojo.SingleResource.Resource;
import Task_15.Pojo.SingleUser.Data;
import Task_15.Pojo.SingleUser.SingleUser;
import Task_15.Pojo.UserList.Datum;
import Task_15.Pojo.UserList.UserList;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.*;

public class Task_15 {

    public String readFilesAsString(String fileName) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/test/java/Task_15/Request/" + fileName + ".json")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    @BeforeTest
    public void preconditions() {
        baseURI = "https://reqres.in/";
    }

    @Test(priority = 1)
    public void getUserList_Test() {
        String endpoint = "/api/users?page=2";
        given().when().get(endpoint).then().statusCode(HttpStatus.SC_OK);
        UserList users = given().when().get(endpoint).as(UserList.class);
        assertEquals(users.page, 2);
        users.data.forEach(el ->
        {
            assertTrue(el.id > 0);
            assertNotNull(el.email);
            assertNotNull(el.first_name);
            assertNotNull(el.last_name);
            assertNotNull(el.avatar);
        });
    }

    @Test(priority = 2)
    public void getSingleUser_Test() {
        String endpoint = "/api/users/2";
        given().when().get(endpoint).then().statusCode(200);
        SingleUser user = given().when().get(endpoint).as(SingleUser.class);
        assertEquals(user.data.id, 2);
        assertNotNull(user.data.email);
        assertNotNull(user.data.first_name);
        assertNotNull(user.data.last_name);
        assertNotNull(user.data.avatar);
    }

    @Test(priority = 3)
    public void getSingleUserNotFound_Test() {
        String endpoint = "/api/users/23";
        given().when().get(endpoint).then().statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test(priority = 4)
    public void getResourceList_Test() {
        String endpoint = "/api/unknown";
        given().when().get(endpoint).then().statusCode(200);
        Root root = given().when().get(endpoint).as(Root.class);
        assertEquals(root.page, 1);
        assertEquals(root.data.size(), 6);
        root.data.forEach(el -> {
            assertTrue(el.id > 0);
            assertNotNull(el.name);
            assertTrue(el.year > 0);
            assertNotNull(el.pantone_value);
        });
    }

    @Test(priority = 5)
    public void getSingleResource_Test() {
        String endpoint = "/api/unknown/2";
        String expectedData = "Data(id=2, name=fuchsia rose, year=2001, color=#C74375, pantone_value=17-2031)";
        given().when().get(endpoint).then().statusCode(HttpStatus.SC_OK);
        Resource resource = given().when().get(endpoint).as(Resource.class);
        assertEquals(resource.data.toString(), expectedData);
    }

    @Test(priority = 6)
    public void getResourceNotFound_Test() {
        String endpoint = "/api/unknown/23";
        given().when().get(endpoint).then().statusCode(404);
    }

    @Test(priority = 7)
    public void post_Create_Test() {
        String endpoint = "/api/users";
        String requestBody = readFilesAsString("postCreate");
        Response response = given().header("Content-type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint).then().extract().response();
        assertEquals(response.statusCode(), 201);
        assertEquals(response.jsonPath().get("name"), "morpheus");
        assertEquals(response.jsonPath().get("job"), "leader");
    }

    @Test(priority = 8)
    public void putUpdate_Test() {
        String endpoint = "/api/users/2";
        String requestBody = readFilesAsString("putUpdate");
        Response response = given().header("Content-type", "application/json")
                .and().body(requestBody)
                .and().put(endpoint).then().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().get("job"), "zion resident");
    }

    @Test(priority = 9)
    public void patchUpdate_Test() {
        String endpoint = "/api/users";
        String requestBody = readFilesAsString("patchUpdate");
        Response response = given().header("Content-type", "application/json")
                .and().body(requestBody)
                .and().patch(endpoint).then().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().get("job"), "zion resident111");
    }

    @Test(priority = 10)
    public void delete_Test() {
        String endpoint = "/api/users/2";
        Response response = given().when().delete(endpoint).then().extract().response();
        assertEquals(HttpStatus.SC_NO_CONTENT, response.statusCode());
    }

    @Test(priority = 11)
    public void postRegisterSuccessful_Test() {
        String endpoint = "/api/register";
        String requestBody = readFilesAsString("postRegisterSuccess");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getInt("id"), 4);
        assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test(priority = 12)
    public void postRegisterUnsuccessful_Test() {
        String endpoint = "/api/register";
        String requestBody = readFilesAsString("postRegisterUnsuccess");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        assertEquals(response.statusCode(), 400);
        assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test(priority = 13)
    public void postLoginSuccessful_Test() {
        String endpoint = "/api/login";
        String requestBody = readFilesAsString("postLoginSuccess");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().get("token"), "QpwL5tke4Pnpja7X4");
    }

    @Test(priority = 14)
    public void postLoginUnsuccessful_Test() {
        String endpoint = "/api/login";
        String requestBody = readFilesAsString("postLoginUnsuccess");
        Response response = given().header("Content-Type", "application/json")
                .and().body(requestBody)
                .and().post(endpoint)
                .then().extract().response();
        assertEquals(response.statusCode(), 400);
        assertEquals(response.jsonPath().get("error"), "Missing password");
    }

    @Test(priority = 15)
    public void getDelayedResponse_Test() {
        String endpoint = "/api/users?delay=3";
        given().when().get(endpoint).then().statusCode(200);
        UserList users = given().when().get(endpoint).as(UserList.class);
        Datum userData = new Datum() {{
            setId(1);
            setEmail("george.bluth@reqres.in");
            setFirst_name("George");
            setLast_name("Bluth");
            setAvatar("https://reqres.in/img/faces/1-image.jpg");
        }};
        assertEquals(users.data.get(0), userData);
    }
}