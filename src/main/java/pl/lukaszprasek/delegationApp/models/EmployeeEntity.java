package pl.lukaszprasek.delegationApp.models;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
public class EmployeeEntity {

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private int empId;
    private String name;
    private String surname;
    //@Temporal(TemporalType.DATE)
    private LocalDate birthday;
    //@Temporal(TemporalType.DATE)
    private LocalDate startWorkingDate;



    public EmployeeEntity(String name, String surname, LocalDate birthdate, LocalDate startWorkingDate) {

    }
    public EmployeeEntity(){}


    public int getEmpId() {
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
