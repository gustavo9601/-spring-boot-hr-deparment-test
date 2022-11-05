package com.springboot.hr.deparment.test.hr.validators.implementation;

import com.springboot.hr.deparment.test.hr.repositories.ContractTypeRepository;
import com.springboot.hr.deparment.test.hr.validators.ExistsContracTypetId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsContractTypeIdValidator implements ConstraintValidator<ExistsContracTypetId, Integer> {
    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return this.contractTypeRepository.existsById(value);
    }
}
