package com.springboot.hr.deparment.test.hr.repositories;

import com.springboot.hr.deparment.test.hr.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.common.isActive = true")
    List<Employee> findAllEmployeesActive();

    @Query("SELECT e FROM Employee e WHERE e.common.isActive = true AND e.contract.common.isActive = true")
    List<Employee> findAllEmployeesActiveWithContractActive();

    @Query("SELECT e FROM Employee e WHERE  e.taxIdNumber = :taxIdNumber")
    Optional<Employee> findByTaxIdNumber(@Param(value = "taxIdNumber") String taxIdNumber);
}
