package pl.lukaszprasek.delegationApp.common.dto;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDto {
    private long empId;
    private String name;
    private String surname;
    private String birthday;
    private String startWorkingDay;
    private String startWorkingDate;

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

    public String getStartWorkingDay() {
        return startWorkingDay;
    }

    public String getStartWorkingDate() {
        return startWorkingDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private EmployeeDto dto;

        public Builder withEmpId(long id) {
            dto.empId = id;
            return this;
        }

        public Builder withName(String name) {
            dto.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            dto.surname = surname;
            return this;
        }

        public Builder withBirthday(String birthday) {
            dto.birthday = birthday;
            return this;
        }

        public Builder withStartWorkingDay(String startWorkingDate) {
            dto.startWorkingDate = startWorkingDate;
            return this;
        }

        public EmployeeDto build() {
            return dto;
        }
    }

}
