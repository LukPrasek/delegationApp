package pl.lukaszprasek.delegationApp.common.dto;


import java.io.Serializable;

public class PassengerDto implements Serializable {

    private Long passangerId;
    private String carDto;
    private String employeeDto;

    public PassengerDto(Builder builder) {
        if (builder == null) {
            return;
        }
        this.passangerId = builder.passangerId;
        this.carDto = builder.carDto;
        this.employeeDto = builder.employeeDto;
    }

    public Long getPassangerId() {
        return passangerId;
    }

    public void setPassangerId(Long passangerId) {
        this.passangerId = passangerId;
    }

    public String getCarDto() {
        return carDto;
    }

    public void setCarDto(String carDto) {
        this.carDto = carDto;
    }

    public String getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(String employeeDto) {
        this.employeeDto = employeeDto;
    }

    private static class Builder {
        private Long passangerId;
        private String carDto;
        private String employeeDto;

        public Builder withPassengerID(Long passangerId) {
            this.passangerId = passangerId;
            return this;
        }

        public Builder withCarDto(String carDto) {
            this.carDto = carDto;
            return this;
        }

        public Builder withEmployeeDto(String employeeDto) {
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
                "passangerId=" + passangerId +
                ", carDto='" + carDto + '\'' +
                ", employeeDto='" + employeeDto + '\'' +
                '}';
    }
}
