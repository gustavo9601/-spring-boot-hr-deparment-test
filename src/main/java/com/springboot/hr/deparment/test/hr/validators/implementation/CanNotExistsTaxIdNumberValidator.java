package com.springboot.hr.deparment.test.hr.validators.implementation;

import com.springboot.hr.deparment.test.hr.models.dtos.EmployeeIntDto;
import com.springboot.hr.deparment.test.hr.models.entities.Employee;
import com.springboot.hr.deparment.test.hr.repositories.EmployeeRepository;
import com.springboot.hr.deparment.test.hr.validators.CanNotExistsTaxIdNumber;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class CanNotExistsTaxIdNumberValidator implements ConstraintValidator<CanNotExistsTaxIdNumber, EmployeeIntDto> {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValid(EmployeeIntDto employeeIntDto, ConstraintValidatorContext context) {

        if (employeeIntDto.getId() != null) {
            Optional<Employee> employee = this.employeeRepository.findByTaxIdNumberAndId(employeeIntDto.getTaxIdNumber(), employeeIntDto.getId());
            if (employee.isPresent()) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                        .addPropertyNode("taxIdNumber")
                        .addConstraintViolation();
                return false;
            }
            return true;
        }

        if (this.employeeRepository.findByTaxIdNumber(employeeIntDto.getTaxIdNumber()).isPresent()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("taxIdNumber")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
