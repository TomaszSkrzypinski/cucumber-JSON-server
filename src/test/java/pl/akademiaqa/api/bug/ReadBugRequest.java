package pl.akademiaqa.api.bug;

import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.BaseRequest;
import pl.akademiaqa.handlers.bug.BugResponse;
import pl.akademiaqa.handlers.bug.ReadBugResponse;
import pl.akademiaqa.url.JsonServerUrl;

import static io.restassured.RestAssured.given;

@RequiredArgsConstructor
public class ReadBugRequest {

    private final BaseRequest baseRequest;

    public BugResponse readBug(int bugId) {

        return given()
                .spec(baseRequest.requestSetup())
                .when()
                .get(JsonServerUrl.getBugPath(bugId))
                .then()
                .statusCode(200)
                .log().ifError()
                .extract()
                .response()
                .as(ReadBugResponse.class);
    }
}
