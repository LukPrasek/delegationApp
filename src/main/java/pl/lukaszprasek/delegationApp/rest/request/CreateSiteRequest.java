package pl.lukaszprasek.delegationApp.rest.request;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class CreateSiteRequest {
    @ApiModelProperty(name = "Name", required = true)
    @NotNull
    private String name;
    @ApiModelProperty(name = "Address", required = true)
    @NotNull
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
