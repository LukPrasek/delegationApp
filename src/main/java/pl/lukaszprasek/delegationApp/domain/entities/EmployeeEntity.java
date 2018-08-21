package pl.lukaszprasek.delegationApp.domain.entities;

import pl.lukaszprasek.delegationApp.domain.entities.enums.EmployeePosition;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmployeeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;
    private String name;
    private String surname;
    private LocalDate birthday;
    @Column(name = "start_working_date")
    private LocalDate startWorkingDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "employee_position")
    private EmployeePosition employeePosition;

    @OneToOne//(mappedBy = "carId")
    @JoinColumn(name = "car_id")
    private CarEntity carEntity;

//      public EmployeeEntity(String name, String surname, LocalDate birthdate, LocalDate startWorkingDate, EmployeePosition employeePosition) {
//
//    }

    public EmployeeEntity(String name, String surname, LocalDate birthday, LocalDate startWorkingDate, EmployeePosition employeePosition, CarEntity carEntity) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.startWorkingDate = startWorkingDate;
        this.employeePosition = employeePosition;
        this.carEntity = carEntity;

    }

    public EmployeeEntity() {
    }

    public long getEmpId() {
        return empId;
    }


    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public LocalDate getBirthday() {
        return birthday;
    }


    public LocalDate getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setStartWorkingDate(LocalDate startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    public EmployeePosition getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(EmployeePosition employeePosition) {
        this.employeePosition = employeePosition;
    }
    public CarEntity getCarEntity() {
        return carEntity;
    }

    public void setCarEntity(CarEntity carEntity) {
        this.carEntity = carEntity;
    }
}
