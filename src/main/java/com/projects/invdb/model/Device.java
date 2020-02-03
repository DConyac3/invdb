package com.projects.invdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class Device {

    @NotBlank
    private final String serialNumber;

    private String os;

    @NotBlank
    private final String model;

    private final Date dop;

    public Device(@JsonProperty("serialNumber") String serialNumber,
                  @JsonProperty("os") String os,
                  @JsonProperty("model") String model,
                  @JsonProperty("dop") Date dop) {
        this.serialNumber = serialNumber;
        this.os = os;
        this.model = model;
        this.dop = dop;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getOs() {
        return os;
    }

    public String getModel() {
        return model;
    }

    public Date getDop() {
        return dop;
    }

    public void setOS(String os){
        this.os = os;
    }

}
