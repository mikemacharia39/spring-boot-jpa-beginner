package com.mikehenry.springbootjpabeginner.controller;


import com.mikehenry.springbootjpabeginner.Utils.Utilities;
import com.mikehenry.springbootjpabeginner.model.Employee;
import com.mikehenry.springbootjpabeginner.request.CreateEmployeePayload;
import com.mikehenry.springbootjpabeginner.request.InQueryRequest;
import com.mikehenry.springbootjpabeginner.request.UpdateEmployeePayload;
import com.mikehenry.springbootjpabeginner.response.EmployeeResponse;
import com.mikehenry.springbootjpabeginner.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Validated
@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("getAll")
    public ResponseEntity<Object> getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        employeeList.stream().forEach(employee -> {
            employeeResponseList.add(new EmployeeResponse(employee));
        });

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully fetched students");
        response.put("data", employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Object> createEmployee(@Valid @RequestBody CreateEmployeePayload employeePayload) {
        Employee employee = new Employee();
        employee.setFirstName(employeePayload.getFirstName());
        employee.setLastName(employeePayload.getLastName());
        employee.setEmailAddress(employeePayload.getEmailAddress());
        employee.setActive(1);

        Optional<Employee> employeeData = employeeService.createEmployee(employee);

        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        employeeData.ifPresent(employeeSave -> {
            employeeResponseList.add(new EmployeeResponse(employeeSave));
        });

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully created employee");
        response.put("data", employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("update")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody UpdateEmployeePayload updateEmployeePayload) {
        Optional<Employee> employeeData = employeeService.updateEmployee(updateEmployeePayload);

        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        employeeData.ifPresent(employeeSave -> {
            employeeResponseList.add(new EmployeeResponse(employeeSave));
        });

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully updated employee");
        response.put("data", employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable("id") long employeeID) {
        employeeService.deleteEmployee(employeeID);

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully deleted employee");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("deactivate/{id}")
    public ResponseEntity<Object> deactivateEmployee(@PathVariable("id") long employeeID) {
        int deactivatedStatus = 3;

        Optional<Employee> employeeData = employeeService.deactivateEmployee(employeeID, deactivatedStatus);

        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        employeeData.ifPresent(employeeSave -> {
            employeeResponseList.add(new EmployeeResponse(employeeSave));
        });

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully deactivated employee");
        response.put("data", employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("searchByFirstName/{firstName}")
    public ResponseEntity<Object> getEmployeeByFirstName(@PathVariable String firstName) {
        List<Employee> employeeList = employeeService.getEmployeeByFirstName(firstName);
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        for (Employee employee : employeeList) {
            employeeResponseList.add(new EmployeeResponse(employee));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully fetched data");
        response.put("data",employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getFirstNamesIn")
    public ResponseEntity<Object> getFirstNamesIn(@RequestBody InQueryRequest inQueryRequest) {
        List<Employee> employeeList = employeeService.getEmployeeByFirstNameIn(inQueryRequest);
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        for (Employee employee : employeeList) {
            employeeResponseList.add(new EmployeeResponse(employee));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully fetched data");
        response.put("data",employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getEmployeeWithPagination")
    public ResponseEntity<Object> getEmployeeWithPagination(@RequestParam(name = "pageNo") int pageNumber,
                                          @RequestParam(name = "size", required = false, defaultValue = "10") int pageSize) {

        List<Employee> employeeList = employeeService.getEmployeeWithPagination(pageNumber, pageSize);
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        for(Employee employee : employeeList) {
            employeeResponseList.add(new EmployeeResponse(employee));
        }

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully fetched data");
        response.put("data",employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getAllEmployeesSorted")
    public ResponseEntity<Object> getAllEmployeesSorted() {
        List<Employee> employeeList = employeeService.getAllEmployeesSorted();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        employeeList.stream().forEach(employee -> {
            employeeResponseList.add(new EmployeeResponse(employee));
        });

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully fetched employees");
        response.put("data", employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("getAllEmployeesSortedLimitWithLimit")
    public ResponseEntity<Object> getAllEmployeesPaginatedSorted() {
        List<Employee> employeeList = employeeService.getAllEmployeesSortedWithLimit();
        List<EmployeeResponse> employeeResponseList = new ArrayList<>();

        employeeList.stream().forEach(employee -> {
            employeeResponseList.add(new EmployeeResponse(employee));
        });

        Map<String, Object> response = new HashMap<>();
        response.put("statusCode", 1);
        response.put("message", "successfully fetched employees");
        response.put("data", employeeResponseList);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
