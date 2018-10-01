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
public class CarServiceImplTest {

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
    private long carId = 2;
    private long empId = 1;
    private long numberOfPassengers = 2;
    private CarEntity carEntity;


    @Before
    public void setUp() {
        carService = new CarServiceImpl(carRepository, employeeRepository,
                passengerRepository, employeeMapperFromEntityToDto, passengerMapperFromEntityToDto);
    }

    @Test
    public void shouldAddPassengerToSelectedCar() {
        //GIVEN
        carEntity = createCarEntity();
        EmployeeEntity employeeEntity1 = createEmployeeEntity(3, "Andrzej", "Wozniak");
        List<PassengerEntity> list = createPassengerEntityList(carEntity, employeeEntity1);
        when(carRepository.getOne(carId)).thenReturn(createCarEntity());
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity1);
//        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(numberOfPassengers);
        when(passengerRepository.findAll()).thenReturn(list);

        //WHEN
        CarDto actual = carService.addPassengerToSelectedCar(carId, empId);

        //THEN
        assertTrue(actual.getBrand().equalsIgnoreCase("Mercedes"));
        assertTrue(actual.getPassengersId().get(0) == 1L);

    }

    @Test
    public void shouldNotAddPassengerToSelectedCarWhenEmployeeIsAlreadyAssigned() {
        //GIVEN
        carEntity = createCarEntity();
        EmployeeEntity employeeEntity1 = createEmployeeEntity(1, "Andrzej", "Wozniak");
        List<PassengerEntity> list = createPassengerEntityList(carEntity, employeeEntity1);
        System.out.println(list.get(0).getEmployeeEntity().getEmpId()+"************");
        when(carRepository.getOne(carId)).thenReturn(createCarEntity());
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity1);
        when(passengerRepository.findAll()).thenReturn(list);

        //WHEN
        CarDto actual = carService.addPassengerToSelectedCar(carId, empId);

        //THEN
        assertNull(actual);
    }

    private CarEntity createCarEntity() {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(5L);
        carEntity.setBrand("Mercedes");
        carEntity.setModel("Vito");
        carEntity.setSeatsNumber(3);
        EmployeeEntity employeeEntity2 = createEmployeeEntity(2, "Mieczyslaw", "Nowak");
        carEntity.setPassengerEntities(createPassengerEntityList(carEntity, employeeEntity2));
        return carEntity;
    }

    private EmployeeEntity createEmployeeEntity(long empId, String name, String surname) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmpId(empId);
        employeeEntity.setName(name);
        employeeEntity.setSurname(surname);
        return employeeEntity;
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
}


