package pl.lukaszprasek.delegationApp.services;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    boolean deleteEmployeeById(Long id);


}
