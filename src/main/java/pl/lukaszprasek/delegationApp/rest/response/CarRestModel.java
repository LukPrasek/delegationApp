package pl.lukaszprasek.delegationApp.rest.response;

import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;
import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

public class CarRestModel {
    private long carId;
    private String brand;
    private String model;
    private int seatsNumber;
//    private EmployeeDto owner;
//    private PassengerEntity passengers;


    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

//    public EmployeeDto getOwner() {
//        return owner;
//    }
//
//    public void setOwner(EmployeeDto owner) {
//        this.owner = owner;
//    }
//
//    public PassengerEntity getPassengers() {
//        return passengers;
//    }
//
//    public void setPassengers(PassengerEntity passengers) {
//        this.passengers = passengers;
//    }
}
