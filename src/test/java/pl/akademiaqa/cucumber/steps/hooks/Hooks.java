package pl.akademiaqa.cucumber.steps.hooks;

import io.cucumber.java.After;
import io.restassured.response.Response;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import pl.akademiaqa.api.bug.DeleteBugRequest;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.DeleteEmployeeRequest;
import pl.akademiaqa.handlers.bug.BugResponse;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
public class Hooks {

    private final Context context;
    private final DeleteEmployeeRequest deleteEmployeeRequest;
    private final DeleteBugRequest deleteBugRequest;
    private final BugResponse bugResponse;

    @After(value="@cleanEmployees")
    public void cleanEmployeesAfterScenario(){

        int employeeId = context.getEmployeeResponse().getId();

        Response response = deleteEmployeeRequest.deleteEmployee(employeeId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
    }

    @After(value="@cleanFewBugs")
    public void cleanFewBugsAfterScenario(){

        List <BugResponse> bugsResponsesList = context.getBugResponseList();

        for (BugResponse bug : bugsResponsesList) {
            Response response = deleteBugRequest.deleteBug(bug.getId());
            assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);
        }
    }

    @After(value="@cleanOneBug")
    public void cleanOneBugAfterScenario(){

        int bugId = context.getBugResponse().getId();

        Response response = deleteBugRequest.deleteBug(bugId);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.SC_OK);

    }
}
