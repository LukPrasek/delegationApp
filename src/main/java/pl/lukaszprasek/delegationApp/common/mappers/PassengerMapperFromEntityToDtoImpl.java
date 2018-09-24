package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassengerMapperFromEntityToDtoImpl implements PassengerMapperFromEntityToDto<PassengerEntity, PassengerDto> {


    //    private EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto;
//    @Autowired
//    public void setEmployeeMapperFromEntityToDto(EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto) {
//        this.employeeMapperFromEntityToDto = employeeMapperFromEntityToDto;
//    }
    private final EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto;
    private CarMapperFromEntityToDto carMapperFromEntityToDto;
    @Autowired
    public void setCarMapperFromEntityToDto(CarMapperFromEntityToDto carMapperFromEntityToDto) {
        this.carMapperFromEntityToDto = carMapperFromEntityToDto;
    }

    @Autowired
    public PassengerMapperFromEntityToDtoImpl(EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto) {
        this.employeeMapperFromEntityToDto = employeeMapperFromEntityToDto;

    }

    @Override
    public PassengerDto mapPassengerEntityToDto(PassengerEntity from) {
        return new PassengerDto.Builder()
                .withPassengerID(from.getPassengerId())
                .withEmployeeDto(employeeMapperFromEntityToDto.mapEmployeeEntityToDto(from.getEmployeeEntity()))
                //.withCarDto((CarDto) carMapperFromEntityToDto.mapToDto(from.getCar()))
                .build();
    }

    @Override
    public List<PassengerDto> mapList(List<PassengerEntity> from) {
        return from.stream()
                .map(this::mapPassengerEntityToDto)
                .collect(Collectors.toList());
    }
}
