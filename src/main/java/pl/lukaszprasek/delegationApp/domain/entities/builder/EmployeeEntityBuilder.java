package pl.lukaszprasek.delegationApp.domain.entities.builder;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;

import java.time.LocalDate;

public class EmployeeEntityBuilder implements EntityBuilder<EmployeeEntity> {

    private EmployeeEntity employeeEntity;

    public EmployeeEntityBuilder (String name, String surname, LocalDate birthday, LocalDate startWorkingDate){
        employeeEntity=new EmployeeEntity();
        employeeEntity.setName(name);
        employeeEntity.setSurname(surname);
        employeeEntity.setBirthday(birthday);
        employeeEntity.setStartWorkingDate(startWorkingDate);
    }

    @Override
    public EmployeeEntity build() {
        return employeeEntity;
    }
}
