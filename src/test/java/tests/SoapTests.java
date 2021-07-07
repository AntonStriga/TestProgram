package tests;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SoapTests {

    @Test
    public void test_01() throws IOException {
        baseURI = "http://www.dneonline.com";

        File file = new File("src/test/resources/soapFile.xml");
        if(file.exists()) {
            System.out.println(">> File Exists");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream,"UTF-8");

        given()
            .contentType("text/xml")
            .accept(ContentType.XML)
            .body(requestBody)
        .when()
            .post("/calculator.asmx")
        .then()
            .statusCode(200)
        .log().all()
        .and()
            .body("//*:AddResult.text()",equalTo("5"));
    }

    @Test
    public void test_02() throws IOException {
        baseURI = "http://www.dneonline.com";

        File file = new File("src/test/resources/soapFile.xml");
        if(file.exists()) {
            System.out.println(">> File Exists");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream,"UTF-8");

        given()
            .contentType("text/xml")
            .accept(ContentType.XML)
            .body(requestBody)
        .when()
            .post("/calculator.asmx")
        .then()
            .statusCode(200)
        .log().all()
        .and()
            .assertThat().body(matchesXsdInClasspath("soapSchema.xsd"));
    }
}
