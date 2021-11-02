package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.employee.ReadEmployeeRequest;

@RequiredArgsConstructor
public class ReadEmployeeSteps {

    private final ReadEmployeeRequest readEmployeeRequest;

    @Given("I read all employee")
    public void i_read_all_employee() {
        readEmployeeRequest.readAllEmployees();
    }

    @Then("I see created employee on employees list")
    public void i_see_created_employee_on_employees_list() {
        readEmployeeRequest.readAllEmployees();
    }
}
