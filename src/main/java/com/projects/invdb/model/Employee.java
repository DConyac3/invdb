package com.projects.invdb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Employee {


    private final UUID id;

    @NotBlank
    private final String firstName;

    @NotBlank
    private final String lastName;

    private final String title;

    private final String device_sn;

    public Employee(@JsonProperty("id") UUID id,
                    @JsonProperty("firstName") String firstName,
                    @JsonProperty("lastName") String lastName,
                    @JsonProperty("title") String title,
                    @JsonProperty("device_sn") String device_sn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.device_sn = device_sn;
    }

    public UUID getId() {
        return id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getDevice() { return device_sn; }
}
