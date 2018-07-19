package pl.lukaszprasek.delegationApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import pl.lukaszprasek.delegationApp.services.EmployeeService;

@Controller
// @RestController
@EnableAsync

@RequestMapping(value = "/map")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/")

    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        model.addAttribute("employee", employeeService.getAllEmployees().get(0).getName());
        System.out.println(employeeService.getAllEmployees().get(0).getName());
        System.out.println("****************++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return "index";
//    public String getEmployees() {
//        System.out.println("dupaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
//        return "Dupaaaaaaaaaaaaa";
    }

//    @GetMapping("/{id}")
//    //@ResponseBody
//    public String getEmployee(@PathVariable("id") int id, Model model) {
//        model.addAttribute("employee", employeeRepository.findById(id));
//        return "index";
//    }

//    @GetMapping("/map")
//
//    public String index(Model model) {
//        List<String> names = Arrays.asList("Jacek", "Placek");
//        model.addAttribute("name", "Lukasz");
//        model.addAttribute("lastname", "Prasek");
//        return "index";
//    }
}
