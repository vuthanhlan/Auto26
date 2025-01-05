package feature.apiTest;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.devtools.v128.fetch.model.AuthChallengeResponse;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static io.restassured.RestAssured.given;

public class PostAPITest {
    @Test
    public void testPostAPI() {
        String requestBody="{\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1\n" +
                "}";

        //Thiết lập requestAssured
        RestAssured.baseURI="https://jsonplaceholder.typicode.com/";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .response();

        //Kiểm tra phản hồi trả về
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();
        System.out.println("ResponseBody is: "+responseBody);

        Assertions.assertEquals(201,statusCode);
        Assertions.assertEquals("foo",response.jsonPath().getString("title"));
        Assertions.assertEquals("bar",response.jsonPath().getString("body"));
        Assertions.assertEquals(1,response.jsonPath().getInt("userId"));

    }


}
