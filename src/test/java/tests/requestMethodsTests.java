package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Тесты Request Methods: ")
public class requestMethodsTests {
    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
        @Test
        @DisplayName("Test GET")
        void testGetRequest(){
            given()
                    .queryParam("foo1","bar1")
                    .queryParam("foo2","bar2")

                    .when()
                    .get("/get")

                    .then()
                    .statusCode(200)
                    .body("args.foo1",equalTo("bar1"))
                    .body("args.foo2",equalTo("bar2"));
        }

        @Test
        @DisplayName("Test PostRawText")
        void testPostRawText(){
        String jsonPayLoad = "{\"test\":\"value\"}";
        given()
                .contentType(ContentType.JSON)
                .body(jsonPayLoad)

                .when()
                .post("/post")

                .then()
                .statusCode(200)
                .body("json.test",equalTo("value"));
        }

        @Test
        @DisplayName("Test PostFormData")
        void testPostFormData(){
        given()
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("foo1","bar1")
                .formParam("foo2","bar2")

                .when()
                .post("https://postman-echo.com/post")

                .then()
                .statusCode(200)
                .body("form.foo1",equalTo("bar1"))
                .body("form.foo2",equalTo("bar2"));
        }
        @Test
        @DisplayName("Test PUT")
        void testPutRequest(){
        String payLoad = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(payLoad)

                .when()
                .put("/put")

                .then()
                .statusCode(200)
                .body("data", equalTo(payLoad));
        }
        @Test
        @DisplayName("PATCH")
        void testPatchRequest(){
        String payload = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(payload)

                .when()
                .patch("/patch")

                .then()
                .statusCode(200)
                .body("data",equalTo(payload));
        }

        @Test
        @DisplayName("DELETE")
        void testDeleteRequest(){
        String payload = "This is expected to be sent back as part of response body.";

        given()
                .contentType(ContentType.TEXT)
                .body(payload)

                .when()
                .delete("/delete")

                .then()
                .statusCode(200)
                .body("data",equalTo(payload));
        }

    }