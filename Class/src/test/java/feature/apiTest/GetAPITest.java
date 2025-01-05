package feature.apiTest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetAPITest {

    @Test
    public void getAPITest() {
        String page="2";
        String tolken = "uiopojhvbnm";
        RestAssured.baseURI = "https://reqres.in/api";

        Response response = given()
                .queryParam("page",page)
                .header("Authorization","Bearer "+tolken)
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .extract()
                .response();

        int statusCode=response.getStatusCode();
        String body=response.getBody().asString();
        System.out.println(body);

        Assertions.assertEquals(200,statusCode);
        Assertions.assertEquals(2,response.jsonPath().getInt("page"));
        Assertions.assertEquals(6,response.jsonPath().getInt("per_page"));
        Assertions.assertEquals(12,response.jsonPath().getInt("total"));
        Assertions.assertEquals(2,response.jsonPath().getInt("total_pages"));

        int totalUsers=response.jsonPath().getList("data").size();
        Assertions.assertEquals(6,totalUsers);

        //Kiểm tra thông tin của người dùng
        Assertions.assertEquals(7,response.jsonPath().getInt("data[0].id"));
        Assertions.assertEquals("michael.lawson@reqres.in",response.jsonPath().getString("data[0].email"));
        Assertions.assertEquals("Michael",response.jsonPath().getString("data[0].first_name"));
        Assertions.assertEquals("Lawson",response.jsonPath().getString("data[0].last_name"));
        Assertions.assertEquals("https://reqres.in/img/faces/7-image.jpg",response.jsonPath().getString("data[0].avatar"));
    }
}
