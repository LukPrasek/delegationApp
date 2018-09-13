package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmployeeMapperFromEntityToDtoImpl implements EmployeeMapperFromEntityToDto<EmployeeEntity, EmployeeDto> {
    //private final CarMapperFromEntityToDto carMapperFromEntityToDto;
//    private CarMapperFromEntityToDto carMapperFromEntityToDto;
//
//
//    @Autowired
//    public void setCarMapperFromEntityToDto(CarMapperFromEntityToDto carMapperFromEntityToDto) {
//        this.carMapperFromEntityToDto = carMapperFromEntityToDto;
//    }
//    public EmployeeMapperFromEntityToDtoImpl(CarMapperFromEntityToDto carMapperFromEntityToDto) {
//        this.carMapperFromEntityToDto = carMapperFromEntityToDto;
//    }


    @Override
    public EmployeeDto mapEmployeeEntityToDto(EmployeeEntity from) {
        if (from==null) return null;
        return new EmployeeDto.Builder()
                .withEmpId(from.getEmpId())
                .withName(from.getName())
                .withSurname(from.getSurname())
                .withEmployeePosition(from.getEmployeePosition().toString())
                .withStartWorkingDay(from.getStartWorkingDate())
                .withBirthday(from.getBirthday())
                //.withCarDto((CarDto) carMapperFromEntityToDto.mapToDto(from.getCarEntity()))
                .build();
    }

    @Override
    public List<EmployeeDto> mapListFromEntitiesToDtos(List<EmployeeEntity> from) {
        return from.stream().map(this::mapEmployeeEntityToDto).collect(Collectors.toList());
    }
}
