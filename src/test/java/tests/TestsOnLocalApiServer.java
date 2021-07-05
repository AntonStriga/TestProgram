package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class TestsOnLocalApiServer {

    private final static String BASE_URL = "http://localhost:3000/";

    @Test (groups = {"GET"})
    public void test_01() {
        baseURI = BASE_URL;

        given().
            get("/users").
        then().
            statusCode(200).
        log().all();
    }

    @Test (groups = {"POST"})
    public void test_02() {
        baseURI = BASE_URL;

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstName", "Piter");
        requestBody.put("lastName", "Pen");
        requestBody.put("subjectId", 2);

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
    public void test_03() {
        baseURI = BASE_URL;

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstName", "Abraham");
        requestBody.put("lastName", "Lincoln");
        requestBody.put("subjectId", 2);

        given()
            .header("Content-Type","application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(requestBody.toJSONString())
        .when()
            .put("/users/4")
        .then()
            .statusCode(200)
        .log().all();
    }

    @Test (groups = {"PATCH"})
    public void test_04() {
        baseURI = BASE_URL;

        JSONObject requestBody = new JSONObject();

        requestBody.put("lastName", "Jeckson");

        given()
            .header("Content-Type","application/json")
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(requestBody.toJSONString())
        .when()
            .patch("/users/4")
        .then()
            .statusCode(200)
        .log().all();
    }

    @Test (groups = {"DELETE"})
    public void test_05() {
        baseURI = BASE_URL;

        given()
        .when()
            .delete("/users/4")
        .then()
            .statusCode(200)
        .log().all();
    }
}
