package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
@Component
public class CarMapperFromEntityToDtoImpl implements CarMapperFromEntityToDto<CarEntity, CarDto> {
    @Override
    public CarDto mapToDto(CarEntity from) {
        if (from == null) {
            return null;
        } else {
            return new CarDto.Builder().withCarId(from.getCarId())
                    .withBrand(from.getBrand())
                    .withModel(from.getModel())
                    .withSeatsNumber(from.getSeatsNumber())
                    .build();
        }
    }
}
