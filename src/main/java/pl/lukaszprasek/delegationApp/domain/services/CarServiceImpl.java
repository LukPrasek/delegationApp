package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.dto.PassengerDto;
import pl.lukaszprasek.delegationApp.common.mappers.EmployeeMapperFromEntityToDto;
import pl.lukaszprasek.delegationApp.common.mappers.PassengerMapperFromEntityToDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.entities.builder.CarEntityBuilder;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final EmployeeRepository employeeRepository;
    private final PassengerRepository passengerRepository;
    private final EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto;
    private final PassengerMapperFromEntityToDto passengerMapperFromEntityToDto;

    @Autowired
    public CarServiceImpl(CarRepository carRepository, EmployeeRepository employeeRepository, PassengerRepository passengerRepository, EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto, PassengerMapperFromEntityToDto passengerMapperFromEntityToDto) {
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
        this.passengerRepository = passengerRepository;
        this.employeeMapperFromEntityToDto = employeeMapperFromEntityToDto;
        this.passengerMapperFromEntityToDto = passengerMapperFromEntityToDto;
    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(carEntity -> new CarDto.Builder()
                        .withCarId(carEntity.getCarId())
                        .withBrand(carEntity.getBrand())
                        .withModel(carEntity.getModel())
                        .withSeatsNumber(carEntity.getSeatsNumber())
                        .withOwner((EmployeeDto) employeeMapperFromEntityToDto.mapEmployeeEntityToDt(carEntity.getOwner()))
                        .build()).collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(Long id) {
        CarEntity carEntity = carRepository.getOne(id);
        return new CarDto.Builder()
                .withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber())
                .withOwner((EmployeeDto) employeeMapperFromEntityToDto.mapEmployeeEntityToDt(carEntity.getOwner()))
                .build();

    }

    @Override
    public CarDto createCar(CarDto carDto) {
        CarEntity carEntity = new CarEntityBuilder(carDto.getBrand(), carDto.getModel(), carDto.getSeatsNumber()).build();
        carRepository.save(carEntity);
        return new CarDto.Builder()
                .withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber()).build();
    }

    @Override
    public boolean deleteCarById(Long id) {
        CarEntity carEntity = carRepository.getOne(id);

        if (carEntity == null) {
            return false;//albo try catch??todo
        } else {
            carRepository.deleteById(id);
            return true;
        }
    }


    @Override
    public CarDto addPassengerToSelectedCar(long carId, long empId) {
        CarEntity carEntity = carRepository.getOne(carId);
        EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
        if (((carEntity.getSeatsNumber() - 1) - passengerRepository.countPassengersByCarId(carEntity)) > 0) {
            PassengerEntity passengerEntity = new PassengerEntity();
            passengerEntity.setCar(carEntity);
            passengerEntity.setEmployeeEntity(employeeEntity);
            passengerRepository.save(passengerEntity);
            return new CarDto.Builder()
                    .withCarId(carEntity.getCarId())
                    .withBrand(carEntity.getBrand())
                    .withModel(carEntity.getModel())
                    .withSeatsNumber(carEntity.getSeatsNumber())
                    .build();
        } else {
            return getCarById(carId);
        }

    }

    @Override
    public CarDto removePassengerFromSelectedCar(long carId, long passengerId) {
        passengerRepository.deleteById(passengerId);
        CarEntity carEntity = carRepository.getOne(carId);
        return new CarDto.Builder()
                .withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber())
               // .withPassengers(passengerMapperFromEntityToDto.mapList(passengerRepository.findAll()))
                .build();
    }

    @Override
    public List<PassengerDto> showPassengersForSelectedCar() {
        return null;
    }


}


