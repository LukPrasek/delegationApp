package pl.lukaszprasek.delegationApp.rest.response;

import pl.lukaszprasek.delegationApp.common.dto.CarDto;
import pl.lukaszprasek.delegationApp.common.dto.EmployeeDto;

public class PassengerRestModel {
    private long passengerId;
//    private CarDto carDto;
    private EmployeeDto employeeDto;

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

//    public CarDto getCarDto() {
//        return carDto;
//    }
//
//    public void setCarDto(CarDto carDto) {
//        this.carDto = carDto;
//    }

    public EmployeeDto getEmployeeDto() {
        return employeeDto;
    }

    public void setEmployeeDto(EmployeeDto employeeDto) {
        this.employeeDto = employeeDto;
    }


}
