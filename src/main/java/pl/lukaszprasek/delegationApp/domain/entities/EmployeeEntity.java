package pl.lukaszprasek.delegationApp.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import pl.lukaszprasek.delegationApp.domain.entities.enums.EmployeePosition;
import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
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

    @OneToOne
    @JoinColumn(name = "car_id")
    @JsonBackReference
    private CarEntity carEntity;

    public EmployeeEntity() {
    }
    public EmployeeEntity(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public void setEmpId(long empId) {
        this.empId = empId;
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

//    @Override
//    public String toString() {
//        return "EmployeeEntity{" +
//                "empId=" + empId +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", birthday=" + birthday +
//                ", startWorkingDate=" + startWorkingDate +
//                ", employeePosition=" + employeePosition +
//                ", carEntity=" + carEntity +
//                '}';
//    }
//
//    public String showNameSurnameAndPosition(){
//                return "Employee{" +
//                "Id=" + empId +
//                ", name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", Position=" + employeePosition +
//                '}';
//    }
}
