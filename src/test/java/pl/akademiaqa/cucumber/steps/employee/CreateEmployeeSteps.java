package pl.akademiaqa.cucumber.steps.employee;

import io.cucumber.java.en.When;
import lombok.RequiredArgsConstructor;
import pl.akademiaqa.api.employee.CreateEmployeeRequest;

@RequiredArgsConstructor
public class CreateEmployeeSteps {

    private final CreateEmployeeRequest createEmployeeRequest;

    @When("I create new employee")
    public void i_create_new_employee() {

    }
}
