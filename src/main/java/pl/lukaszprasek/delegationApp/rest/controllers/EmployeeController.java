package pl.lukaszprasek.delegationApp.rest.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.services.EmployeeService;
import pl.lukaszprasek.delegationApp.services.EmployeeServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/rest/v1")
@Api("Show message api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @ApiOperation(value = "Get all employees")
    @GetMapping(path = "/employees", produces = "application/json")
    public List<EmployeeDto> getEmployees() {
        System.out.println("****************++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return employeeService.getAllEmployees();

    }

    @ApiOperation(value = "Get one employee")
    @GetMapping(path = "/employees/{id}", produces = "application/json")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) {
              return employeeService.getEmployeeById(id);

    }
}
