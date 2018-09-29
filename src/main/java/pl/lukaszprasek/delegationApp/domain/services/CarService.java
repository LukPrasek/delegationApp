package pl.lukaszprasek.delegationApp.domain.services;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto carDto);

    boolean deleteCarById(Long id);

    CarDto addPassengerToSelectedCar(long carId, long empId);

    CarDto removePassengerFromSelectedCar(long carId, long passengerId);

    List<PassengerDto> showPassengersForSelectedCar(long carId);

    List<EmployeeDto> showPassengersCar(long carId);

    EmployeeDto showCarOwner(long carId);
}
