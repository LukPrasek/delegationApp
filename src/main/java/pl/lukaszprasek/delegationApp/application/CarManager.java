package pl.lukaszprasek.delegationApp.application;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;

import java.util.List;

public interface CarManager {
    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto carDto);

    boolean deleteCarById(Long id);

    CarDto removePassengerFromSelectedCar(long carId, long empId);

    CarDto addPassengerToSelectedCar(long carId, long empId);
}
