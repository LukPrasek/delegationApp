package pl.lukaszprasek.delegationApp.application;

import org.springframework.http.ResponseEntity;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

import java.util.List;

public interface EmployeeManager {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto showEmployee(long id);

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    Long deleteEmployee(Long id);

    EmployeeDto assignCarToEmployee (long empId, long carId);

    EmployeeDto unassignCarFromEmployee (long empId);


}
