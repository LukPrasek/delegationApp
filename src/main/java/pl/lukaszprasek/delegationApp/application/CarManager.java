package pl.lukaszprasek.delegationApp.application;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

import java.util.List;

public interface CarManager {
    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto carDto);

    boolean deleteCarById(Long id);

    CarDto removePassengerFromSelectedCar(long carId,long passengerId);

    CarDto addPassengerToSelectedCar(long carId, long empId);

    List<PassengerDto> showPassengersForSelectedCar(long carId);
}
