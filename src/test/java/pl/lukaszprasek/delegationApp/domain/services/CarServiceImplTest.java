package pl.lukaszprasek.delegationApp.domain.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
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
    CarService carService;
    private long carId = 2;
    private long empId = 1;
    private long numberOfPassengers = 1;
    CarEntity carEntity;
    EmployeeEntity employeeEntity;

    @Before
    public void setUp() {
        carService = new CarServiceImpl(carRepository, employeeRepository,
                passengerRepository, employeeMapperFromEntityToDto, passengerMapperFromEntityToDto);
    }

    @Test
    public void shouldAddPassengerToSelectedCar() {
        //GIVEN

        CarEntity carEntity=createCarEntity();
        when(carRepository.getOne(carId)).thenReturn(createCarEntity());
        when(carRepository.getOne(carId)).thenReturn(carEntity);
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity);
        when(passengerRepository.countPassengersByCarId(carEntity)).thenReturn(numberOfPassengers);
       // PassengerEntity passengerEntity = new PassengerEntity();
        //WHEN
        CarDto actual = carService.addPassengerToSelectedCar(carId, empId);
        //THEN
        System.out.println(actual.getBrand());
        assertTrue(actual.getBrand().equalsIgnoreCase("Mercedes"));
    }

    @Test
    public void shouldRemovePassengerFromSelectedCar(){

    }
    private CarEntity createCarEntity() {
        carEntity = new CarEntity();
        carEntity.setCarId(carId);
        carEntity.setBrand("Mercedes");
        carEntity.setModel("Vito");
        carEntity.setSeatsNumber(3);
        return carEntity;
    }
}


