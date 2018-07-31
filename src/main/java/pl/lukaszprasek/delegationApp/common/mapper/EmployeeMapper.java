package pl.lukaszprasek.delegationApp.common.mapper;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;

public class EmployeeMapper implements Mapper<EmployeeEntity, EmployeeDto> {
    @Override
    public EmployeeDto map(EmployeeEntity from) {

        return new EmployeeDto(from.getEmpId(), from.getName(), from.getSurname());//from.getBirthday().toString(), from.getSwd().toString()
    }
}
