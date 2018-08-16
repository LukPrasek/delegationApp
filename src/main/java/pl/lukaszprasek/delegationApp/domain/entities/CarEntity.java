package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class CarEntity {

    @Id
    @GeneratedValue
    @Column(name = "car_id")
    private Long carId;
    private String brand;
    private String model;
    private int seatsNumber = 5;
    @OneToOne(mappedBy = "empId", fetch = FetchType.LAZY)
    private EmployeeEntity owner;



    @OneToMany(mappedBy = "empId", fetch = FetchType.LAZY)
    private List<EmployeeEntity> passangers;

    public CarEntity(String brand, String model, int seatsNumber) {
        this.brand = brand;
        this.model = model;
        this.seatsNumber = seatsNumber;
    }

    public CarEntity(String brand, String model, int seatsNumber, EmployeeEntity owner, List<EmployeeEntity> passangers) {
        this.brand = brand;
        this.model = model;
        this.seatsNumber = seatsNumber;
        this.owner = owner;
        this.passangers = passangers;
    }

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

    public List<EmployeeEntity> getPassangers() {
        return passangers;
    }

    public void setPassangers(List<EmployeeEntity> passangers) {
        this.passangers = passangers;
    }
}
