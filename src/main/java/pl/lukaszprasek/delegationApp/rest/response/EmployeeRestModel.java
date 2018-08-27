package pl.lukaszprasek.delegationApp.rest.response;

public class EmployeeRestModel {

    private long empId;
    private String name;
    private String surname;
    private String birthday;
    private String startWorkingDate;
    private String position;
    private String car;


    public long getEmpId() {
        return empId;
    }

    public void setEmpId(long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getStartWorkingDate() {
        return startWorkingDate;
    }

    public void setStartWorkingDate(String startWorkingDate) {
        this.startWorkingDate = startWorkingDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
