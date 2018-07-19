package pl.lukaszprasek.delegationApp.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.models.EmployeeEntity;
import pl.lukaszprasek.delegationApp.repositories.EmployeeRepository;

import java.util.List;

@Data
@Service
@Profile({"activeProfile"})
public class EmployeeService {

    @Autowired
   EmployeeRepository employeeRepository;


    public List<EmployeeEntity> getAllEmployees() {

        return (List<EmployeeEntity>) employeeRepository.findAll();
    }


}
