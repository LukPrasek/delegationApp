package pl.lukaszprasek.delegationApp.domain.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.mappers.EmployeeMapperFromEntityToDto;
import pl.lukaszprasek.delegationApp.common.mappers.PassengerMapperFromEntityToDto;

import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;
import pl.lukaszprasek.delegationApp.domain.repositories.CarRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.EmployeeRepository;
import pl.lukaszprasek.delegationApp.domain.repositories.PassengerRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PassengerServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private PassengerRepository passengerRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto;
    @Mock
    private PassengerMapperFromEntityToDto passengerMapperFromEntityToDto;

    private CarService carService;
    private PassengerService passengerService;
    private CarEntity carEntity;
    private CarEntity carEntity2;
    private EmployeeEntity employeeEntity1;
    private EmployeeEntity employeeEntity2;


    @Before
    public void setUp() {
        long numberOfPassengers = 2;
        long carId = 1;
        passengerService = new PassengerServiceImpl(carRepository, employeeRepository,
                passengerRepository, employeeMapperFromEntityToDto, passengerMapperFromEntityToDto);
        employeeEntity1 = createEmployeeEntity(1, "Mieczyslaw", "Kanapka");
        employeeEntity2 = createEmployeeEntity(2, "Krzysztof", "Zalewski");
        carEntity = createCarEntity(1L, "Mercedes", "Vito", 5, employeeEntity1, employeeEntity2);
        //carEntity2 = createCarEntity(2L, "Toyota", "Auris", 5, employeeEntity2);
        //when(carRepository.getOne(carId)).thenReturn(carEntity);
        when(carRepository.findAll()).thenReturn(createCarEntityList(carEntity));
        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(numberOfPassengers);
        when(passengerRepository.findAll()).thenReturn(carEntity.getPassengerEntities());

    }

    private EmployeeEntity createEmployeeEntity(long empId, String name, String surname) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(empId);
        employeeEntity.setName(name);
        employeeEntity.setSurname(surname);
        return employeeEntity;
    }

    @Test
    public void shouldAddPassengerToSelectedCar() {
        //GIVEN
        long empId = 3;
        long carId = 1L;

        EmployeeEntity employeeEntity3 = createEmployeeEntity(empId, "Andrzej", "Wozniak");
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity3);
        when(carRepository.getOne(carId)).thenReturn(carEntity);
        //WHEN
        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);

        // THEN
        assertTrue(actual.getBrand().equalsIgnoreCase("Mercedes"));
        assertTrue(actual.getPassengersId().get(0) == 1L);

    }
//    public CarDto addPassengerToSelectedCar(long carId, long empId) {
//        boolean isGivenEmpIdCarOwner = carRepository.findAll().stream().anyMatch(carEntity1 -> carEntity1.getOwner().getEmpId() == empId);
//        boolean isPresent = passengerRepository.findAll().stream().anyMatch(passengerEntity -> passengerEntity.getEmployeeEntity().getEmpId() == empId);
//        if ((!isPresent) & (!isGivenEmpIdCarOwner)) {
//            EmployeeEntity employeeEntity = employeeRepository.getOne(empId);
//            CarEntity carEntity = carRepository.getOne(carId);
//            if (addNewPassenger(employeeEntity, carEntity))
//                return new CarDto.Builder()
//                        .withCarId(carEntity.getCarId())
//                        .withOwner(carEntity.getOwner().getEmpId())
//                        .withBrand(carEntity.getBrand())
//                        .withModel(carEntity.getModel())
//                        .withSeatsNumber(carEntity.getSeatsNumber())
//                        .withPassengers(mapPassengerListToLong(carEntity))
//                        .build();
//        }
//        return null;
//    }
//
//    private boolean addNewPassenger(EmployeeEntity employeeEntity, CarEntity carEntity) {
//        if (((carEntity.getSeatsNumber() - 1) - passengerRepository.countPassengersByCarId(carEntity)) > 0) {
//            PassengerEntity passengerEntity = new PassengerEntity();
//            passengerEntity.setCar(carEntity);
//            passengerEntity.setEmployeeEntity(employeeEntity);
//            passengerRepository.save(passengerEntity);
//            return true;
//        }
//        return false;
//    }


    //
//    @Test
//    public void shouldNotAddPassengerToSelectedCarWhenEmployeeIsAlreadyAssigned() {
//        //GIVEN
//
//        //WHEN
//        CarDto actual = passengerService.addPassengerToSelectedCar(carId, 2);
//
//        //THEN
//        assertNull(actual);
//    }
//
//    @Test
//    public void shouldNotAddPassengerWhenAllSeatsAreOccupied() {
//        //GIVEN
//        EmployeeEntity employeeEntity1 = createEmployeeEntity(1, "Andrzej", "Wozniak");
//        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity1);
//        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(4L);
//
//        //WHEN
//        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);
//
//        //THEN
//        assertNull(actual);
//    }
//
    private CarEntity createCarEntity(long carId, String brand, String model, int seatsNumber, EmployeeEntity owner, EmployeeEntity passenger) {
        carEntity = new CarEntity();
        carEntity.setCarId(carId);
        carEntity.setBrand(brand);
        carEntity.setModel(model);
        carEntity.setSeatsNumber(seatsNumber);
        carEntity.setPassengerEntities(createPassengerEntityList(carEntity, passenger));
        carEntity.setOwner(owner);
        return carEntity;
    }

    private List<PassengerEntity> createPassengerEntityList(CarEntity carEntity, EmployeeEntity employeeEntity) {
        List<PassengerEntity> list = new ArrayList<>();
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setPassengerId(1L);
        passengerEntity.setEmployeeEntity(employeeEntity);
        passengerEntity.setCar(carEntity);
        list.add(passengerEntity);
        return list;
    }

    private List<CarEntity> createCarEntityList(CarEntity carEntity) {
        List<CarEntity> carEntities = new ArrayList<>();
        carEntities.add(carEntity);
        return carEntities;
    }
}


