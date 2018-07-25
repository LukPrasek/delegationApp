package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
//@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private long empId;
    private String name;
    private String surname;
    private LocalDate birthday;
    private LocalDate startWorkingDate;


    public EmployeeEntity(String name, String surname, LocalDate birthdate, LocalDate startWorkingDate) {

    }
    public EmployeeEntity(){}

    public long getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(LocalDate startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }


}
