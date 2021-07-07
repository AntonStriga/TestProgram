package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class SchemaValidate {

    @Test (groups = {"GET"})
    public void test_01() {
        baseURI = "https://reqres.in/api";

        given()
            .get("/users?page=2")
        .then()
            .statusCode(200)
            .assertThat().body(matchesJsonSchemaInClasspath("usersSchema.json"))
        .log().all();

    }
}
