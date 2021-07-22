package tests;

import DataProviders.DataProviders;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataDrivenTests extends DataProviders {

    private final String BASE_URL = "http://localhost:3000/";

    @Test(groups = {"POST"}, dataProvider = "DataForPost")
    public void test_01(String firstName, String lastName, int subjectId) {
        baseURI = BASE_URL;

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstName", firstName);
        requestBody.put("lastName", lastName);
        requestBody.put("subjectId", subjectId);

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

    @Test (groups = {"DELETE"}, dataProvider = "DataForDelete")
    public void test_02(int userToDeleteId) {
        baseURI = BASE_URL;

        given()
        .when()
            .delete("/users/" + userToDeleteId)
        .then()
            .statusCode(200)
        .log().all();
    }

    @Test(groups = {"POST"}, dataProvider = "DataFromExcel")
    public void test_03(String firstName, String lastName, double subjectId) {
        baseURI = BASE_URL;

        JSONObject requestBody = new JSONObject();

        requestBody.put("firstName", firstName);
        requestBody.put("lastName", lastName);
        requestBody.put("subjectId", subjectId);

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
}
