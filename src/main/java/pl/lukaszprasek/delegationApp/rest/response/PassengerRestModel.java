package pl.lukaszprasek.delegationApp.rest.response;

public class PassengerRestModel {
    private long passangerId;
    private String carDto;
    private String employeeDto;

    public long getPassangerId() {
        return passangerId;
    }

    public void setPassangerId(long passangerId) {
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


}
