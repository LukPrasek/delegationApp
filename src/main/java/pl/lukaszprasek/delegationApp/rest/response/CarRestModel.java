package pl.lukaszprasek.delegationApp.rest.response;

import java.util.List;

public class CarRestModel {
    private long carId;
    private String brand;
    private String model;
    private int seatsNumber;
    private long owner;
    private List<Long> passengers;


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

    public Long getEmployeeId() {
        return owner;
    }

    public void setEmployeeId(Long owner) {
        this.owner = owner;
    }

    public List<Long> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Long> passengers) {
        this.passengers = passengers;
    }
}
