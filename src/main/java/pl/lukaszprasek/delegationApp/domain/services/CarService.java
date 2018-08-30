package pl.lukaszprasek.delegationApp.domain.services;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;

import java.util.List;

public interface CarService {
    List<CarDto> getAllCars();

    CarDto getCarById(Long id);

    CarDto createCar(CarDto carDto);

    boolean deleteCarById(Long id);

    boolean assignOwnerToCar(Long id);

    boolean addPassenger(PassengerDto passengerDto);
}
