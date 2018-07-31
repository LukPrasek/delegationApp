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

    private EmployeeDto(Builder builder) {
        if (builder==null) {
            return;
        }
        this.empId = builder.empId;
        this.name = builder.name;
        this.surname = builder.surname;
        this.birthday = builder.birthday;
        this.startWorkingDate = builder.startWorkingDate;
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

    private EmployeeDto(){};

    public static class Builder {
        private long empId;
        private String name;
        private String surname;
        private String birthday;
        private String startWorkingDate;

        public Builder withEmpId (long empId){
            this.empId=empId;
            return this;
    }
            public Builder withName(String nam) {
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
            System.out.println("**************************************"+startWorkingDate);
            this.startWorkingDate = startWorkingDate.toString();
            return this;
        }
        public EmployeeDto build() {

            return new EmployeeDto(this);
        }

//    public static Builder builder() {
//        return new Builder();
//    }
//
//
//    public static class Builder {
//        private final EmployeeDto employeeDto;
//
//        public Builder() {
//            employeeDto = new EmployeeDto();
//        }
//
//        public Builder withEmpId(long id) {
//            employeeDto.empId = id;
//            return this;
//        }
//
//        public Builder withName(String name) {
//            employeeDto.name = name;
//            return this;
//        }
//
//        public Builder withSurname(String surname) {
//            employeeDto.surname = surname;
//            return this;
//        }
//
//        public Builder withBirthday(Date birthday) {
//            employeeDto.birthday = birthday.toString();
//            return this;
//        }
//
//        public Builder withStartWorkingDay(Date startWorkingDate) {
//            employeeDto.startWorkingDate = startWorkingDate.toString();
//            return this;
//        }
//
//        public EmployeeDto build() {
//
//            return employeeDto;
//        }
    }

}
