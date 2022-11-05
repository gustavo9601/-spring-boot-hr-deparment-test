package com.springboot.hr.deparment.test.hr.repositories;

import com.springboot.hr.deparment.test.hr.models.entities.ContractType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractTypeRepository extends JpaRepository<ContractType, Integer> {
}
