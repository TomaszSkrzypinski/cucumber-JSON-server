package pl.akademiaqa.handlers.employee;

import lombok.AllArgsConstructor;
import pl.akademiaqa.dto.AddressDto;
import pl.akademiaqa.dto.CompanyDto;
import pl.akademiaqa.dto.EmployeeDto;
import pl.akademiaqa.dto.PatchEmployeeDto;

@AllArgsConstructor
public class EmployeePayload {

    private EmployeeDto employee;
    private AddressDto address;
    private CompanyDto company;
    private PatchEmployeeDto patchEmployee;

    public EmployeeDto getDefaultEmployee() {

        address.setStreet("Sezamkowa");
        address.setSuite("12");
        address.setCity("New York");
        address.setZipcode("123-321");

        company.setCompanyName("Akademia QA");
        company.setTaxNumber("666-666-666");
        company.setCompanyPhone("123-456-789");

        employee.setFirstName("Joe");
        employee.setLastName("Lemoniadowy");
        employee.setUsername("lemoniadowyjoe");
        employee.setEmail("lemoniadowy@wp.pl");
        employee.setPhone("987654321");
        employee.setWebsite("lemoniadowy@joe.com");
        employee.setRole("qa");
        employee.setType("b2b");
        employee.setAddress(address);
        employee.setCompany(company);

        return employee;
    }

    public PatchEmployeeDto getPatchEmployee(String email) {
        patchEmployee.setEmail(email);

        return patchEmployee;
    }
}
