package pl.lukaszprasek.delegationApp.rest.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

public class CreateCarRequest {

    @ApiModelProperty(name = "Brand", required = true)
    @NotNull
    private String brand;
    @ApiModelProperty(name = "Model", required = true)
    @NotNull
    private String model;
    @ApiModelProperty(name = "Number of seats", required = true)
    @NotNull
    private int seatsNumber;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(int seatsNumber) {
        this.seatsNumber = seatsNumber;
    }


}
