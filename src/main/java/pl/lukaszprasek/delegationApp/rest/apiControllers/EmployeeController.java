package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.delegationApp.application.EmployeeManager;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.mappers.EmployeeMapper;
import pl.lukaszprasek.delegationApp.common.requestMapper.RequestEmployeeToDtoMapper;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.rest.request.CreateEmployeeRequest;
import pl.lukaszprasek.delegationApp.rest.response.EmployeeRestModel;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/rest/v1")
@Api("Show message api")
public class EmployeeController {

    private final EmployeeManager employeeManager;
    private final EmployeeMapper employeeMapper;
    private final RequestEmployeeToDtoMapper requestEmployeeToDtoMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeManager employeeManager, EmployeeMapper employeeMapper, RequestEmployeeToDtoMapper requestEmployeeToDtoMapper) {
        this.employeeManager = employeeManager;
        this.employeeMapper = employeeMapper;
        this.requestEmployeeToDtoMapper = requestEmployeeToDtoMapper;
    }

    @ApiOperation(value = "Get all employees")
    @GetMapping(path = "/employees", produces = "application/json")
    public List<EmployeeRestModel> getEmployees() {
        return employeeMapper.mapList(employeeManager.getAllEmployees());

    }

    @ApiOperation(value = "Get one employee")
    @GetMapping(path = "/employees/{id}", produces = "application/json")
    public EmployeeRestModel getEmployeeById(@PathVariable("id") Long id) {
        return (EmployeeRestModel) employeeMapper.map(employeeManager.showEmployee(id));

    }

    @ApiOperation(value = "Create employee")
    @PostMapping(path = "/employee/create", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EmployeeRestModel createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        EmployeeDto responseEmployeeDTO = employeeManager.createEmployee(
                requestEmployeeToDtoMapper.mapCreateRequestToDTO(createEmployeeRequest));
        return (EmployeeRestModel) employeeMapper.map(responseEmployeeDTO);
    }

    @ApiOperation(value = "Delete employee")
    @DeleteMapping(path = "/employee/delete/{id}", produces = "application/json")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {

        if (employeeManager.deleteEmployee(id) == false) {
            return new ResponseEntity<>("Error, cannot delete employee", HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>("Employee is deleted", HttpStatus.OK);
        }
    }

    @ApiOperation(value = "assign car to employee")
    @PutMapping(path = "/employee{empId}/assignCar{carId}")
    public ResponseEntity<EmployeeRestModel> assignCarToEmployee(@PathVariable("empId") Long empId, @PathVariable("carId") Long carId) {
        EmployeeRestModel employeeRestModel = (EmployeeRestModel) employeeMapper.map(employeeManager.assignCarToEmployee(empId, carId));
        return new ResponseEntity<>(employeeRestModel, HttpStatus.OK);
    }

    @ApiOperation(value = "Unassign car from employee")
    @PutMapping(path = "/unassignemployee{empId}")
    public ResponseEntity<EmployeeRestModel> unassignCarFromEmployee(@PathVariable("empId") long empId) {
        EmployeeRestModel employeeRestModel = (EmployeeRestModel) employeeMapper.map(employeeManager.unassignCarFromEmployee(empId));
        return new ResponseEntity<>(employeeRestModel, HttpStatus.OK);
    }
}
