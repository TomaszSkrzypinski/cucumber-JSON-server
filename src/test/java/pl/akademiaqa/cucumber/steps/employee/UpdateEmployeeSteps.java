package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.UpdateEmployeeRequest;
import pl.akademiaqa.dto.PatchEmployeeDto;
import pl.akademiaqa.handlers.employee.EmployeePayload;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

@RequiredArgsConstructor
public class UpdateEmployeeSteps {

    private final UpdateEmployeeRequest updateEmployeeRequest;
    private final EmployeePayload employeePayload;
    private final Context context;

    @When("I change this employee email to {string}")
    public void i_change_this_employee_email_to(String email) {

        PatchEmployeeDto patchEmployee = employeePayload.getPatchEmployee(email);
        int employeeId = context.getEmployeeResponse().getId();

        EmployeeResponse employeeResponse = updateEmployeeRequest.updateEmployee(patchEmployee, employeeId);

        Assertions.assertThat(employeeResponse.getFirstName()).isEqualTo(context.getEmployeeResponse().getFirstName());
        Assertions.assertThat(employeeResponse.getLastName()).isEqualTo(context.getEmployeeResponse().getLastName());
        Assertions.assertThat(employeeResponse.getEmail()).isEqualTo(email);
    }
}
