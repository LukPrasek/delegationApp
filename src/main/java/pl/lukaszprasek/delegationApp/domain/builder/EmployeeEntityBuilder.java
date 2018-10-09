package pl.lukaszprasek.delegationApp.domain.builder;

import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.enums.EmployeePosition;

import java.time.LocalDate;

public class EmployeeEntityBuilder implements EntityBuilder<EmployeeEntity> {

    private EmployeeEntity employeeEntity;

    public EmployeeEntityBuilder (String name, String surname, LocalDate birthday,
                                  LocalDate startWorkingDate, String employeePosition){
        employeeEntity=new EmployeeEntity();
        employeeEntity.setName(name);
        employeeEntity.setSurname(surname);
        employeeEntity.setBirthday(birthday);
        employeeEntity.setStartWorkingDate(startWorkingDate);
        employeeEntity.setEmployeePosition(EmployeePosition.valueOf(employeePosition));
    }

    @Override
    public EmployeeEntity build() {
        return employeeEntity;
    }
}
