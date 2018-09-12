package pl.lukaszprasek.delegationApp.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "passengers")
public class PassengerEntity {

    @Id
    @GeneratedValue
    private Long passengerId;

    @ManyToOne(fetch = FetchType.LAZY)//, cascade = CascadeType.ALL
    @JoinColumn(name = "car_Id")
    @JsonBackReference
    private CarEntity car;

    @OneToOne
    @JoinColumn(name = "emp_Id")
    private EmployeeEntity employeeEntity;

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public CarEntity getCar() {
        return car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    @Override
    public String toString() {
        return "PassengerEntity{" +
                "passengerId=" + passengerId +
                ", car=" + car +
                ", employeeEntity=" + employeeEntity +
                '}';
    }

    public String showPassengerData() {
        return "PassengerEntity{" +
                "passengerId=" + passengerId +
                ", employeeEntity=" + employeeEntity.showNameSurnameAndPosition() +
                '}';
    }
}
