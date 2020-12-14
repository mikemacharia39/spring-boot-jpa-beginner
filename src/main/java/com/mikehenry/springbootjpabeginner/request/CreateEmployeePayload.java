package com.mikehenry.springbootjpabeginner.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateEmployeePayload {

    String firstName;

    String lastName;

    String emailAddress;
}
