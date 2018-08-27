package pl.lukaszprasek.delegationApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.services.EmployeeService;

import java.util.List;

@Service
public class EmployeeManagerImpl implements EmployeeManager {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeManagerImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @Override
    public EmployeeDto showEmployee(long id) {
        return employeeService.getEmployeeById(id);
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        return employeeService.createEmployee(employeeDto);
    }

    @Override
    public Boolean deleteEmployee(Long id) {
        return employeeService.deleteEmployeeById(id);
    }

    @Override
    public EmployeeDto assignCarToEmployee(long empId, long carId) {
        return employeeService.assignCarToEmployee(empId,carId);
    }

    @Override
    public EmployeeDto unassignCarFromEmployee(long empId) {
        return employeeService.unassignCarFromEmployee(empId);
    }

}
