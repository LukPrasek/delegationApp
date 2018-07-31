package pl.lukaszprasek.delegationApp.application;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

import java.util.List;

public interface EmployeeManager {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto showEmployee(long id);

    EmployeeDto createEmployee(EmployeeDto employeeDto);
}
