package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.ListAssert;
import pl.akademiaqa.api.context.Context;
import pl.akademiaqa.api.employee.ReadEmployeeRequest;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.*;

@RequiredArgsConstructor
public class ReadEmployeeSteps {

    private final ReadEmployeeRequest readEmployeeRequest;
    private final Context context;

    List <EmployeeResponse> allEmployeesBeforeCreate;
    private EmployeeResponse employeeResponse;

    @Given("I read all employee")
    public void i_read_all_employee() {
        allEmployeesBeforeCreate = readEmployeeRequest.readAllEmployees();
    }


    @Then("I see created employee on employees list")
    public void i_see_created_employee_on_employees_list() {
        List <EmployeeResponse> allEmployeesAfterCreate = readEmployeeRequest.readAllEmployees();
        assertThat(allEmployeesAfterCreate).hasSizeGreaterThan(allEmployeesBeforeCreate.size());

        EmployeeResponse createEmployeeResponse = context.getEmployeeResponse();
        assertThat(allEmployeesAfterCreate).contains(createEmployeeResponse);
    }

    @Given("The employee with email {string} are exist")
    public void the_employee_with_email_are_exist(String email) {
        List <EmployeeResponse> existingEmployees = readEmployeeRequest.readAllEmployees();

        for (int i = 0; i < existingEmployees.size(); i++) {
            if (existingEmployees.get(i).getEmail().equals(email)) {
                context.setEmployeeResponse(existingEmployees.get(i));
            }
        }
    }

    @Then("This employee email was changed to {string}")
    public void this_employee_has_changed_email(String email) {
        int employeeId = context.getEmployeeResponse().getId();
        List <EmployeeResponse> existingEmployees = readEmployeeRequest.readAllEmployees();

        for (int i = 0; i < existingEmployees.size(); i++) {
            if (Objects.equals(existingEmployees.get(i).getId(), employeeId)) {
                employeeResponse = (existingEmployees.get(i));
            }
        }

        Assertions.assertThat(employeeResponse.getEmail()).isEqualTo(email);
    }
}

