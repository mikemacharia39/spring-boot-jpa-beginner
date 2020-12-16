package com.mikehenry.springbootjpabeginner.service;

import com.mikehenry.springbootjpabeginner.Utils.Utilities;
import com.mikehenry.springbootjpabeginner.model.Employee;
import com.mikehenry.springbootjpabeginner.repository.EmployeeRepository;
import com.mikehenry.springbootjpabeginner.request.UpdateEmployeePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * To return the list of all employees
     * @return List of all employees
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * To allow for the creation of an employee record
     * @param employee Object containing Employee data
     * @return instance of saved employee record
     */
    public Optional<Employee> createEmployee(Employee employee) {
        return Optional.of(employeeRepository.save(employee));
    }

    /**
     * To update an updated value
     * @param updateEmployeePayload Request payload received
     * @return instance of updated employee record
     */
    public Optional<Employee> updateEmployee(UpdateEmployeePayload updateEmployeePayload) {
        Employee employee = employeeRepository.findById(updateEmployeePayload.getEmployeeID())
                .orElseThrow();

        employee.setEmployeeID(updateEmployeePayload.getEmployeeID());
        if (!Utilities.isEmpty(updateEmployeePayload.getFirstName())) {
            employee.setFirstName(updateEmployeePayload.getFirstName());
        }
        if (!Utilities.isEmpty(updateEmployeePayload.getLastName())) {
            employee.setLastName(updateEmployeePayload.getLastName());
        }
        if (!Utilities.isEmpty(updateEmployeePayload.getEmailAddress())) {
            employee.setEmailAddress(updateEmployeePayload.getEmailAddress());
        }

        return Optional.of(employeeRepository.save(employee));
    }

    /**
     * Deletion of record
     * @param employeeID Identity of employee
     */
    public void deleteEmployee(long employeeID) {
        employeeRepository.deleteById(employeeID);
    }

    /**
     * Change active status of employee to inactive
     * @param employeeID Identity of employee
     */
    public Optional<Employee> deactivateEmployee(long employeeID, int status) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow();

        employee.setActive(status);

        return Optional.of(employeeRepository.save(employee));
    }
}
