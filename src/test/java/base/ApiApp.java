package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiApp {

	public static Response get(String endpoint) {
        return RestAssured.given()
                .spec(RestAssured.requestSpecification) // Use the predefined specification
//                .queryParams(queryParams)
                .when()
                .get(endpoint);
    }

    // Generic POST request with JSON body
    public static Response post(String endpoint, Object requestBody) {
        return RestAssured.given()
                .spec(RestAssured.requestSpecification) // Use the predefined specification
                .body(requestBody)
                .when()
                .post(endpoint);
    }

}
