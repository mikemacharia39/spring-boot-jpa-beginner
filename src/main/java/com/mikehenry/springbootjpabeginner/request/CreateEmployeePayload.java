package com.mikehenry.springbootjpabeginner.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CreateEmployeePayload {

    @NotBlank(message = "first name is required")
    String firstName;

    @NotEmpty(message = "last name is required")
    String lastName;

    @Pattern(regexp = "^(.+)@(.+)$", message = "Please enter a valid email address")
    String emailAddress;
}
