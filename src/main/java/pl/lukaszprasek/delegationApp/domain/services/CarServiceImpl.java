package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.builder.CarEntityBuilder;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final EmployeeRepository employeeRepository;


    @Autowired
    public CarServiceImpl(CarRepository carRepository, EmployeeRepository employeeRepository) {
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;

    }

    @Override
    public List<CarDto> getAllCars() {
        return carRepository.findAll().stream()
                .map(carEntity -> new CarDto.Builder()
                        .withCarId(carEntity.getCarId())
                        .withBrand(carEntity.getBrand())
                        .withModel(carEntity.getModel())
                        .withSeatsNumber(carEntity.getSeatsNumber())
                        .withOwner(carEntity.getOwner() != null ? carEntity.getOwner().getEmpId() : 0)
                        .withPassengers(mapPassengerListToLong(carEntity))
                        .build()).collect(Collectors.toList());
    }

    @Override
    public CarDto getCarById(Long id) {
        Optional<CarEntity> carEntity = carRepository.findById(id);
        return new CarDto.Builder()
                .withCarId(carEntity.get().getCarId())
                .withBrand(carEntity.get().getBrand())
                .withModel(carEntity.get().getModel())
                .withSeatsNumber(carEntity.get().getSeatsNumber())
                .withOwner(carEntity.get().getOwner() != null ? carEntity.get().getOwner().getEmpId() : 0)
                .withPassengers(mapPassengerListToLong(carEntity.get()))
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
    public Long deleteCarById(Long id) {
        carRepository.deleteById(id);
        return id;
    }

    @Override
    public EmployeeDto showCarOwner(long carId) {
        CarEntity carEntity1 = carRepository.getOne(carId);
        EmployeeEntity employeeEntity1 = employeeRepository.getOne(carEntity1.getOwner().getEmpId());
        return new EmployeeDto.Builder()
                .withName(employeeEntity1.getName())
                .withSurname(employeeEntity1.getSurname())
                .withBirthday(employeeEntity1.getBirthday())
                .withStartWorkingDay(employeeEntity1.getStartWorkingDate())
                .withEmployeePosition(employeeEntity1.getEmployeePosition().toString())
                .withEmpId(employeeEntity1.getEmpId())
                .withCarDto(carId)
                .build();
    }

    @Override
    public CarDto assignEmployeeToCar(long empId, long carId) {
        EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
        CarEntity carEntity = carRepository.getOne(carId);
        carEntity.setOwner(employeeEntity);
        carRepository.save(carEntity);
        return new CarDto.Builder().withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber())
                .withOwner(carEntity.getOwner().getEmpId())
                .withPassengers(carEntity.getPassengerEntities().stream().map(PassengerEntity::getPassengerId).collect(Collectors.toList()))
                .build();
    }

    @Override
    public CarDto unassignEmployeeFromCar(long carId) {
        CarEntity carEntity = carRepository.getOne(carId);
        carEntity.setOwner(null);
        carRepository.save(carEntity);
        return new CarDto.Builder().withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withSeatsNumber(carEntity.getSeatsNumber())
                .withPassengers(mapPassengerListToLong(carEntity))
                .build();
    }

    private List<Long> mapPassengerListToLong(CarEntity carEntity) {
        return carEntity.getPassengerEntities().stream()
                .map(passengerEntity -> passengerEntity.getPassengerId()).collect(Collectors.toList());
    }
}



