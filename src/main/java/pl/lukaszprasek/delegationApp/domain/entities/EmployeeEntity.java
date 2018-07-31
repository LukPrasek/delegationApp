package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.*;
import java.util.Date;

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
    private Date birthday;
    @Column(name = "start_working_date")
    private Date swd;


    public EmployeeEntity(String name, String surname,Date birthdate, Date swd) {

    }
    public EmployeeEntity(){}

    public long getEmpId() {
        return empId;
    }


    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public Date getBirthday() {
        return birthday;
    }


    public Date getSwd() {
        return swd;
    }




}
