package pl.lukaszprasek.delegationApp.common.dto;

import java.io.Serializable;

public class PassengerDto implements Serializable {

    private Long passengerId;
    private CarDto carDto;
    private EmployeeDto employeeDto;

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

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }

    public static class Builder {
        private Long passengerId;
        private CarDto carDto;
        private EmployeeDto employeeDto;

        public Builder withPassengerID(Long passangerId) {
            this.passengerId = passangerId;
            return this;
        }

        public Builder withCarDto(CarDto carDto) {
            this.carDto = carDto;
            return this;
        }

        public Builder withEmployeeDto(EmployeeDto employeeDto) {
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
