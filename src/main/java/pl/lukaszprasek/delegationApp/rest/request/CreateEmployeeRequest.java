package pl.lukaszprasek.delegationApp.rest.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class CreateEmployeeRequest {

    @ApiModelProperty(name = "first name", required = true)
    @NotNull
    private String name;

    @ApiModelProperty(name = "last name", required = true)
    @NotNull
    private String surname;

    @ApiModelProperty(name = "birthday in format: yyyy-dd-mm", required = true)
    @NotNull
    private String birthday;

    @ApiModelProperty(name = "start working date in format: yyyy-dd-mm", required = true)
    @NotNull
    private String startWorkingDate;

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
}
