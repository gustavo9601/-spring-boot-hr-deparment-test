package com.springboot.hr.deparment.test.hr.validators.implementation;

import com.springboot.hr.deparment.test.hr.repositories.ContractRepository;
import com.springboot.hr.deparment.test.hr.repositories.EmployeeRepository;
import com.springboot.hr.deparment.test.hr.validators.ExistsContractId;
import com.springboot.hr.deparment.test.hr.validators.ExistsEmployeeId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsContractIdValidator implements ConstraintValidator<ExistsContractId, Integer> {
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return this.contractRepository.existsById(value);
    }
}
