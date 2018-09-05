package pl.lukaszprasek.delegationApp.rest.response;

import pl.lukaszprasek.delegationApp.domain.entities.CarEntity;
import pl.lukaszprasek.delegationApp.domain.entities.EmployeeEntity;

public class PassengerRestModel {
    private long passangerId;
    private CarEntity carDto;
    private EmployeeEntity employeeDto;

    public long getPassangerId() {
        return passangerId;
    }

    public void setPassangerId(long passangerId) {
        this.passangerId = passangerId;
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


}
