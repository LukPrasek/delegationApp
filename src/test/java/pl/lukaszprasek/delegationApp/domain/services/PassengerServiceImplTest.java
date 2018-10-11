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
    private TestHelperClass testHelperClass;
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
        testHelperClass = new TestHelperClass();
        passengerService = new PassengerServiceImpl(carRepository, employeeRepository, passengerRepository, employeeMapperFromEntityToDto);
        employeeEntity1 = testHelperClass.createEmployeeEntity(1, "Mieczyslaw", "Kanapka");
        employeeEntity2 = testHelperClass.createEmployeeEntity(2, "Krzysztof", "Zalewski");
        carEntity = testHelperClass.createCarEntity(carId, brand, model, seatsNumber);
        carEntity.setOwner(employeeEntity1);
        carEntity.setPassengerEntities(testHelperClass.createPassengerEntityList(carEntity, employeeEntity2));
        when(carRepository.findAll()).thenReturn(testHelperClass.createCarEntityList(carEntity));
        when(carRepository.getOne(carId)).thenReturn(carEntity);
        when(passengerRepository.findAll()).thenReturn(carEntity.getPassengerEntities());
    }

    @Test
    public void shouldAddPassengerToSelectedCar() {
        //GIVEN
        numberOfPassengers = 2;
        long empId = 3;

        EmployeeEntity employeeEntity3 = testHelperClass.createEmployeeEntity(empId, "Andrzej", "Wozniak");
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity3);
        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(numberOfPassengers);
        //WHEN
        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);

        // THEN
        assertTrue(actual.getBrand().equalsIgnoreCase("Mercedes"));
        assertTrue(actual.getPassengers().get(0) == 1);
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

        EmployeeEntity employeeEntity3 = testHelperClass.createEmployeeEntity(empId, "Andrzej", "Wozniak");
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

        //WHEN
        CarDto actual = passengerService.addPassengerToSelectedCar(carId, empId);

        //THEN
        assertNull(actual);
    }

}


