package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "passengers")
public class PassengerEntity {

    @Id
    @GeneratedValue
    private Long passengerId;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="car_Id" )
    private CarEntity car;

    @OneToOne
    @JoinColumn(name ="emp_Id" )
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
        return
        "Passenger{" +
                "passenger Id=" + passengerId +
                "+"+ employeeEntity.toString()+"'}'";
    }
    public String showPassengerData(){
        return "PassengerEntity{" +
                "passengerId=" + passengerId +
                ", employeeEntity=" + employeeEntity.showNameSurnameAndPosition() +
                '}';
    }
}
