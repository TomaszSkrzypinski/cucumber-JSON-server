package pl.akademiaqa.api.employee;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class ReadEmployeeRequest {

    private final BaseRequest baseRequest;

    public Response readAllEmployees(){

        return given()
                .spec(baseRequest.requestSetup())
                .when()
                .get(JsonServerUrl.EMPLOYEES)
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response();
    }
}
