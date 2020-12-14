package com.mikehenry.springbootjpabeginner.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mikehenry.springbootjpabeginner.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeResponse {

    private long employeeID;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int active;
    @JsonIgnore
    private Date dateCreated;
    @JsonIgnore
    private Date dateModified;

    public EmployeeResponse(Employee employee) {
        this.employeeID = employee.getEmployeeID();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.emailAddress = employee.getEmailAddress();
        this.active = employee.getActive();
        this.dateCreated = employee.getDateCreated();
        this.dateModified = employee.getDateModified();
    }
}
