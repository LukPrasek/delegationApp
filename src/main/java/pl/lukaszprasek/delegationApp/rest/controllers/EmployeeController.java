package pl.lukaszprasek.delegationApp.rest.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.services.EmployeeService;

@RestController
@EnableAsync
@Api("Show message api")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @ApiOperation(value="Get all persons")
    @GetMapping(path = "/employees", produces = "application/json")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("employee", employeeService.getAllEmployees().get(0).getName());
        System.out.println(employeeService.getAllEmployees().get(0).getName());
        System.out.println("****************++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return "index";

    }
}
