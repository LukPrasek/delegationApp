package pl.lukaszprasek.delegationApp.domain.services;

import org.springframework.stereotype.Service;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.common.mappers.EmployeeMapperFromEntityToDto;
import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final CarRepository carRepository;
    private final EmployeeRepository employeeRepository;
    private final PassengerRepository passengerRepository;
    private final EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto;

    public PassengerServiceImpl(CarRepository carRepository, EmployeeRepository employeeRepository, PassengerRepository passengerRepository,
                                EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto) {
        this.carRepository = carRepository;
        this.employeeRepository = employeeRepository;
        this.passengerRepository = passengerRepository;
        this.employeeMapperFromEntityToDto = employeeMapperFromEntityToDto;

    }

    @Override
    public CarDto addPassengerToSelectedCar(long carId, long empId) {
        boolean isGivenEmpIdCarOwner = carRepository.findAll().stream().anyMatch(carEntity1 -> carEntity1.getOwner().getEmpId() == empId);
        boolean isPresent = passengerRepository.findAll().stream().anyMatch(passengerEntity -> passengerEntity.getEmployeeEntity().getEmpId() == empId);
        if ((!isPresent) & (!isGivenEmpIdCarOwner)) {
            EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
            CarEntity carEntity = carRepository.getOne(carId);
            if (addNewPassenger(employeeEntity, carEntity))
                return new CarDto.Builder()
                        .withCarId(carEntity.getCarId())
                        .withOwner(carEntity.getOwner().getEmpId())
                        .withBrand(carEntity.getBrand())
                        .withModel(carEntity.getModel())
                        .withSeatsNumber(carEntity.getSeatsNumber())
                        .withPassengers(mapPassengerListToLong(carEntity))
                        .build();
        }
        return null;
    }

    private boolean addNewPassenger(EmployeeEntity employeeEntity, CarEntity carEntity) {
        if (((carEntity.getSeatsNumber() - 1) - passengerRepository.countPassengersByCarId(carEntity)) > 0) {
            PassengerEntity passengerEntity = new PassengerEntity();
            passengerEntity.setCar(carEntity);
            passengerEntity.setEmployeeEntity(employeeEntity);
            passengerRepository.save(passengerEntity);
            return true;
        }
        return false;
    }

    @Override
    public CarDto removePassengerFromSelectedCar(long carId, long empId) {
        Optional<PassengerEntity> passenger = passengerRepository.findAll().stream().filter(passengerEntity -> passengerEntity.getEmployeeEntity().getEmpId() == empId).findFirst();
        passengerRepository.delete(passenger.get());
        CarEntity carEntity = carRepository.getOne(carId);
        return new CarDto.Builder()
                .withCarId(carEntity.getCarId())
                .withBrand(carEntity.getBrand())
                .withModel(carEntity.getModel())
                .withOwner(carEntity.getOwner().getEmpId())
                .withSeatsNumber(carEntity.getSeatsNumber())
                .withPassengers(mapPassengerListToLong(carEntity))
                .build();
    }

    @Override
    public List<EmployeeDto> showPassengersForCar(long carId) {
        List<EmployeeEntity> employeeEntities = passengerRepository.findPassengersInCar(carRepository.getOne(carId));
        return employeeMapperFromEntityToDto.mapListFromEntitiesToDtos(employeeEntities);
    }

    private List<Long> mapPassengerListToLong(CarEntity carEntity) {
        return carEntity.getPassengerEntities().stream()
                .map(passengerEntity -> passengerEntity.getPassengerId()).collect(Collectors.toList());
    }
}
