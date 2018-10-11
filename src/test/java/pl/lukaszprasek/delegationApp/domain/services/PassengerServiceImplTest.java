package pl.lukaszprasek.delegationApp.domain.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.mappers.EmployeeMapperFromEntityToDto;
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

    private long numberOfPassengers;
    private long carId;
    private String brand;
    private String model;
    private int seatsNumber;
    private PassengerService passengerService;
    private CarEntity carEntity;
    private EmployeeEntity employeeEntity1;
    private EmployeeEntity employeeEntity2;

    @Mock
    private EmployeeRepository employeeRepository;
    @Mock
    private PassengerRepository passengerRepository;
    @Mock
    private CarRepository carRepository;
    @Mock
    private EmployeeMapperFromEntityToDto employeeMapperFromEntityToDto;

    @Before
    public void setUp() {
        carId = 1;
        brand = "Mercedes";
        model = "Vito";
        seatsNumber = 5;
        passengerService = new PassengerServiceImpl(carRepository, employeeRepository, passengerRepository, employeeMapperFromEntityToDto);
        employeeEntity1 = createEmployeeEntity(1, "Mieczyslaw", "Kanapka");
        employeeEntity2 = createEmployeeEntity(2, "Krzysztof", "Zalewski");
        carEntity = createCarEntity(carId, brand, model, seatsNumber);
        carEntity.setOwner(employeeEntity1);
        carEntity.setPassengerEntities(createPassengerEntityList(carEntity, employeeEntity2));
        when(carRepository.findAll()).thenReturn(createCarEntityList(carEntity));
        when(carRepository.getOne(carId)).thenReturn(carEntity);
        when(passengerRepository.findAll()).thenReturn(carEntity.getPassengerEntities());
    }

    @Test
    public void shouldAddPassengerToSelectedCar() {
        //GIVEN
        numberOfPassengers = 2;
        long empId = 3;

        EmployeeEntity employeeEntity3 = createEmployeeEntity(empId, "Andrzej", "Wozniak");
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity3);
        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(numberOfPassengers);
        //WHEN
        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);

        // THEN
        assertTrue(actual.getBrand().equalsIgnoreCase("Mercedes"));
        assertTrue(actual.getPassengers().get(0)==1);
    }

    @Test
    public void shouldNotAddPassengerWhenGivenEmpIdIsOwnerId() {
        //GIVEN
        numberOfPassengers = 2;
        long empId = 1;
        long carId = 1;

        //WHEN
        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);

        //THEN
        assertNull(actual);
    }

    @Test
    public void shouldNotAddPassengerWhenAllSeatsAreOccupied() {
        //GIVEN
        numberOfPassengers = 4;
        long empId = 3;
        long carId = 1;

        EmployeeEntity employeeEntity3 = createEmployeeEntity(empId, "Andrzej", "Wozniak");
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity3);
        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(numberOfPassengers);
        //WHEN
        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);

        //THEN
        assertNull(actual);
    }

    @Test
    public void shouldNotAddPassengerWhenEmployeeIsAlreadyAssigned() {
        //GIVEN
        numberOfPassengers = 2;
        long empId = 2;
        long carId = 1;

        EmployeeEntity employeeEntity3 = createEmployeeEntity(empId, "Andrzej", "Wozniak");
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity3);
        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(numberOfPassengers);
        //WHEN
        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);

        //THEN
        assertNull(actual);
    }

    private EmployeeEntity createEmployeeEntity(long empId, String name, String surname) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(empId);
        employeeEntity.setName(name);
        employeeEntity.setSurname(surname);
        return employeeEntity;
    }

    private CarEntity createCarEntity(long carId, String brand, String model, int seatsNumber) {
        carEntity = new CarEntity();
        carEntity.setCarId(carId);
        carEntity.setBrand(brand);
        carEntity.setModel(model);
        carEntity.setSeatsNumber(seatsNumber);
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


