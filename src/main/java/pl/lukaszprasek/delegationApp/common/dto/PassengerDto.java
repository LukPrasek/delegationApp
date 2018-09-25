package pl.lukaszprasek.delegationApp.common.dto;

import java.io.Serializable;

public class PassengerDto implements Serializable {

    private Long passengerId;
    private long carDto;
    private long employeeDto;

    private PassengerDto(Builder builder) {
        if (builder == null) {
            return;
        }
        this.passengerId = builder.passengerId;
        this.carDto = builder.carDto;
        this.employeeDto = builder.employeeDto;
    }

    public Long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Long passengerId) {
        this.passengerId = passengerId;
    }

    public long getCarDto() {
        return carDto;
    }

    public void setCarDto(long carDto) {
        this.carDto = carDto;
    }

    public long getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(long employeeDto) {
        this.employeeDto = employeeDto;
    }

    public static class Builder {
        private Long passengerId;
        private long carDto;
        private long employeeDto;

        public Builder withPassengerID(Long passangerId) {
            this.passengerId = passangerId;
            return this;
        }

        public Builder withCarDto(long carDto) {
            this.carDto = carDto;
            return this;
        }

        public Builder withEmployeeDto(long employeeDto) {
            this.employeeDto = employeeDto;
            return this;
        }

        public PassengerDto build() {
            return new PassengerDto(this);
        }
    }

    @Override
    public String toString() {
        return "PassengerDto{" +
                "passengerId=" + passengerId +
                ", carDto='" + carDto + '\'' +
                ", employeeDto='" + employeeDto + '\'' +
                '}';
    }
}
