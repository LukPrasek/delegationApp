package pl.lukaszprasek.delegationApp.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
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
    public List<CarDto> getAlCars() {
        return carService.getAlCars();
    }

    @Override
    public CarDto getCarById(Long id) {
        return carService.getCarById(id);
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        return null;
    }

    @Override
    public boolean deleteCarById(Long id) {
        return false;
    }

    @Override
    public boolean asignOwnerToCar(Long id) {
        return false;
    }

    @Override
    public boolean addPassengerToSelectedCar(PassengerDto passengerDto) {
        return false;
    }
}
