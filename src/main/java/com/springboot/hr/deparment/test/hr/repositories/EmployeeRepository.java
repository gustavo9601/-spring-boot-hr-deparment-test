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
        // @Query("SELECT e FROM Employee e INNER JOIN e.contract WHERE e.common.isActive = true AND e.contract.common.isActive = true")

       /*@Query(value = "SELECT employee.id, birth_date, cell_phone, employee.created_at, employee.is_active, employee.updated_at, email, last_name, name, tax_id_number\n" +
            "FROM employee  inner join contracts on contracts.employee_id = employee.id and contracts.is_active = true", nativeQuery = true)*/
    List<Employee> findAllEmployeesActiveWithContractActive();

    @Query("SELECT e FROM Employee e WHERE  e.taxIdNumber = :taxIdNumber")
    Optional<Employee> findByTaxIdNumber(@Param(value = "taxIdNumber") String taxIdNumber);

    @Query("SELECT e FROM Employee e WHERE  e.taxIdNumber = :taxIdNumber AND e.id <> :id")
    Optional<Employee> findByTaxIdNumberAndId(@Param(value = "taxIdNumber") String taxIdNumber, @Param(value = "id") Integer id);

}
