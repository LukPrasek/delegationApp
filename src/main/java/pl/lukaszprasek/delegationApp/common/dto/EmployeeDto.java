package pl.lukaszprasek.delegationApp.common.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class EmployeeDto implements Serializable {

    private long empId;
    private String name;
    private String surname;
    private String birthday;
    private String startWorkingDate;
    private String employeePosition;
    private CarDto carDto;

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

    }

    public EmployeeDto(long empId, String name, String surname) {
        this.empId = empId;
        this.name = name;
        this.surname = surname;
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
        private String carDto;

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

        public Builder withCarDto(String carDto) {
            //todo change to ID instead object
            this.carDto = carDto;
            return this;
        }

        public EmployeeDto build() {

            return new EmployeeDto(this);
        }


        @Override
        public String toString() {
            return "Builder{" +
                    "empId=" + empId +
                    ", name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", birthday='" + birthday + '\'' +
                    ", startWorkingDate='" + startWorkingDate + '\'' +
                    ", employeePosition='" + employeePosition + '\'' +
                    ", carDto='" + carDto + '\'' +
                    '}';
        }
    }

}
