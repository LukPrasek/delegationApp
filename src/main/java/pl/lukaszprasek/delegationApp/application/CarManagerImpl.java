package pl.lukaszprasek.delegationApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.services.CarService;
import pl.lukaszprasek.delegationApp.domain.services.PassengerService;

import java.util.List;

@Service
public class CarManagerImpl implements CarManager {

    private CarService carService;
    private PassengerService passengerService;

    @Autowired
    public CarManagerImpl(CarService carService, PassengerService passengerService
    ) {
        this.carService = carService;
        this.passengerService = passengerService;
    }

    @Override
    public List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @Override
    public CarDto getCarById(Long id) {
        return carService.getCarById(id);
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        return carService.createCar(carDto);
    }

    @Override
    public Long deleteCarById(Long id) {
        return carService.deleteCarById(id);
    }

    @Override
    public CarDto removePassengerFromSelectedCar(long carId, long passengerId) {
        return passengerService.removePassengerFromSelectedCar(carId, passengerId);
    }

    @Override
    public CarDto addPassengerToSelectedCar(long carId, long empId) {
        return passengerService.addPassengerToSelectedCar(carId, empId);
    }

    @Override
    public List<EmployeeDto> showPassengersForCar(long carId) {
        return passengerService.showPassengersForCar(carId);
    }

    @Override
    public EmployeeDto showCarOwner(long carId) {
        return carService.showCarOwner(carId);
    }

    @Override
    public CarDto assignEmployeeToCar(long empId, long carId) {
        return carService.assignEmployeeToCar(empId, carId);
    }

    @Override
    public CarDto unassignEmployeeFromCar(long carId) {
        return carService.unassignEmployeeFromCar(carId);
    }

}
