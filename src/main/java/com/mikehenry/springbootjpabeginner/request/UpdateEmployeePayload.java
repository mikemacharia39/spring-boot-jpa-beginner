package com.mikehenry.springbootjpabeginner.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateEmployeePayload {

    @NotNull
    long employeeID;

    String firstName;

    String lastName;

    String emailAddress;
}
