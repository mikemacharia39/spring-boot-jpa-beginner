package com.mikehenry.springbootjpabeginner.service;

import com.mikehenry.springbootjpabeginner.Utils.Utilities;
import com.mikehenry.springbootjpabeginner.model.Employee;
import com.mikehenry.springbootjpabeginner.repository.EmployeeRepository;
import com.mikehenry.springbootjpabeginner.request.InQueryRequest;
import com.mikehenry.springbootjpabeginner.request.UpdateEmployeePayload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    /**
     * To search employees with first name
     * @param firstName Name of employee
     * @return List of employees
     */
    public List<Employee> getEmployeeByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    /**
     * To get employees with by using firstName in
     * @param inQueryRequest a List containing Strings
     * @return List of employees
     */
    public List<Employee> getEmployeeByFirstNameIn(InQueryRequest inQueryRequest) {
        return employeeRepository.findByFirstNameIn(inQueryRequest.getFirstNames());
    }

    /**
     * To get paginated data. The concept behind pagination is
     * Page   Skip      PageSize
     * 1      0         10
     * 2      10        10
     * 3      20        10
     * n      (n-1)10   10
     *
     * The reason for pageNumber - 1 is because in sql it represents the offset i.e.
     * SELECT * FROM employees LIMIT 10 offset 0 or 1
     *
     * @param pageNumber page
     * @param pageSize  limit
     * @return List of Employees
     */
    public List<Employee> getEmployeeWithPagination(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);

        return employeeRepository.findAll(pageable).getContent();
    }

    /**
     * To return the list of all employees in sorted order
     * You can add multiple sort criteria separated by comma (,) i.e. "employeeID", "firstName" etc
     * @return List of all employees
     */
    public List<Employee> getAllEmployeesSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "employeeID");

        return employeeRepository.findAll(sort);
    }

    /**
     * To return the list of all employees paginated and sorted in DESC with employeeID
     * @return List of all employees
     */
    public List<Employee> getAllEmployeesSortedWithLimit() {
        Pageable pageable = PageRequest.of(0, 1, Sort.Direction.DESC, "employeeID");

        return employeeRepository.findAll(pageable).getContent();
    }

}
