package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
@Inheritance(strategy = InheritanceType.JOINED)
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


    public EmployeeEntity(String name, String surname, LocalDate birthdate, LocalDate startWorkingDate) {

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


}
