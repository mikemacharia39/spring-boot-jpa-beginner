package com.mikehenry.springbootjpabeginner.service;

import com.mikehenry.springbootjpabeginner.model.Employee;
import com.mikehenry.springbootjpabeginner.repository.EmployeeRepository;
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
}
