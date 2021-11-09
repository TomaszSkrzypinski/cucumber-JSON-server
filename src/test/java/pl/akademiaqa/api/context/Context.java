package pl.akademiaqa.api.context;

import lombok.Data;
import pl.akademiaqa.dto.BugDto;
import pl.akademiaqa.handlers.bug.BugResponse;
import pl.akademiaqa.handlers.employee.EmployeeResponse;

@Data
public class Context {

    private EmployeeResponse employeeResponse;
    private BugResponse bugResponse;
    private BugDto bug;
}
