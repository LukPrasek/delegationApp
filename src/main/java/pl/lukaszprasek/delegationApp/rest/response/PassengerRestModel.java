package pl.lukaszprasek.delegationApp.rest.response;

public class PassengerRestModel {
    private long passengerId;
    private long carRestModel;
    private long employeeRestModel;

    public long getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(long passengerId) {
        this.passengerId = passengerId;
    }

    public long getCarRestModel() {
        return carRestModel;
    }

    public void setCarRestModel(long carRestModel) {
        this.carRestModel = carRestModel;
    }

    public long getEmployeeRestModel() {
        return employeeRestModel;
    }

    public void setEmployeeRestModel(long employeeRestModel) {
        this.employeeRestModel = employeeRestModel;
    }


}
