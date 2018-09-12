package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PassengerMapperFromEntityToDtoImpl implements PassengerMapperFromEntityToDto<PassengerEntity, PassengerDto> {
    @Override
    public PassengerDto mapPassengerEntityToDto(PassengerEntity from) {

        return new PassengerDto.Builder()
                .withPassengerID(from.getPassengerId())
                .withEmployeeDto(from.getEmployeeEntity())
                .build();
    }

    @Override
    public List<PassengerDto> mapList(List<PassengerEntity> from) {
        return from.stream().map(this::mapPassengerEntityToDto).collect(Collectors.toList());
    }


}
