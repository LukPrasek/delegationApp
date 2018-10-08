package pl.lukaszprasek.delegationApp.application;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

import java.util.List;

public interface CarManager {
    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto carDto);

    Long deleteCarById(Long id);

    CarDto removePassengerFromSelectedCar(long carId,long passengerId);

    CarDto addPassengerToSelectedCar(long carId, long empId);

    List<EmployeeDto> showPassengersForCar(long carId);

    EmployeeDto showCarOwner(long carId);

    CarDto assignEmployeeToCar(long empId, long carId);

    CarDto unassignEmployeeFromCar(long empId);
}
