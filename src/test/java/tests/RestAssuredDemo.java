package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredDemo {

    @Test (groups = {"GET"})
    public void test_01(){
        int expectedStatusCode = 200;

        Response response = get("https://reqres.in/api/users?page=2");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));

        int actualStatusCode = response.getStatusCode();

        Assert.assertEquals(actualStatusCode,expectedStatusCode);
    }

    @Test (groups = {"GET"})
    public void test_02() {
        baseURI = "https://reqres.in/api";

        given()
            .get("/users?page=2")
        .then()
            .statusCode(200)
            .body("data[1].id",equalTo(8))
        .log().all();
}

    @Test (groups = {"GET"})
    public void test_03() {
        baseURI = "https://reqres.in/api";

        given()
            .get("/users?page=2")
        .then()
            .statusCode(200)
            .body("data[4].first_name", equalTo("George"))
            .body("data.first_name", hasItems("George","Rachel"))
        .log().all();
    }

    @Test (groups = {"POST"})
    public void test_04() {
        baseURI = "https://reqres.in/api";

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Anton");
        requestBody.put("job", "QA");

        given()
            .header("Content-Type","application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(requestBody.toJSONString())
        .when()
            .post("/users")
        .then()
            .statusCode(201)
        .log().all();
    }

    @Test (groups = {"PUT"})
    public void test_05() {
        baseURI = "https://reqres.in/api";

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Anton");
        requestBody.put("job", "QA");

        given()
            .header("Content-Type","application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(requestBody.toJSONString())
        .when()
            .put("/users/2")
        .then()
            .statusCode(200)
        .log().all();
    }

    @Test (groups = {"PATCH"})
    public void test_06() {
        baseURI = "https://reqres.in/api";

        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "Anton");
        requestBody.put("job", "QA");

        given()
            .header("Content-Type","application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(requestBody.toJSONString())
        .when()
            .patch("/users/2")
        .then()
            .statusCode(200)
        .log().all();
    }

    @Test (groups = {"DELETE"})
    public void test_07() {
        baseURI = "https://reqres.in/api";

        given()
        .when()
            .delete("/users/2")
        .then()
            .statusCode(204)
        .log().all();
    }

}
