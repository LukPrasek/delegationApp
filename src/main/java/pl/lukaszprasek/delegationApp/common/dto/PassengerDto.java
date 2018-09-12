package pl.lukaszprasek.delegationApp.common.dto;


import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;

import java.io.Serializable;

public class PassengerDto implements Serializable {

    private Long passengerId;
    private CarEntity carDto;
    private EmployeeEntity employeeDto;

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

    public CarEntity getCarDto() {
        return carDto;
    }

    public void setCarDto(CarEntity carDto) {
        this.carDto = carDto;
    }

    public EmployeeEntity getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeEntity employeeDto) {
        this.employeeDto = employeeDto;
    }

    public static class Builder {
        private Long passengerId;
        private CarEntity carDto;
        private EmployeeEntity employeeDto;

        public Builder withPassengerID(Long passangerId) {
            this.passengerId = passangerId;
            return this;
        }

        public Builder withCarDto(CarEntity carDto) {
            this.carDto = carDto;
            return this;
        }

        public Builder withEmployeeDto(EmployeeEntity employeeDto) {
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
