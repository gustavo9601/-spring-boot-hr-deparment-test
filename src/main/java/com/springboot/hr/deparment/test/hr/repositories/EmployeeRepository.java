package com.springboot.hr.deparment.test.hr.repositories;

import com.springboot.hr.deparment.test.hr.models.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.common.isActive = true")
    List<Employee> findAllEmployeesActive();

    @Query("SELECT e FROM Employee e WHERE e.common.isActive = true AND e.contract.common.isActive = true")
    List<Employee> findAllEmployeesActiveWithContractActive();
}
