package pl.akademiaqa.cucumber.steps.bug;

import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.bug.ReadBugRequest;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.handlers.bug.BugResponse;

@RequiredArgsConstructor
public class ReadBugSteps {

    public final Context context;
    private final ReadBugRequest readBugRequest;

    @Then("I can read updated bug and see status as closed")
    public void i_can_read_updated_bug_and_see_status_as_closed() {

        final int bugId = context.getBugResponse().getId();

        final BugResponse bugResponse = readBugRequest.readBug(bugId);

        Assertions.assertThat(bugResponse.getStatus()).isEqualTo("closed");
    }
}
