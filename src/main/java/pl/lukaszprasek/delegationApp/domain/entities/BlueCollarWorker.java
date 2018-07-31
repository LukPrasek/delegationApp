package pl.lukaszprasek.delegationApp.domain.entities;

import javax.persistence.Entity;
import java.sql.Date;
import java.time.LocalDate;

//@Entity
public class BlueCollarWorker extends EmployeeEntity {
    private String positionName;//technician, supervisor
    private boolean hasDrivingLicense;

    public BlueCollarWorker(String name, String surname, Date birthdate, Date startWorkingDate, String positionName, boolean hasDrivingLicense) {
        super(name, surname, birthdate, startWorkingDate);
        this.positionName = positionName;
        this.hasDrivingLicense = hasDrivingLicense;
    }

    public BlueCollarWorker() {
    }

    ;
}
