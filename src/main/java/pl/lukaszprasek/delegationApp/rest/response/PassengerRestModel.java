package pl.lukaszprasek.delegationApp.rest.response;

public class PassengerRestModel {
    private long passengerId;
    private CarRestModel carRestModel;
    private EmployeeRestModel employeeRestModel;

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public CarRestModel getCarRestModel() {
        return carRestModel;
    }

    public void setCarRestModel(CarRestModel carRestModel) {
        this.carRestModel = carRestModel;
    }

    public EmployeeRestModel getEmployeeRestModel() {
        return employeeRestModel;
    }

    public void setEmployeeRestModel(EmployeeRestModel employeeRestModel) {
        this.employeeRestModel = employeeRestModel;
    }


}
