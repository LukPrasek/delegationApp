package pl.lukaszprasek.delegationApp.common.dto;

import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;

import java.io.Serializable;
import java.time.LocalDate;

public class EmployeeDto implements Serializable {

    private long empId;
    private String name;
    private String surname;
    private String birthday;
    private String startWorkingDate;
    private String employeePosition;
    private long carId;

    private EmployeeDto(Builder builder) {
        if (builder == null) {
            return;
        }
        this.empId = builder.empId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthday = builder.birthday;
        this.startWorkingDate = builder.startWorkingDate;
        this.employeePosition = builder.employeePosition;
        this.carId = builder.carId;

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

    public String getBirthday() {
        return birthday;
    }

    public String getStartWorkingDate() {
        return startWorkingDate;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarDto(long carId) {
        this.carId = carId;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    private EmployeeDto() {
    }

    public static class Builder {
        private long empId;
        private String name;
        private String surname;
        private String birthday;
        private String startWorkingDate;
        private String employeePosition;
        private long carId;

        public Builder withEmpId(long empId) {
            this.empId = empId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder withBirthday(LocalDate birthday) {
            this.birthday = birthday.toString();
            return this;
        }

        public Builder withStartWorkingDay(LocalDate startWorkingDate) {
            this.startWorkingDate = startWorkingDate.toString();
            return this;
        }

        public Builder withEmployeePosition(String position) {
            this.employeePosition = position;
            return this;
        }

        public Builder withCarDto(long carId) {
            this.carId = carId;
            return this;
        }

        public EmployeeDto build() {

            return new EmployeeDto(this);
        }

     }

}
