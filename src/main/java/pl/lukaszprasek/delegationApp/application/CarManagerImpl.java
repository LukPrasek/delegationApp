package pl.lukaszprasek.delegationApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.services.CarService;

import java.util.List;

@Service
public class CarManagerImpl implements CarManager {

    private CarService carService;

    @Autowired
    public CarManagerImpl(CarService carService) {
        this.carService = carService;
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
    public boolean deleteCarById(Long id) {
        return carService.deleteCarById(id);
    }

    @Override
    public CarDto removePassengerFromSelectedCar(long carId,long passengerId) {
        return carService.removePassengerFromSelectedCar(carId, passengerId);
    }

    @Override
    public CarDto addPassengerToSelectedCar(long carId, long empId) {
        return carService.addPassengerToSelectedCar(carId, empId);
    }

    @Override
    public List<PassengerDto> showPassengersForSelectedCar(long carId) {
        return carService.showPassengersForSelectedCar(carId);
    }

    @Override
    public List<EmployeeDto> showPassengersForCar(long carId) {
        return carService.showPassengersCar(carId);
    }

    @Override
    public EmployeeDto showCarOwner(long carId) {
        return carService.showCarOwner(carId);
    }

}
