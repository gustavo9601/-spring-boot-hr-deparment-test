package com.springboot.hr.deparment.test.hr.repositories;

import com.springboot.hr.deparment.test.hr.models.entities.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {

    @Query("SELECT c FROM Contract c WHERE c.common.isActive = true AND c.employee.id = :employeeId")
    Optional<Contract> findByActiveAndEmployeeId(@Param(value = "employeeId") Integer integer);
}

