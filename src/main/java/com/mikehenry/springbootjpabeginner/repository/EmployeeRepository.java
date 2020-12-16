package com.mikehenry.springbootjpabeginner.repository;

import com.mikehenry.springbootjpabeginner.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Gets results by firstName only
    List<Employee> findByFirstName(String firstName);

    // Gets results by firstName and lastName
    List<Employee> findByLastNameAndActive(String lastName, int active);

    // Gets results with LIKE using email address
    List<Employee> findByEmailAddressContaining(String emailAddress);

    // Gets result which match either firstName and lastName
    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

    // Gets firstName IN ('x', 'y')
    List<Employee> findByFirstNameIn(List<String> firstNames);
}
