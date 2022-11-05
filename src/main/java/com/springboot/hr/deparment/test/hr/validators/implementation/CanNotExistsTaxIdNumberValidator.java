package com.springboot.hr.deparment.test.hr.validators.implementation;

import com.springboot.hr.deparment.test.hr.repositories.EmployeeRepository;
import com.springboot.hr.deparment.test.hr.validators.CanNotExistsTaxIdNumber;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CanNotExistsTaxIdNumberValidator implements ConstraintValidator<CanNotExistsTaxIdNumber, String> {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (this.employeeRepository.findByTaxIdNumber(value).isPresent()) {
            return false;
        }
        return true;
    }
}
