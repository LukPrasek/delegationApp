package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;

@Component
public class EmployeeMapperFromEntityToDtoImpl implements EmployeeMapperFromEntityToDto<EmployeeEntity, EmployeeDto> {
    private final CarMapperFromEntityToDto carMapperFromEntityToDto;

    @Autowired
    public EmployeeMapperFromEntityToDtoImpl(CarMapperFromEntityToDto carMapperFromEntityToDto) {
        this.carMapperFromEntityToDto = carMapperFromEntityToDto;
    }


    @Override
    public EmployeeDto mapEmployeeEntityToDt(EmployeeEntity from) {
        return new EmployeeDto.Builder()
                .withEmpId(from.getEmpId())
                .withName(from.getName())
                .withSurname(from.getSurname())
                .withEmployeePosition(from.getEmployeePosition().toString())
                .withStartWorkingDay(from.getStartWorkingDate())
                .withBirthday(from.getBirthday())
                .withCarDto((CarDto) carMapperFromEntityToDto.mapToDto(from.getCarEntity())).build();
    }
}
