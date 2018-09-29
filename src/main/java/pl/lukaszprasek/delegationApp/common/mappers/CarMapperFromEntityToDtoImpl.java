package pl.lukaszprasek.delegationApp.common.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;

@Component
public class CarMapperFromEntityToDtoImpl implements CarMapperFromEntityToDto<CarEntity, CarDto> {
    private final PassengerMapperFromEntityToLongImpl passengerMapperFromEntityToLong;

    @Autowired
    public CarMapperFromEntityToDtoImpl(PassengerMapperFromEntityToLongImpl passengerMapperFromEntityToLong) {
        this.passengerMapperFromEntityToLong = passengerMapperFromEntityToLong;
    }

    @Override
    public CarDto mapToDto(CarEntity from) {
//        if (from == null) {
//            return null;
//        } else {
        System.out.println("numer pasazera********************"+from.getPassengerEntities().get(1).getPassengerId());
        System.out.println("numer pasazera********************"+passengerMapperFromEntityToLong.mapList(from.getPassengerEntities()).get(1).toString());
        return new CarDto.Builder()
                .withCarId(from.getCarId())
                .withBrand(from.getBrand())
                .withModel(from.getModel())
                .withSeatsNumber(from.getSeatsNumber())
                .withOwner(from.getOwner().getEmpId())
                .withPassengers(passengerMapperFromEntityToLong.mapList(from.getPassengerEntities()))
                .build();
        //       }
    }
}
