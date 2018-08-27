package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public List<CarDto> getAlCars() {
        return carRepository.findAll().stream()
                .map(carEntity -> new CarDto.Builder()
                        .withCarId(carEntity.getCarId())
                        .withBrand(carEntity.getBrand())
                        .withModel(carEntity.getModel())
                        .withSeatsNumber(carEntity.getSeatsNumber())
                        .withOwner(carEntity.getOwner().showNameSurnameAndPosition())
                        .withPassengers(carEntity.getPassengerEntities().stream()
                                .map(passengerEntity -> passengerEntity.showPassengerData())
                                .collect(Collectors.joining(",")))
                        .build()).collect(Collectors.toList());


    }

    @Override
    public CarDto getCarById(Long id) {
        CarEntity carEntity = carRepository.getOne(id);
        return new CarDto.Builder()
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber())
                .withOwner(carEntity.getOwner().showNameSurnameAndPosition())
                .withPassengers(carEntity.getPassengerEntities().toString())
                .withCarId(carEntity.getCarId()).build();
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
    public boolean assignOwnerToCar(Long id) {
        return false;
    }

    @Override
    public boolean addPassenger(PassengerDto passengerDto) {
        return false;
    }




}


