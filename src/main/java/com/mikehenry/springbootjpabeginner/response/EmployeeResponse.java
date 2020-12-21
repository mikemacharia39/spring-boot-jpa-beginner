package com.mikehenry.springbootjpabeginner.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mikehenry.springbootjpabeginner.Utils.Utilities;
import com.mikehenry.springbootjpabeginner.model.Employee;
import com.mikehenry.springbootjpabeginner.model.Tasks;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    private String address;
    private String city;
    private List<TaskResponse> taskResponseList;

    public EmployeeResponse(Employee employee) {
        this.employeeID = employee.getEmployeeID();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.emailAddress = employee.getEmailAddress();
        this.active = employee.getActive();
        this.dateCreated = employee.getDateCreated();
        this.dateModified = employee.getDateModified();

        if (employee.getAddress() != null) {
            this.address = employee.getAddress().getAddress();
            this.city = employee.getAddress().getCity();
        }

        if (!Utilities.isEmpty(employee.getTasksList())) {
            taskResponseList = new ArrayList<TaskResponse>();
            for (Tasks task: employee.getTasksList()) {
                taskResponseList.add(new TaskResponse(task));
            }
        }
    }
}
