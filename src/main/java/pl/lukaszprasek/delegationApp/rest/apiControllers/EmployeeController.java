package pl.lukaszprasek.delegationApp.rest.apiControllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.delegationApp.application.EmployeeManager;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.mapper.Mapper;
import pl.lukaszprasek.delegationApp.common.requestMapper.RequestEmployeeToDtoMapper;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
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
    private final Mapper mapper;
    private final RequestEmployeeToDtoMapper requestEmployeeToDtoMapper;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeManager employeeManager, Mapper mapper, RequestEmployeeToDtoMapper requestEmployeeToDtoMapper) {
        this.employeeManager = employeeManager;
        this.mapper = mapper;
        this.requestEmployeeToDtoMapper = requestEmployeeToDtoMapper;
    }

    @ApiOperation(value = "Get all employees")
    @GetMapping(path = "/employees", produces = "application/json")
    public List<EmployeeRestModel> getEmployees() {
        return mapper.mapList(employeeManager.getAllEmployees());

    }

    @ApiOperation(value = "Get one employee")
    @GetMapping(path = "/employees/{id}", produces = "application/json")
    public EmployeeRestModel getEmployeeById(@PathVariable("id") Long id) {
        return (EmployeeRestModel) mapper.map(employeeManager.showEmployee(id));

    }

    @ApiOperation(value = "Create employee")
    @PostMapping(path = "/employee/create", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public EmployeeRestModel createEmployee(@Valid @RequestBody CreateEmployeeRequest createEmployeeRequest) {
        EmployeeDto responseEmployeeDTO = employeeManager.createEmployee(
                requestEmployeeToDtoMapper.mapCreateRequestToDTO(createEmployeeRequest));
        return (EmployeeRestModel) mapper.map(responseEmployeeDTO);
    }

    @ApiOperation(value = "Delete employee")
    @DeleteMapping(path = "/employee/delete/{id}", produces = "application/json")
    //@ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<EmployeeEntity> deleteEmployee(@PathVariable("id") Long id) {

        if (employeeManager.deleteEmployee(id) == false) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
    @ApiOperation(value = "assign car to employee")
    @PutMapping(path = "/employee{empId}/assignCar{carId}")
    public EmployeeRestModel assignCarToEmployee(@PathVariable("empId") Long empId,@PathVariable("carId") Long carId ){
        return (EmployeeRestModel) mapper.map(employeeManager.assignCarToEmployee(empId,carId));
    }

    @ApiOperation(value = "Unassign car from employee")
    @PutMapping(path = "/unassignemployee{empId}")
    public EmployeeRestModel unassignCarFromEmployee(@PathVariable("empId")long empId){
        return (EmployeeRestModel) mapper.map(employeeManager.unassignCarFromEmployee(empId));
    }
}
