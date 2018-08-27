package pl.lukaszprasek.delegationApp.application;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;

import java.util.List;

public interface CarManager {
    List<CarDto> getAlCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto carDto);

    boolean deleteCarById(Long id);

    boolean asignOwnerToCar(Long id);

    boolean addPassengerToSelectedCar(PassengerDto passengerDto);
}
