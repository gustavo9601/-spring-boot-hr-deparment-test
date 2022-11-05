package com.springboot.hr.deparment.test.hr.validators.implementation;

import com.springboot.hr.deparment.test.hr.repositories.EmployeeRepository;
import com.springboot.hr.deparment.test.hr.validators.ExistsEmployeeId;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ExistsEmployeeIdValidator implements ConstraintValidator<ExistsEmployeeId, Integer> {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return this.employeeRepository.existsById(value);
    }
}
