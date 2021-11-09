package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.Given;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.bug.CreateBugRequest;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugPayload;
import pl.akademiaqa.handlers.bug.BugResponse;

@RequiredArgsConstructor
public class CreateBugSteps {

    private final CreateBugRequest createBugRequest;
    private final BugPayload bugPayload;
    private final Context context;

    @Given("bug already exist")
    public void bug_already_exist() {

        BugDto defaultBug = bugPayload.getDefaultBug();

        BugResponse bugResponse = createBugRequest.createBug(defaultBug);

        Assertions.assertThat(bugResponse.getTitle()).isEqualTo(defaultBug.getTitle());
        Assertions.assertThat(bugResponse.getDescription()).isEqualTo(defaultBug.getDescription());
        Assertions.assertThat(bugResponse.getEmployeeId()).isEqualTo(defaultBug.getEmployeeId());
        Assertions.assertThat(bugResponse.getStatus()).isEqualTo(defaultBug.getStatus());

        context.setBugResponse(bugResponse);
        context.setBug(defaultBug);
    }
}
