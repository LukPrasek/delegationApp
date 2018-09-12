package pl.lukaszprasek.delegationApp.common.dto;

import pl.lukaszprasek.delegationApp.domain.entities.PassengerEntity;

import java.io.Serializable;
import java.util.List;

public class CarDto implements Serializable {
    private Long carId;
    private String brand;
    private String model;
    private int seatsNumber;
    private EmployeeDto owner;
    private List<PassengerDto> passengers;

    private CarDto(Builder builder) {
        if (builder == null) {
            return;
        }
        this.carId = builder.carId;
        this.brand = builder.brand;
        this.model = builder.model;
        this.seatsNumber = builder.seatsNumber;
        this.owner = builder.owner;
        this.passengers = builder.passengers;
    }

    public CarDto() {
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
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

    public EmployeeDto getOwner() {
        return owner;
    }

    public void setOwner(EmployeeDto owner) {
        this.owner = owner;
    }

    public List<PassengerDto> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<PassengerDto> passengers) {
        this.passengers = passengers;
    }

    public static class Builder {
        private Long carId;
        private String brand;
        private String model;
        private int seatsNumber;
        private EmployeeDto owner;
        private List<PassengerDto> passengers;

        public Builder withCarId(Long carId) {
            this.carId = carId;
            return this;
        }

        public Builder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public Builder withModel(String model) {
            this.model = model;
            return this;
        }

        public Builder withSeatsNumber(int seatsNumber) {
            this.seatsNumber = seatsNumber;
            return this;
        }

        public Builder withOwner(EmployeeDto owner) {
            this.owner = owner;
            return this;
        }

        public Builder withPassengers(List<PassengerDto> passengers) {
            this.passengers = passengers;
            return this;
        }

        public CarDto build() {
            return new CarDto(this);
        }
    }

    @Override
    public String toString() {
        return "CarDto{" +
                "carId=" + carId +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", seatsNumber=" + seatsNumber +
                ", owner='" + owner + '\'' +
                ", passengers='" + passengers + '\'' +
                '}';
    }
}
