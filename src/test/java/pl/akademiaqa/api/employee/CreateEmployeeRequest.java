package pl.akademiaqa.api.employee;

import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class CreateEmployeeRequest {

    private final BaseRequest baseRequest;

    public Response CreateEmployee() {

        return given()
                .spec(baseRequest.requestSetup())
                .body("")
                .when()
                .post(JsonServerUrl.EMPLOYEES)
                .then()
                .statusCode(201)
                .log().ifError()
                .extract()
                .response();
    }
}
