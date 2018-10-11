package pl.lukaszprasek.delegationApp.domain.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
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
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CarServiceImplTest {
    private CarEntity carEntity;
    private TestHelperClass testHelperClass;
    long carId;
    @Mock
    EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
    @Mock
    CarRepository carRepository = mock(CarRepository.class);

    private CarService carService;

    @Before
    public void setUp() {
        //carEntity = createCarEntity(1, "Merc", "Vito", 3);
        carService = new CarServiceImpl(carRepository, employeeRepository);
        testHelperClass=new TestHelperClass();
        carEntity = testHelperClass.createCarEntity(1, "Kia", "Szuma", 3);
    }

    @Test
    public void shouldAssignEmployeeToCar() {
        //GIVEN
        long empId = 1;
        carId = 1;

        CarEntity carEntity2 = testHelperClass.createCarEntity(2, "Volvo", "V50", 5);
        EmployeeEntity employeeEntity3 = testHelperClass.createEmployeeEntity(3, "Andrzej", "Wozniak");
        when(employeeRepository.getOne(empId)).thenReturn(employeeEntity3);
        carEntity.setPassengerEntities(testHelperClass.createPassengerEntityList(carEntity, employeeEntity3));
        when(carRepository.getOne(carId)).thenReturn(carEntity);

        when(carRepository.findAll()).thenReturn(testHelperClass.createCarEntityList(carEntity2, carEntity));

        //WHEN
        CarDto actual = carService.assignEmployeeToCar(carId, empId);

        //THEN
        assertEquals(3, actual.getEmployeeId());
    }

    @Test
    public void shouldNotAssignEmployeeToCarWhenGivenEmpIsOwnerOfAnotherCar() {
        //GIVEN
        long empId = 1;
        carId = 1;

        CarEntity carEntity2 = testHelperClass.createCarEntity(2, "Volvo", "V50", 5);
        carEntity2.setOwner(testHelperClass.createEmployeeEntity(1, "Lukasz", "Prus"));

        EmployeeEntity employeeEntity3 = testHelperClass.createEmployeeEntity(3, "Andrzej", "Wozniak");
        carEntity.setPassengerEntities(testHelperClass.createPassengerEntityList(carEntity, employeeEntity3));
        when(carRepository.getOne(carId)).thenReturn(carEntity);

        when(carRepository.findAll()).thenReturn(testHelperClass.createCarEntityList(carEntity2, carEntity));

        //WHEN
        CarDto actual = carService.assignEmployeeToCar(carId, empId);

        //THEN
        assertNull(actual);
    }

    @Test
    public void shouldNotAssignEmployeeToCarWhenCarHasOwnerAlready() {
        //GIVEN
        long empId = 1;
        carId = 1;

        carEntity.setOwner(testHelperClass.createEmployeeEntity(1, "Lukasz", "Prus"));
        EmployeeEntity employeeEntity3 = testHelperClass.createEmployeeEntity(3, "Andrzej", "Wozniak");
        carEntity.setPassengerEntities(testHelperClass.createPassengerEntityList(carEntity, employeeEntity3));
        when(carRepository.getOne(carId)).thenReturn(carEntity);
        when(carRepository.findAll()).thenReturn(testHelperClass.createCarEntityList(carEntity));//carEntity2,

        //WHEN
        CarDto actual = carService.assignEmployeeToCar(carId, empId);

        //THEN
        assertNull(actual);
    }


}