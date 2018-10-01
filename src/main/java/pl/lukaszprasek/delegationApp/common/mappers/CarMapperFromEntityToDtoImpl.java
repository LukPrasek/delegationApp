package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;

import java.util.stream.Collectors;

@Component
public class CarMapperFromEntityToDtoImpl implements CarMapperFromEntityToDto<CarEntity, CarDto> {

    @Override
    public CarDto mapToDto(CarEntity from) {
        return new CarDto.Builder()
                .withCarId(from.getCarId())
                .withBrand(from.getBrand())
                .withModel(from.getModel())
                .withSeatsNumber(from.getSeatsNumber())
                .withOwner(from.getOwner().getEmpId())
                .withPassengers(from.getPassengerEntities().stream()
                        .map(passengerEntity -> passengerEntity.getPassengerId())
                        .collect(Collectors.toList()))
                .build();
    }
}
