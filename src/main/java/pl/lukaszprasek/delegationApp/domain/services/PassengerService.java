package pl.lukaszprasek.delegationApp.domain.services;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

import java.util.List;

public interface PassengerService {
    CarDto addPassengerToSelectedCar(long carId, long empId);

    CarDto removePassengerFromSelectedCar(long carId, long empId);

    List<EmployeeDto> showPassengersForCar(long carId);
}
