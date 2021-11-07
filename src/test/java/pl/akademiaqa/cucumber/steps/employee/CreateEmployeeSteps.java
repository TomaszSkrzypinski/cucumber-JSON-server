package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.CreateEmployeeRequest;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.handlers.employee.EmployeePayload;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

@RequiredArgsConstructor
public class CreateEmployeeSteps {

    private final CreateEmployeeRequest createEmployeeRequest;
    private final EmployeePayload employeePayload;
    private final Context context;

    @When("I create new employee")
    public void i_create_new_employee() {
        EmployeeDto defaultEmployee = employeePayload.getDefaultEmployee();
        EmployeeResponse employeeResponse = createEmployeeRequest.createEmployee(defaultEmployee);

        Assertions.assertThat(employeeResponse.getFirstName()).isEqualTo(defaultEmployee.getFirstName());
        Assertions.assertThat(employeeResponse.getLastName()).isEqualTo(defaultEmployee.getLastName());
        Assertions.assertThat(employeeResponse.getFirstName()).isEqualTo(defaultEmployee.getFirstName());

        context.setEmployeeResponse(employeeResponse);
    }
}
