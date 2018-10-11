package pl.lukaszprasek.delegationApp.domain.services;

import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

import java.util.ArrayList;
import java.util.List;

public class TestHelperClass {

    CarEntity createCarEntity(long carId, String brand, String model, int seatsNumber) {
        CarEntity carEntity = new CarEntity();
        carEntity.setCarId(carId);
        carEntity.setBrand(brand);
        carEntity.setModel(model);
        carEntity.setSeatsNumber(seatsNumber);
        //;
        return carEntity;
    }

    List<CarEntity> createCarEntityList(CarEntity... carEntity) {
        List<CarEntity> carEntities = new ArrayList<>();
        for (int i = 0; i < carEntity.length; i++) {
            carEntities.add(carEntity[i]);
        }
        return carEntities;
    }

    EmployeeEntity createEmployeeEntity(long empId, String name, String surname) {
        EmployeeEntity employee = new EmployeeEntity();
        employee.setEmpId(empId);
        employee.setName(name);
        employee.setSurname(surname);
        return employee;
    }

    List<PassengerEntity> createPassengerEntityList(CarEntity carEntity, EmployeeEntity employeeEntity) {
        List<PassengerEntity> list = new ArrayList<>();
        PassengerEntity passengerEntity = new PassengerEntity();
        passengerEntity.setPassengerId(1L);
        passengerEntity.setEmployeeEntity(employeeEntity);
        passengerEntity.setCar(carEntity);
        list.add(passengerEntity);
        return list;
    }
}
