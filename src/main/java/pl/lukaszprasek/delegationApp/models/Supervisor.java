package pl.lukaszprasek.delegationApp.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "SUPERVISOR")
@PrimaryKeyJoinColumn(name = "supervisor_id", referencedColumnName = "emp_id")
public class Supervisor extends EmployeeEntity {


    private int extraHours;
    private boolean hasDrivingLicense;


    public Supervisor(String name, String surname, LocalDate birthdate, LocalDate startWorkingDate, boolean hasDrivingLicense, int extraHours) {
        super(name, surname, birthdate, startWorkingDate);
        //super(name, surname, birthdate, startWorkingDate);
        this.hasDrivingLicense = hasDrivingLicense;
        this.extraHours = extraHours;

    }
    public Supervisor(){}

    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public boolean isHasDrivingLicense() {
        return hasDrivingLicense;
    }

    public void setHasDrivingLicense(boolean hasDrivingLicense) {
        this.hasDrivingLicense = hasDrivingLicense;
    }
}
