package pl.lukaszprasek.delegationApp.domain.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cars")
public class CarEntity {

    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Long carId;
    private String brand;
    private String model;
    @Column(name = "seats_number")
    private int seatsNumber = 5;

    @OneToOne(mappedBy = "carEntity", cascade = CascadeType.REFRESH)
    private EmployeeEntity owner;

    @OneToMany(mappedBy = "passengerId", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PassengerEntity> passengerEntities;

    public CarEntity() {
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

    public EmployeeEntity getOwner() {
        return owner;
    }

    public void setOwner(EmployeeEntity owner) {
        this.owner = owner;
    }

    public List<PassengerEntity> getPassengerEntities() {
        return passengerEntities;
    }

    public void setPassengerEntities(List<PassengerEntity> passengerEntities) {
        this.passengerEntities = passengerEntities;
    }

//    @Override
//    public String toString() {
//        return "CarEntity{" +
//                "carId=" + carId +
//                ", brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", seatsNumber=" + seatsNumber +
//                ", owner=" + owner +
//                ", passengerEntities=" + passengerEntities +
//                '}';
//    }
//
//    public String showBasicCarData() {
//        return "CarEntity{" +
//                "carId=" + carId +
//                ", brand='" + brand + '\'' +
//                ", model='" + model + '\'' +
//                ", seatsNumber=" + seatsNumber +
//                '}';
    //}
}
