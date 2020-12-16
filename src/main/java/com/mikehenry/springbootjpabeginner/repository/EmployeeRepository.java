package com.mikehenry.springbootjpabeginner.repository;

import com.mikehenry.springbootjpabeginner.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

    @Query("FROM employees WHERE active = :active AND (firstName = :firstName OR lastName = :lastName) AND " +
            "dateCreated > :dateCreated")
    List<Employee> getEmployeeByNamesActiveAndDateCreated(String firstName, String lastName, String dateCreated,
                                                          @Param("active") int activeStatus);


    // @Modifying is used because we are updating | @Transaction represents and ACID process
    // @Modifying return void or Integer
    @Modifying
    @Transactional
    @Query("UPDATE employees SET firstName = :firstName, lastName = :lastName, emailAddress = :emailAddress " +
            "WHERE employeeID = :employeeID")
    Integer updateEmployeeNameAndEmailByID(String firstName, String lastName, @Param("emailAddress") String email,
                                        @Param("employeeID") long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM employees WHERE emailAddress = :emailAddress")
    Integer deleteEmployeeByEmail(String emailAddress);
}
