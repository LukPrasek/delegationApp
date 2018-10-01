package pl.lukaszprasek.delegationApp.domain.services;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    Long deleteEmployeeById(Long id);
    EmployeeDto assignCarToEmployee(long empId, long id);
    EmployeeDto unassignCarFromEmployee(long empId);
}

