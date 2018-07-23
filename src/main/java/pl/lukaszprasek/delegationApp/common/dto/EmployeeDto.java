package pl.lukaszprasek.delegationApp.common.dto;

import java.time.LocalDate;

public class EmployeeDto {
    private int empId;
    private String name;
    private String surname;

    private String birthday;

    private String startWorkingDate;

    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private EmployeeDto dto;



    }

}
