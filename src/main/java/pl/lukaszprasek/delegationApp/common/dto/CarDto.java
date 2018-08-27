package pl.lukaszprasek.delegationApp.common.dto;


import java.io.Serializable;

public class CarDto implements Serializable {
    private Long carId;
    private String brand;
    private String model;
    private int seatsNumber;
    private String owner;
    private String passengers;

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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPassengers() {
        return passengers;
    }

    public void setPassengers(String passengers) {
        this.passengers = passengers;
    }

    public static class Builder {
        private Long carId;
        private String brand;
        private String model;
        private int seatsNumber;
        private String owner;
        private String passengers;

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

        public Builder withOwner(String owner) {
            this.owner = owner;
            return this;
        }

        public Builder withPassengers(String passengers) {
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
